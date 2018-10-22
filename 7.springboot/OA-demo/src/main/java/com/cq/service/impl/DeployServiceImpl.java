/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.annotation.DS;
import com.cq.common.enums.bpmn.BpmnEnum;
import com.cq.common.enums.bpmn.ConditionExpressionEnum;
import com.cq.common.enums.bpmn.ExclusiveGatewayEnum;
import com.cq.common.enums.bpmn.NodeCategoryEnum;
import com.cq.common.enums.bpmn.ProcessEnum;
import com.cq.common.enums.bpmn.SequenceFlowEnum;
import com.cq.common.enums.bpmn.StartEventEnum;
import com.cq.common.enums.bpmn.UserTaskEnum;
import com.cq.dao.DeployDao;
import com.cq.dto.FlowDTO;
import com.cq.model.FlowNode;
import com.cq.model.NodeCondition;
import com.cq.service.DeployService;

/**
 * @since 2018年8月24日 上午10:47:12
 * @author huangyi
 *
 */
@Service
public class DeployServiceImpl implements DeployService {

    /*** 部署文件后缀名 ***/
    private static final String FILENAME_SUFFIX = ".bpmn20.xml";

    /*** 部署文件路径 ***/
    private static final String FILEPATH = ".\\src\\main\\webapp\\processes\\";

    /** 用户任务名称 **/
    private static final String USERTASK = "usertask";

    /** 连线名称 **/
    private static final String FLOW = "flow";

    /** 排他网关 **/
    private static final String EXCLUSIVEGATEWAY = "exclusivegateway";

    /** 并行网关 **/
    private static final String PARALLELGATEWAY = "parallelgateway";

    /** 结束事件 **/
    private static final String ENDEVENT = "endEvent";

    @Autowired
    private DeployDao deployDao;

    @Override
    @DS
    public void deploy(Long flowId) {
        // 查询流程已经流程节点
        FlowDTO flow = deployDao.getFlow(flowId);
        List<FlowNode> nodes = flow.getNodes();
        Map<Long, FlowNode> nodeMap = nodes.stream().collect(Collectors.toMap(FlowNode::getNodeId, p -> p));
        List<Long> nodeIdList = nodes.stream().map(FlowNode::getNodeId).collect(Collectors.toList());
        // 查询流程下所有节点的条件
        List<NodeCondition> listCondition = deployDao.listCondition(nodeIdList);
        // 按照节点分组流向条件
        Map<Long, List<NodeCondition>> nodeConditionMap = new HashMap<>();
        for (NodeCondition nodeCondition : listCondition) {
            Long nodeId = nodeCondition.getNodeId();
            if (nodeConditionMap.containsKey(nodeId)) {
                nodeConditionMap.get(nodeId).add(nodeCondition);
            } else {
                List<NodeCondition> temp = new ArrayList<>();
                temp.add(nodeCondition);
                nodeConditionMap.put(nodeId, temp);
            }
        }
        String fileName = write(nodes, flow, nodeConditionMap, nodeMap);
        // 根据bpmn文件部署流程
        // repositoryService.createDeployment().addClasspathResource("\\processes\\" + fileName +
        // FILENAME_SUFFIX).deploy();
        deployDao.updateProcessId(fileName, flowId);
    }

