/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cq.common.annotation.DS;
import com.cq.common.enums.bpmn.NodeCategoryEnum;
import com.cq.common.enums.flow.OperateConditionEnum;
import com.cq.common.util.SessionUtil;
import com.cq.dao.DeployDao;
import com.cq.dao.FlowHistoryDao;
import com.cq.dao.FormDao;
import com.cq.dao.UserFlowDao;
import com.cq.dto.CirculationDTO;
import com.cq.dto.ExamineDTO;
import com.cq.dto.ExamineResultDTO;
import com.cq.dto.FlowDTO;
import com.cq.dto.WorkFlowDTO;
import com.cq.model.DepartInfo;
import com.cq.model.FlowHistory;
import com.cq.model.FlowNode;
import com.cq.model.Form;
import com.cq.model.NodeCondition;
import com.cq.model.User;
import com.cq.model.UserFlow;
import com.cq.service.ApplyService;

/**
 * @since 2018年8月28日 下午6:26:07
 * @author huangyi
 *
 */
@Service
public class ApplyServiceImpl implements ApplyService {

    /*** 部署文件后缀名 ***/
    private static final String FILENAME_SUFFIX = ".bpmn20.xml";

    @Autowired
    private UserFlowDao userFlowDao;

    @Autowired
    private DeployDao deployDao;

    @Autowired
    private FormDao formDao;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FlowHistoryDao flowHistoryDao;

    /*** 部署文件路径 ***/
    private static final String FILEPATH = ".\\src\\main\\webapp\\processes\\";

