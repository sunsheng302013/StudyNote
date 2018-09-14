/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.annotation.DS;
import com.cq.dao.DepartPositionDao;
import com.cq.dao.FlowNodeDao;
import com.cq.dao.NodeConditionDao;
import com.cq.dto.FlowNodeDTO;
import com.cq.dto.NodeConditionDTO;
import com.cq.model.NodeCondition;
import com.cq.service.NodeConditionService;

/**
 * @since 2018年8月27日 下午2:10:27
 * @author chengq
 *
 */
@Service
public class NodeConditionServiceImpl implements NodeConditionService {

    @Autowired
    NodeConditionDao nodeConditionDao;

    @Autowired
    DepartPositionDao departPositionDao;

    @Autowired
    FlowNodeDao flowNodeDao;

    @Override
    @DS
    public void saveNodeCondition(List<Integer> positionIdList, NodeCondition nodeCondition) {

        if (positionIdList != null && positionIdList.size() > 0) {
            for (Integer positionId : positionIdList) {
                nodeCondition.setFormAttribute("positionId");
                nodeCondition.setOperateCondition("==");
                nodeCondition.setFormValue(String.valueOf(positionId));
                nodeConditionDao.insertNodeCondition(nodeCondition);
            }
        } else {
            nodeConditionDao.insertNodeCondition(nodeCondition);
        }
    }

    @Override
    @DS
    public void updateNodeCondition(List<Integer> positionIdList, NodeCondition nodeCondition) {
        if (positionIdList != null && positionIdList.size() > 0) {
            for (Integer positionId : positionIdList) {
                nodeCondition.setFormAttribute("positionId");
                nodeCondition.setOperateCondition("==");
                nodeCondition.setFormValue(String.valueOf(positionId));
                nodeConditionDao.updateNodeCondition(nodeCondition);
            }
        } else {
            nodeConditionDao.updateNodeCondition(nodeCondition);
        }
    }

    @Override
    @DS
    public List<NodeConditionDTO> selectNodeCondition(Long nodeId) {
        List<NodeConditionDTO> nodeConditionList = nodeConditionDao.selectNodeCondition(nodeId);
        for (NodeConditionDTO nodeCondition : nodeConditionList) {
            String operateCondition = "";
            String formAttribute = "";
            String formValue = "";
            if (nodeCondition.getFormAttribute() != null || "null".equals(nodeCondition.getFormAttribute())) {
                formAttribute = nodeCondition.getFormAttribute();
                operateCondition = nodeCondition.getOperateCondition();
                formValue = nodeCondition.getFormValue();
            }

            FlowNodeDTO flowNode = flowNodeDao.selectFlowNodeByNodeId(nodeCondition.getNextNodeId());
            String stepCondition = formAttribute + operateCondition + formValue;
            nodeCondition.setStepCondition(stepCondition);
            nodeCondition.setNextNodeName(flowNode.getNodeName());
            nodeCondition.setCategory(flowNode.getCategory());
        }
        return nodeConditionList;
    }

    @Override
    @DS
    public void deleteNodeCondition(Integer id) {
        nodeConditionDao.deleteNodeCondition(id);
    }

    @Override
    @DS
    public void afterDelete(Long nodeId) {
        List<NodeCondition> lastNodeConditionList = nodeConditionDao.getLastNodeCondition(nodeId);
        List<NodeConditionDTO> nodeConditionList = nodeConditionDao.selectNodeCondition(nodeId);

        for (NodeCondition lastNnodeCondition : lastNodeConditionList) {
            for (NodeConditionDTO nodeCondition : nodeConditionList) {
                NodeCondition nodeConditionValue = new NodeCondition();
                nodeConditionValue.setNodeId(lastNnodeCondition.getNodeId());
                nodeConditionValue.setFormAttribute(lastNnodeCondition.getFormAttribute());
                nodeConditionValue.setFormValue(lastNnodeCondition.getFormValue());
                nodeConditionValue.setOperateCondition(lastNnodeCondition.getOperateCondition());
                nodeConditionValue.setNextNodeId(nodeCondition.getNextNodeId());
                this.saveNodeCondition(null, nodeConditionValue);
                this.deleteNodeCondition(nodeCondition.getId());
            }
            this.deleteNodeCondition(lastNnodeCondition.getId());
        }
        flowNodeDao.deleteNodeById(nodeId);
    }
}
