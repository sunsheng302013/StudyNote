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
            if ("positionId".equals(nodeCondition.getFormAttribute())) {
                formAttribute = "岗位";
                operateCondition = "==";
                formValue = departPositionDao.selectPositionByPositionId(Integer.valueOf(nodeCondition.getFormValue()));
            } else {
                formAttribute = nodeCondition.getFormAttribute();
                operateCondition = nodeCondition.getOperateCondition();
                formValue = nodeCondition.getFormValue();
                if ("null".equals(formAttribute) || formAttribute == null) {
                    formAttribute = "";
                }
                if ("null".equals(formValue) || formValue == null) {
                    formValue = "";
                }
                if ("null".equals(operateCondition) || operateCondition == null) {
                    operateCondition = "";
                }
            }

            String stepCondition = formAttribute + operateCondition + formValue;
            nodeCondition.setStepCondition(stepCondition);
            nodeCondition.setNextNodeName(flowNodeDao.getFlowNodeName(nodeCondition.getNextNodeId()));
            nodeCondition.setCategory(flowNodeDao.getCategoryByNodeId(nodeCondition.getNextNodeId()));
        }
        return nodeConditionList;
    }

    @Override
    @DS
    public void deleteNodeCondition(Integer id) {
        nodeConditionDao.deleteNodeCondition(id);
    }
}