    /**
     * 申请流程
     */
    @Override
    @DS("datasource1")
    @Transactional(rollbackFor = Exception.class)
    public void apply(Long flowId, Integer formId) {
        // 流程Id
        Long businessKey = new Date().getTime();
        // 用户名称
        String username = SessionUtil.get().getUserName();
        // 获取流转DTO
        CirculationDTO circulation = getCirculationDTO(formId);
        /** 部署流程 **/
        FlowDTO flow = deployDao.getFlow(flowId);
        String processkey = flow.getProcesskey();
        // 根据bpmn文件部署流程
        // repositoryService.createDeployment().addClasspathResource("\\processes\\" + processkey +
        // FILENAME_SUFFIX).deploy();
        try {
            File file = Paths.get(FILEPATH + processkey + FILENAME_SUFFIX).toFile();
            InputStream inputStream = new FileInputStream(file);
            repositoryService.createDeployment().addInputStream(processkey + FILENAME_SUFFIX, inputStream).deploy();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 设置受理人变量
        Map<String, Object> variables = new HashMap<>();
        variables.put("user", username);
        // 采用key来启动流程定义并设置流程变量，返回流程实例
        runtimeService.startProcessInstanceByKey("myProcess" + processkey, businessKey.toString(), variables);
        // 注意 这里需要拿登录用户来查询，key-value需要拿value来获取任务
        List<Task> list = taskService.createTaskQuery().taskAssignee(username).list();
        // 获取开始节点
        FlowNode startNode = getStartNode(flow);
        // 获取第一个用户任务
        FlowNode userNode = getNextNode(flow, startNode, circulation);
        while (NodeCategoryEnum.EXCLUSIVEGATEWAY.getCode().equals(userNode.getCategory())) {
            // 如果是排它网关就再获取下一个节点
            userNode = getNextNode(flow, userNode, circulation);
        }
        // 审批历史
        FlowHistory history = new FlowHistory();
        history.setBusinessKey(Long.valueOf(businessKey));
        history.setTaskName(userNode.getNodeName());
        history.setOperateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        history.setOperateDepartment(SessionUtil.get().getMainDepartName());
        history.setOperator(SessionUtil.get().getUserName());
        flowHistoryDao.insert(history);
        // 此节点才是用户申请后的下一节点
        FlowNode nextNode = getNextNode(flow, userNode, circulation);
        while (NodeCategoryEnum.EXCLUSIVEGATEWAY.getCode().equals(nextNode.getCategory())) {
            // 如果是排它网关就再获取下一个节点
            nextNode = getNextNode(flow, nextNode, circulation);
        }
        // 参与者的岗位
        Integer participant = nextNode.getParticipant();
        String participantUserName = getParticipantUserName(participant);
        // 流程流转DTO赋值代理人
        circulation.setUser(participantUserName);
        // 直接完成任务，并赋值下一个节点的受理人
        Map<String, Object> variablesNext = convertObjectToMap(circulation);
        taskService.complete(list.get(0).getId(), variablesNext);
        /** 建立用户流程关联关系 **/
        // 流程的下一流转节点
        FlowNode flowNextNode = getNextNode(flow, nextNode, circulation);
        while (NodeCategoryEnum.EXCLUSIVEGATEWAY.getCode().equals(flowNextNode.getCategory())) {
            // 如果是排它网关就再获取下一个节点
            flowNextNode = getNextNode(flow, flowNextNode, circulation);
        }
        Long userId = SessionUtil.get().getUserId();
        UserFlow userFlow = new UserFlow();
        userFlow.setUserId(userId);
        userFlow.setBusinessKey(businessKey);
        userFlow.setFormId(formId);
        userFlow.setFlowId(flowId);
        userFlow.setNextNodeId(flowNextNode.getNodeId());
        userFlowDao.insert(userFlow);
    }

    /**
     * 流程审批功能
     */
    @Override
    @DS
    @Transactional(rollbackFor = Exception.class)
    public void examine(ExamineDTO examine) {
        // 任务Id
        String taskId = examine.getTaskId();
        /** 同意 0 驳回 1 **/
        Integer examineType = examine.getExamineType();
        // 批注信息
        String comment = examine.getComment();
        if (comment == null || "".equals(comment)) {
            // 如果批注信息是空的话 设置默认
            if (examineType.equals(1)) {
                comment = "驳回";
            } else if (examineType.equals(0)) {
                comment = "同意";
            }
        }
        // 获取流程实例id
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        // 通过流程实例id获取流程实例对象，从而获取businessKey
        String businessKey = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getBusinessKey();

        // 审批历史
        FlowHistory history = new FlowHistory();
        history.setBusinessKey(Long.valueOf(businessKey));
        history.setTaskName(examine.getTaskName());
        history.setOperateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        history.setOperateDepartment(SessionUtil.get().getMainDepartName());
        history.setOperator(SessionUtil.get().getUserName());
        history.setComment(comment);
        flowHistoryDao.insert(history);
        UserFlow userFlow = userFlowDao.getUserFlow(Long.valueOf(businessKey));

        /** 如果是驳回 **/
        if (examineType.equals(1)) {
            // 添加批注信息
            taskService.addComment(taskId, processInstanceId, comment);
            // 删除流程
            runtimeService.deleteProcessInstance(processInstanceId, "流程驳回");
            // 设置流程的状态为驳回
            /** status 1审批中 2 已经审批 3 驳回 **/
            formDao.updateStatus(userFlow.getFormId(), 3);
            // 审批结束
            return;
        }
        /** 同意操作 **/
        // 添加批注信息
        taskService.addComment(taskId, processInstanceId, comment);
        // 设置下一节点的受理人变量

        Long nextNodeId = userFlow.getNextNodeId();
        // 设置流转DTO
        Integer formId = userFlow.getFormId();
        CirculationDTO circulation = getCirculationDTO(formId);
        if (nextNodeId != null) {
            // 获取下一个节点
            FlowDTO flow = deployDao.getFlow(userFlow.getFlowId());
            Map<Long, FlowNode> nodesMap = nodesMap(flow);
            FlowNode flowNode = nodesMap.get(nextNodeId);
            // FlowNode nextNode = getNextNode(flow, flowNode, circulation);
            while (NodeCategoryEnum.EXCLUSIVEGATEWAY.getCode().equals(flowNode.getCategory())) {
                // 如果是排它网关就再获取下一个节点
                flowNode = getNextNode(flow, flowNode, circulation);
            }
            // 参与者的岗位
            Integer participant = flowNode.getParticipant();
            String participantUserName = getParticipantUserName(participant);
            // 流程流转DTO赋值代理人
            circulation.setUser(participantUserName);
            // 直接完成任务，并赋值下一个节点的受理人
            Map<String, Object> variables = convertObjectToMap(circulation);
            // 指定下一个任务的办理人
            taskService.complete(taskId, variables);
            // 流程的下一流转节点
            FlowNode flowNextNode = getNextNode(flow, flowNode, circulation);
            if (flowNextNode != null) {
                while (NodeCategoryEnum.EXCLUSIVEGATEWAY.getCode().equals(flowNextNode.getCategory())) {
                    // 如果是排它网关就再获取下一个节点
                    flowNextNode = getNextNode(flow, flowNextNode, circulation);
                }
                UserFlow userFlowUpdate = new UserFlow();
                userFlowUpdate.setBusinessKey(Long.valueOf(businessKey));
                userFlowUpdate.setNextNodeId(flowNextNode.getNodeId());
                userFlowDao.updateNextNodeId(userFlowUpdate);
            } else {
                UserFlow userFlowUpdate = new UserFlow();
                userFlowUpdate.setBusinessKey(Long.valueOf(businessKey));
                userFlowUpdate.setNextNodeId(null);
                userFlowDao.updateNextNodeId(userFlowUpdate);
            }
        } else {
            // 指定下一个任务的办理人
            Map<String, Object> variables = convertObjectToMap(circulation);
            taskService.complete(taskId, variables);
        }
        // 判断流程是否结束
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
                .processInstanceId(processInstanceId)// 使用流程实例ID查询
                .singleResult();
        if (null == pi) {
            // 更新请假单状态
            // 设置流程的状态为驳回
            /** status 1审批中 2 已经审批 3 驳回 **/
            UserFlow userFlowUpdate = userFlowDao.getUserFlow(Long.valueOf(businessKey));
            formDao.updateStatus(userFlowUpdate.getFormId(), 2);
        }
    }

    /**
     * 设置审批界面
     */
    @Override
    @DS
    public ExamineResultDTO toExamine(String taskId) {
        // 获取流程实例id
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        // 通过流程实例id获取流程实例对象，从而获取businessKey
        String businessKey = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getBusinessKey();
        UserFlow userFlow = userFlowDao.getUserFlow(Long.valueOf(businessKey));
        ExamineResultDTO form = deployDao.getFormByFormId(userFlow.getFormId());
        List<FlowHistory> historyList = flowHistoryDao.listByKey(Long.valueOf(businessKey));
        form.setHistoryList(historyList);
        return form;
    }

    /**
     * 用户待审批流程
     */
    @Override
    @DS
    public List<WorkFlowDTO> findTaskListByName(String name) {
        name = SessionUtil.get().getUserName();
        List<Task> list = taskService.createTaskQuery().taskAssignee(name).orderByTaskCreateTime().asc().list();
        List<WorkFlowDTO> resultList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (org.activiti.engine.task.Task task : list) {
                // 通过流程实例id获取流程实例对象，从而获取businessKey
                String businessKey = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult().getBusinessKey();
                // 查询出申请单据
                WorkFlowDTO flowDTO = new WorkFlowDTO();
                flowDTO.setTaskId(task.getId());
                flowDTO.setApprover(task.getAssignee());
                flowDTO.setTaskName(task.getName());
                flowDTO.setTaskCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(task.getCreateTime()));
                flowDTO.setBusinessKey(businessKey);
                // flowDTO.setFlowId(task.getProcessInstanceId());
                UserFlow userFlow = userFlowDao.getUserFlow(Long.valueOf(businessKey));
                ExamineResultDTO form = deployDao.getFormByFormId(userFlow.getFormId());
                BeanUtils.copyProperties(form, flowDTO);
                resultList.add(flowDTO);
            }
        }
        return resultList;
    }

    @Override
    @DS
    public List<FlowHistory> listFlowHistory(UserFlow userFlow) {

        UserFlow userflow = userFlowDao.getUserFlowBusinesKey(userFlow);
        Long businessKey = userflow.getBusinessKey();
        List<FlowHistory> flowHistories = flowHistoryDao.listByKey(businessKey);

        return flowHistories;
    }

    /**
     * 获取节点代理人
     *
     * @param participant
     * @return
     */
    public String getParticipantUserName(Integer participant) {
        Long userDepartmentId = SessionUtil.get().getMainDepartId();
        // 部门ID岗位ID确定则知道具体代理人是谁
        User userQuery = new User();
        userQuery.setMainDepartId(userDepartmentId);
        userQuery.setPositionId(participant);
        User participantUser = deployDao.getUserByDepartmentIdAndPostionId(userQuery);
        // 如果查不到就向上循环查找
        while (participantUser == null) {
            DepartInfo department = deployDao.getDepartment(userDepartmentId);
            Long parentId = department.getParentId();
            if (parentId != 0) {
                userQuery.setMainDepartId(parentId);
                userQuery.setPositionId(participant);
                participantUser = deployDao.getUserByDepartmentIdAndPostionId(userQuery);
                userDepartmentId = parentId;
            } else if (parentId == 0) {
                // 上级部门ID是0的话 还没有找到 就直接查询岗位
                userQuery.setMainDepartId(null);
                userQuery.setPositionId(participant);
                participantUser = deployDao.getUserByDepartmentIdAndPostionId(userQuery);
            }
        }
        String participantUserName = participantUser.getUserName();
        return participantUserName;
    }

    /**
     * 设置流转DTO
     *
     * @param formId
     * @return
     */
    public CirculationDTO getCirculationDTO(Integer formId) {
        // 岗位ID
        Integer positionId = SessionUtil.get().getPositionId();
        // 获取表单
        Form form = deployDao.getForm(formId);
        CirculationDTO circulation = new CirculationDTO();
        // 设置岗位
        circulation.setPositionId(positionId);
        BeanUtils.copyProperties(form, circulation);
        return circulation;
    }

    /**
     * 查询流程的开始节点
     *
     * @param flow
     *            流程
     * @return
     */
    public FlowNode getStartNode(FlowDTO flow) {
        List<FlowNode> nodes = flow.getNodes();
        // 起始节点
        FlowNode startNode = null;
        for (FlowNode flowNode : nodes) {
            if (NodeCategoryEnum.STARTEVENT.getCode().equals(flowNode.getCategory())) {
                startNode = flowNode;
                break;
            }
        }
        return startNode;
    }

    /**
     * 获取流程节点的下一节点
     *
     * @param flow
     * @param node
     * @return
     */
    public FlowNode getNextNode(FlowDTO flow, FlowNode node, CirculationDTO circulation) {
        Long nodeId = node.getNodeId();
        // 获取流程下节点的对于的条件信息
        Map<Long, List<NodeCondition>> nodesConditionMap = nodesConditionMap(flow);

        // 获取节点条件信息
        List<NodeCondition> conditionsList = nodesConditionMap.get(nodeId);

        // 获取流程下节点
        Map<Long, FlowNode> nodesMap = nodesMap(flow);

        Class<?> clazz = circulation.getClass();

        try {
            if (conditionsList != null && conditionsList.size() == 1) {
                Long nextNodeId = conditionsList.get(0).getNextNodeId();
                FlowNode flowNode = nodesMap.get(nextNodeId);
                return flowNode;
            } else if (conditionsList != null && conditionsList.size() > 1) {
                Long nextNodeId = null;
                for (NodeCondition nodeCondition : conditionsList) {
                    String formAttribute = nodeCondition.getFormAttribute();
                    String formValue = nodeCondition.getFormValue();
                    // 通过反射得到流程中流转的条件判断表单字段
                    Field field = clazz.getDeclaredField(formAttribute);
                    field.setAccessible(true);
                    Object fieldValue = field.get(circulation);
                    // 将所有的比较转换为float类型
                    Float compareStart = Float.valueOf(fieldValue.toString());
                    Float compareEnd = Float.valueOf(formValue);
                    /***** 判断比较字符 *****/
                    nextNodeId = compareFormAttributeValue(compareStart, compareEnd, nodeCondition);
                    if (nextNodeId != null) {
                        break;
                    }
                    // for end
                }
                FlowNode flowNode = nodesMap.get(nextNodeId);
                return flowNode;
                // else if end
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 将对象转换为map
     *
     * @param object
     * @return
     */
    public static Map<String, Object> convertObjectToMap(Object object) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Class<?> clazz = object.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                if (fields[i].get(object) != null) {
                    Object value = fields[i].get(object);
                    String fldSetName = fields[i].getName();
                    if (!"serialVersionUID".equals(fldSetName)) {
                        resultMap.put(fldSetName, value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    /**
     * 比较表单属性值与节点条件值返回下一节点
     *
     * @param compareStart
     * @param compareEnd
     * @param nodeCondition
     * @return
     */
    public Long compareFormAttributeValue(Float compareStart, Float compareEnd, NodeCondition nodeCondition) {
        Long nextNodeId = null;
        String operateCondition = nodeCondition.getOperateCondition();
        if (OperateConditionEnum.Equal.getOperateCondition().equals(operateCondition)) {
            // 如果比较字符是==
            if (compareStart.equals(compareEnd)) {
                nextNodeId = nodeCondition.getNextNodeId();
            }
        } else if (OperateConditionEnum.GREATER_THAN.getOperateCondition().equals(operateCondition)) {
            // 如果比较字符是>
            if (compareStart > compareEnd) {
                nextNodeId = nodeCondition.getNextNodeId();
            }
        } else if (OperateConditionEnum.LESS_THAN.getOperateCondition().equals(operateCondition)) {
            // 如果比较字符是>
            if (compareStart < compareEnd) {
                nextNodeId = nodeCondition.getNextNodeId();
            }
        } else if (OperateConditionEnum.GTE.getOperateCondition().equals(operateCondition)) {
            // 如果比较字符是>=
            if (compareStart >= compareEnd) {
                nextNodeId = nodeCondition.getNextNodeId();
            }
        } else if (OperateConditionEnum.LTE.getOperateCondition().equals(operateCondition)) {
            // 如果比较字符是<=
            if (compareStart <= compareEnd) {
                nextNodeId = nodeCondition.getNextNodeId();
            }
        }
        // demo暂时只考虑这几种情况 其它情况可以再定义
        return nextNodeId;
    }

    /**
     * 获取流程下所有节点
     *
     * @param flow
     * @return
     */
    public Map<Long, FlowNode> nodesMap(FlowDTO flow) {
        List<FlowNode> nodes = flow.getNodes();
        Map<Long, FlowNode> nodeMap = nodes.stream().collect(Collectors.toMap(FlowNode::getNodeId, p -> p));
        return nodeMap;
    }

    /**
     * 获取节点的条件
     *
     * @param flow
     * @return
     */
    public Map<Long, List<NodeCondition>> nodesConditionMap(FlowDTO flow) {
        List<FlowNode> nodes = flow.getNodes();
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
        return nodeConditionMap;
    }

    public static void main(String[] args) {
        CirculationDTO circulationDTO = new CirculationDTO();
        circulationDTO.setDays(Float.valueOf("100"));
        Map<String, Object> convertObjectToMap = convertObjectToMap(circulationDTO);
        System.out.println(convertObjectToMap);
    }

}
