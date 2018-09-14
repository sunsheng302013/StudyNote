/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.annotation.DS;
import com.cq.dao.DepartPositionDao;
import com.cq.dao.FlowNodeDao;
import com.cq.dao.NodeConditionDao;
import com.cq.dto.FlowNodeDTO;
import com.cq.dto.NodeConditionDTO;
import com.cq.model.FlowNode;
import com.cq.service.FlowNodeService;

/**
 * @since 2018年8月24日 下午3:06:59
 * @author chengq
 *
 */

@Service
public class FlowNodeServiceImpl implements FlowNodeService {

    @Autowired
    FlowNodeDao flowNodeDao;

    @Autowired
    NodeConditionDao nodeConditionDao;

    @Autowired
    DepartPositionDao departPositionDao;

    @Override
    @DS
    public List<FlowNodeDTO> selectStepNameByCategory(Integer category, Long flowId) {
        Map<String, Object> flowNodeMap = new HashMap<String, Object>();
        flowNodeMap.put("category", category);
        flowNodeMap.put("flowId", flowId);
        return flowNodeDao.selectStepName(flowNodeMap);
    }

    @Override
    @DS
    public List<FlowNodeDTO> selectByFlowIdCategory(Long flowId, Integer category) {
        Map<String, Object> flowNodeMap = new HashMap<String, Object>();
        flowNodeMap.put("category", category);
        flowNodeMap.put("flowId", flowId);
        List<FlowNodeDTO> flowNodeList = flowNodeDao.selectByCategory(flowNodeMap);

        for (FlowNodeDTO flowNode : flowNodeList) {
            String participantName = departPositionDao.selectPositionByPositionId(flowNode.getParticipant());
            flowNode.setParticipantName(participantName);
        }
        return flowNodeList;
    }

    @Override
    @DS
    public void saveNode(FlowNode flowNode) {
        // 设定全局唯一的节点ID
        flowNode.setNodeId(new Date().getTime());
        flowNodeDao.saveNode(flowNode);
    }

    @Override
    @DS
    public Integer updateNode(FlowNodeDTO flowNode) {
        return flowNodeDao.updateNode(flowNode);
    }

    @Override
    @DS
    public Integer deleteNode(Long nodeId) {
        if (flowNodeDao.selectCountByNodeId(nodeId) > 0) {
            return 100;
        }
        return flowNodeDao.deleteNodeById(nodeId);
    }

    @Override
    @DS
    public Integer addNodeToCondition(FlowNodeDTO flowNode) {
        return flowNodeDao.addNodeToCondition(flowNode);
    }

    @Override
    @DS
    public List<FlowNodeDTO> selectNodeInCondition(Long flowId) {
        List<FlowNodeDTO> flowNodeList = flowNodeDao.selectNodeInCondition(flowId);
        for (FlowNodeDTO flowNode : flowNodeList) {
            if (flowNode.getParticipant() != null) {
                flowNode.setParticipantName(departPositionDao.selectPositionByPositionId(flowNode.getParticipant()));
            }
        }
        return flowNodeList;
    }

    @Override
    @DS
    public void deleteNodeInCondition(Long nodeId) {
        List<NodeConditionDTO> nodeConditionList = nodeConditionDao.selectNodeCondition(nodeId);
        if (nodeConditionList != null && nodeConditionList.size() > 0) {

        } else {
            flowNodeDao.deleteNodeInCondition(nodeId);
        }
    }
}
