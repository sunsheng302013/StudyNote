/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.activiti.engine.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.enums.bpmn.NodeCategoryEnum;
import com.cq.common.enums.flow.OperateConditionEnum;
import com.cq.common.util.SessionUtil;
import com.cq.dao.DeployDao;
import com.cq.dao.FlowHistoryDao;
import com.cq.dao.UserFlowDao;
import com.cq.dto.CirculationDTO;
import com.cq.dto.FlowDTO;
import com.cq.model.DepartInfo;
import com.cq.model.FlowNode;
import com.cq.model.Form;
import com.cq.model.NodeCondition;
import com.cq.model.User;
import com.cq.model.UserFlow;

/**
 * @since 2018年9月10日 下午4:51:25
 * @author differ
 *
 */
@Service
public class CirculationServiceImpl {

    @Autowired
    DeployDao deployDao;

    @Autowired
    FlowHistoryDao flowHistoryDao;

    @Autowired
    UserFlowDao userFlowDao;

    @Autowired
    TaskService taskService;

    /**
     * 获取节点代理人
     *
     * @param participant
     * @return
     */
    public User getParticipantUser(Integer participant) {
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
        return participantUser;
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
     * 获取用户任务，排他网关的下一节点
     *
     * @param flow
     * @param node
     * @return
     */
    public FlowNode getAfterNode(FlowDTO flow, FlowNode node, CirculationDTO circulation) {
        Long nodeId = node.getNodeId();
        // 获取流程下节点的对于的条件信息
        Map<Long, List<NodeCondition>> nodesConditionMap = nodesConditionMap(flow);

        // 获取节点条件信息
        List<NodeCondition> conditionsList = nodesConditionMap.get(nodeId);

        // 获取流程下节点
        Map<Long, FlowNode> nodesMap = nodesMap(flow);

        Class<?> clazz = circulation.getClass();
        List<FlowNode> flowNodeList = new ArrayList<FlowNode>();

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
                }
                FlowNode flowNode = nodesMap.get(nextNodeId);
                return flowNode;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取节点的下一节点
     *
     * @param flow
     *            流程Id
     * @param node
     *            当前节点Id
     * @return List<FlowNode>
     */
    public List<FlowNode> getNextNode(FlowDTO flow, FlowNode node, CirculationDTO circulation) {

        Long nodeId = node.getNodeId();
        // 获取流程下节点的对于的条件信息
        Map<Long, List<NodeCondition>> nodesConditionMap = nodesConditionMap(flow);
        // 获取节点条件信息
        List<NodeCondition> conditionsList = nodesConditionMap.get(nodeId);
        // 获取流程下节点
        Map<Long, FlowNode> nodesMap = nodesMap(flow);
        List<FlowNode> flowNodeList = new ArrayList<FlowNode>();

        if (conditionsList != null && conditionsList.size() > 0) {
            for (NodeCondition nodecondition : conditionsList) {
                FlowNode nextNode = nodesMap.get(nodecondition.getNextNodeId());
                // 下一节点如果是排他网关，继续查询下一节点
                while (NodeCategoryEnum.EXCLUSIVEGATEWAY.getCode().equals(nextNode.getCategory())) {
                    nextNode = getAfterNode(flow, nextNode, circulation);
                }
                // 节点是并行网关，查找并行网关下一节点
                if (NodeCategoryEnum.PARALLELGATEWAY.getCode().equals(nextNode.getCategory())) {
                    List<FlowNode> nodeList = getNextNode(flow, nextNode, circulation);
                    flowNodeList.addAll(nodeList);
                    break;
                }
                flowNodeList.add(nextNode);
            }
        }
        return flowNodeList;
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
     * 设置下个节点参与者
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

    /**
     * 查询用户的userFlow表并删除重复表
     * 
     * @param userFlowMap
     * @return
     */
    public UserFlow getUserFlow(Map<String, Object> userFlowMap) {
        List<UserFlow> userFlowList = userFlowDao.getUserFlow(userFlowMap);
        UserFlow userFlow = userFlowList.remove(0);
        if (userFlow != null && userFlowList.size() > 0) {
            List<Integer> list = userFlowList.stream().map(UserFlow -> UserFlow.getId()).collect(Collectors.toList());
            userFlowDao.batchDelete(list);
        }
        return userFlow;
    }
}