    /**
     * 生成流程文件
     * 
     * @return 文件名称
     */
    public String write(List<FlowNode> nodes, FlowDTO flow, Map<Long, List<NodeCondition>> nodeConditionMap, Map<Long, FlowNode> nodeMap) {
        /** 设置xml节点ID数字初始值 **/
        Integer sequenceFlowIndex = 1;
        // uuid作为生成文件的名称
        Long xmlId = new Date().getTime();
        // 判断文件是否存在，不存在为其创建properties文件
        // String fileName = flow.getFlowId().toString() + FILENAME_SUFFIX;
        String fileName = xmlId.toString() + FILENAME_SUFFIX;
        Path filePath = Paths.get(FILEPATH + fileName);
        if (Files.exists(filePath)) {
            try {
                Files.delete(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!Files.exists(filePath)) {
            // 不存在创建
            // windows下不支持PosixFilePermission来指定rwx权限。
            try {
                Files.createFile(filePath);
                File file = Paths.get(FILEPATH + fileName).toFile();
                Document doc = DocumentHelper.createDocument();
                // 增加根节点definitions
                Element definitions = doc.addElement("definitions");
                // 为子节点添加属性
                // 第一个属性名称前加上了空格，如果不加空格会出现覆盖的情况
                definitions.addAttribute(" xmlns", "http://www.omg.org/spec/BPMN/20100524/MODEL");
                definitions.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
                definitions.addAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
                definitions.addAttribute("xmlns:activiti", "http://activiti.org/bpmn");
                definitions.addAttribute("xmlns:bpmndi", "http://www.omg.org/spec/BPMN/20100524/DI");
                definitions.addAttribute("xmlns:omgdc", "http://www.omg.org/spec/DD/20100524/DC");
                definitions.addAttribute("xmlns:omgdi", "http://www.omg.org/spec/DD/20100524/DI");
                definitions.addAttribute("typeLanguage", "http://www.w3.org/2001/XMLSchema");
                definitions.addAttribute("expressionLanguage", "http://www.w3.org/1999/XPath");
                definitions.addAttribute("targetNamespace", "http://www.activiti.org/test");
                /*** 业务处理 ***/
                // 声明流程
                Element process = definitions.addElement(BpmnEnum.PROCESS.getTag());
                process.addAttribute(ProcessEnum.ID.getTag(), "myProcess" + xmlId.toString());
                process.addAttribute(ProcessEnum.NAME.getTag(), flow.getFlowName());
                process.addAttribute(ProcessEnum.ISEXECUTABLE.getTag(), "true");

                for (FlowNode flowNode : nodes) {
                    Long nodeId = flowNode.getNodeId();
                    Integer category = flowNode.getCategory();
                    List<NodeCondition> conditionsList = nodeConditionMap.get(nodeId);

                    if (NodeCategoryEnum.STARTEVENT.getCode().equals(category)) {
                        /***** 开始节点 ******/
                        String sourceId = "startevent" + nodeId;
                        Element startEvent = process.addElement(BpmnEnum.STARTEVENT.getTag());
                        startEvent.addAttribute(StartEventEnum.ID.getTag(), sourceId);
                        startEvent.addAttribute(StartEventEnum.NAME.getTag(), "Start");
                        // 添加连线
                        Element sequenceFlow = process.addElement(BpmnEnum.SEQUENCEFLOW.getTag());
                        sequenceFlow.addAttribute(SequenceFlowEnum.ID.getTag(), "flow" + sequenceFlowIndex);
                        sequenceFlowIndex++;
                        sequenceFlow.addAttribute(SequenceFlowEnum.SOURCEREF.getTag(), sourceId);
                        // 设置下一节点的指向
                        NodeCondition condition = conditionsList.get(0);
                        Long nextNodeId = condition.getNextNodeId();
                        FlowNode nextFlowNode = nodeMap.get(nextNodeId);
                        Integer nextFlowNodeCategory = nextFlowNode.getCategory();
                        if (NodeCategoryEnum.USERTASK.getCode().equals(nextFlowNodeCategory)) {
                            // 用户任务
                            sequenceFlow.addAttribute(SequenceFlowEnum.TARGETREF.getTag(), USERTASK + nextNodeId);
                        } else if (NodeCategoryEnum.EXCLUSIVEGATEWAY.getCode().equals(nextFlowNodeCategory)) {
                            // 排它网关
                            sequenceFlow.addAttribute(SequenceFlowEnum.TARGETREF.getTag(), EXCLUSIVEGATEWAY + nextNodeId);
                        } else if (NodeCategoryEnum.PARALLELGATEWAY.getCode().equals(nextFlowNodeCategory)) {
                            // 并行网关
                            sequenceFlow.addAttribute(SequenceFlowEnum.TARGETREF.getTag(), PARALLELGATEWAY + nextNodeId);
                        } else if (NodeCategoryEnum.ENDEVENT.getCode().equals(nextFlowNodeCategory)) {
                            // 结束节点
                            sequenceFlow.addAttribute(SequenceFlowEnum.TARGETREF.getTag(), "endevent" + nextNodeId);
                        }
                    } else if (NodeCategoryEnum.USERTASK.getCode().equals(category)) {
                        /***** 用户节点 ******/
                        String sourceId = USERTASK + nodeId;
                        String assignee = "${user" + nodeId + "}";
                        Element userTask = process.addElement(BpmnEnum.USERTASK.getTag());
                        userTask.addAttribute(UserTaskEnum.ID.getTag(), sourceId);
                        userTask.addAttribute(UserTaskEnum.NAME.getTag(), flowNode.getNodeName());
                        userTask.addAttribute(UserTaskEnum.ACTIVITIASSIGNEE.getTag(), assignee);
                        // 添加连线
                        Element sequenceFlow = process.addElement(BpmnEnum.SEQUENCEFLOW.getTag());
                        sequenceFlow.addAttribute(SequenceFlowEnum.ID.getTag(), "flow" + sequenceFlowIndex);
                        sequenceFlowIndex++;
                        sequenceFlow.addAttribute(SequenceFlowEnum.SOURCEREF.getTag(), sourceId);
                        // 设置下一节点的指向
                        NodeCondition condition = conditionsList.get(0);
                        Long nextNodeId = condition.getNextNodeId();
                        FlowNode nextFlowNode = nodeMap.get(nextNodeId);
                        Integer nextFlowNodeCategory = nextFlowNode.getCategory();
                        if (NodeCategoryEnum.USERTASK.getCode().equals(nextFlowNodeCategory)) {
                            // 用户任务
                            sequenceFlow.addAttribute(SequenceFlowEnum.TARGETREF.getTag(), USERTASK + nextNodeId);
                        } else if (NodeCategoryEnum.EXCLUSIVEGATEWAY.getCode().equals(nextFlowNodeCategory)) {
                            // 排它网关
                            sequenceFlow.addAttribute(SequenceFlowEnum.TARGETREF.getTag(), EXCLUSIVEGATEWAY + nextNodeId);
                        } else if (NodeCategoryEnum.PARALLELGATEWAY.getCode().equals(nextFlowNodeCategory)) {
                            // 并行网关
                            sequenceFlow.addAttribute(SequenceFlowEnum.TARGETREF.getTag(), PARALLELGATEWAY + nextNodeId);
                        } else if (NodeCategoryEnum.ENDEVENT.getCode().equals(nextFlowNodeCategory)) {
                            // 结束节点
                            sequenceFlow.addAttribute(SequenceFlowEnum.TARGETREF.getTag(), "endevent" + nextNodeId);
                        }
                    } else if (NodeCategoryEnum.EXCLUSIVEGATEWAY.getCode().equals(category)) {
                        /******* 排它网关 *********/
                        String sourceId = EXCLUSIVEGATEWAY + nodeId;
                        Element exclusivegateway = process.addElement(BpmnEnum.EXCLUSIVEGATEWAY.getTag());
                        exclusivegateway.addAttribute(ExclusiveGatewayEnum.ID.getTag(), sourceId);
                        exclusivegateway.addAttribute(ExclusiveGatewayEnum.NAME.getTag(), "Exclusive Gateway");

                        for (NodeCondition condition : conditionsList) {
                            // 网关条件表达式
                            String expression = ConditionExpressionEnum.VALUE_START.getTag() + condition.getFormAttribute() + condition.getOperateCondition()
                                    + condition.getFormValue() + ConditionExpressionEnum.VALUE_END.getTag();
                            Long nextNodeId = condition.getNextNodeId();
                            FlowNode nextFlowNode = nodeMap.get(nextNodeId);
                            Integer nextFlowNodeCategory = nextFlowNode.getCategory();

                            // 添加连线
                            Element sequenceFlow = process.addElement(BpmnEnum.SEQUENCEFLOW.getTag());
                            sequenceFlow.addAttribute(SequenceFlowEnum.ID.getTag(), FLOW + sequenceFlowIndex);
                            // sequenceFlow节点名称 ID ++
                            sequenceFlowIndex++;
                            sequenceFlow.addAttribute(SequenceFlowEnum.SOURCEREF.getTag(), sourceId);

                            if (NodeCategoryEnum.USERTASK.getCode().equals(nextFlowNodeCategory)) {
                                // 用户任务
                                sequenceFlow.addAttribute(SequenceFlowEnum.TARGETREF.getTag(), USERTASK + nextNodeId);
                                // 条件判断节点
                                Element conditionExpression = sequenceFlow.addElement(BpmnEnum.CONDITIONEXPRESSION.getTag());
                                conditionExpression.setText(expression);
                                conditionExpression.addAttribute(ConditionExpressionEnum.XSITYPE.getTag(), "tFormalExpression");
                            } else if (NodeCategoryEnum.EXCLUSIVEGATEWAY.getCode().equals(nextFlowNodeCategory)) {
                                // 排他网关
                                sequenceFlow.addAttribute(SequenceFlowEnum.TARGETREF.getTag(), EXCLUSIVEGATEWAY + nextNodeId);
                                // 条件判断节点
                                Element conditionExpression = sequenceFlow.addElement(BpmnEnum.CONDITIONEXPRESSION.getTag());
                                conditionExpression.setText(expression);
                                conditionExpression.addAttribute(ConditionExpressionEnum.XSITYPE.getTag(), "tFormalExpression");
                            } else if (NodeCategoryEnum.PARALLELGATEWAY.getCode().equals(nextFlowNodeCategory)) {
                                // 并行网关
                                sequenceFlow.addAttribute(SequenceFlowEnum.TARGETREF.getTag(), PARALLELGATEWAY + nextNodeId);
                                // 条件判断节点
                                Element conditionExpression = sequenceFlow.addElement(BpmnEnum.CONDITIONEXPRESSION.getTag());
                                conditionExpression.setText(expression);
                                conditionExpression.addAttribute(ConditionExpressionEnum.XSITYPE.getTag(), "tFormalExpression");
                            } else if (NodeCategoryEnum.ENDEVENT.getCode().equals(nextFlowNodeCategory)) {
                                // 结束节点
                                sequenceFlow.addAttribute(SequenceFlowEnum.TARGETREF.getTag(), ENDEVENT + nextNodeId);
                                // 条件判断节点
                                Element conditionExpression = sequenceFlow.addElement(BpmnEnum.CONDITIONEXPRESSION.getTag());
                                conditionExpression.setText(expression);
                                conditionExpression.addAttribute(ConditionExpressionEnum.XSITYPE.getTag(), "tFormalExpression");
                            }
                        }
                    } else if (NodeCategoryEnum.PARALLELGATEWAY.getCode().equals(category)) {
                        // 并行网关
                        String sourceId = PARALLELGATEWAY + nodeId;
                        Element parallelgateway = process.addElement(BpmnEnum.PARALLELGATEWAY.getTag());
                        parallelgateway.addAttribute(ExclusiveGatewayEnum.ID.getTag(), sourceId);
                        parallelgateway.addAttribute(ExclusiveGatewayEnum.NAME.getTag(), "Parallel Gateway");
                        // 添加流转连线
                        for (NodeCondition nodeCondition : conditionsList) {
                            // 设置来源节点信息
                            Element sequenceFlow = process.addElement(BpmnEnum.SEQUENCEFLOW.getTag());
                            sequenceFlow.addAttribute(SequenceFlowEnum.ID.getTag(), FLOW + sequenceFlowIndex);
                            sequenceFlow.addAttribute(SequenceFlowEnum.SOURCEREF.getTag(), sourceId);
                            sequenceFlowIndex++;
                            // 设置流向节点信息
                            Long nextNodeId = nodeCondition.getNextNodeId();
                            FlowNode nextFlowNode = nodeMap.get(nextNodeId);
                            Integer nextFlowNodeCategory = nextFlowNode.getCategory();
                            if (NodeCategoryEnum.USERTASK.getCode().equals(nextFlowNodeCategory)) {
                                // 用户任务
                                sequenceFlow.addAttribute(SequenceFlowEnum.TARGETREF.getTag(), USERTASK + nextNodeId);
                            } else if (NodeCategoryEnum.EXCLUSIVEGATEWAY.getCode().equals(nextFlowNodeCategory)) {
                                // 排它网关
                                sequenceFlow.addAttribute(SequenceFlowEnum.TARGETREF.getTag(), EXCLUSIVEGATEWAY + nextNodeId);
                            } else if (NodeCategoryEnum.PARALLELGATEWAY.getCode().equals(nextFlowNodeCategory)) {
                                // 并行网关
                                sequenceFlow.addAttribute(SequenceFlowEnum.TARGETREF.getTag(), PARALLELGATEWAY + nextNodeId);
                            } else if (NodeCategoryEnum.ENDEVENT.getCode().equals(nextFlowNodeCategory)) {
                                // 结束节点
                                sequenceFlow.addAttribute(SequenceFlowEnum.TARGETREF.getTag(), "endevent" + nextNodeId);
                            }
                        }
                    } else if (NodeCategoryEnum.ENDEVENT.getCode().equals(category)) {
                        // 结束节点
                        Element endEvent = process.addElement(BpmnEnum.ENDEVENT.getTag());
                        endEvent.addAttribute(StartEventEnum.ID.getTag(), "endevent" + nodeId);
                        endEvent.addAttribute(StartEventEnum.NAME.getTag(), "End");
                    }
                }
                // 实例化输出格式对象
                OutputFormat format = OutputFormat.createPrettyPrint();
                // 设置输出编码
                format.setEncoding("UTF-8");
                // 生成XMLWriter对象，构造函数中的参数为需要输出的文件流和格式
                XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
                // 开始写入，write方法中包含上面创建的Document对象
                writer.write(doc);
            } catch (IOException e) {
                throw new RuntimeException("创建资源文件失败");
            }
        }
        return xmlId.toString();
    }

}
