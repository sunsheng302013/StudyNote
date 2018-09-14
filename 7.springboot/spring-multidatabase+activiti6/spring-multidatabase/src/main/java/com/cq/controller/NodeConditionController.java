/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cq.common.enums.ResultCode;
import com.cq.common.util.BaseController;
import com.cq.common.util.DeserializationConverter;
import com.cq.common.util.JackYunResponse;
import com.cq.dto.FlowNodeDTO;
import com.cq.dto.NodeConditionDTO;
import com.cq.model.NodeCondition;
import com.cq.service.FlowNodeService;
import com.cq.service.NodeConditionService;

/**
 * 流转配置操作接口
 *
 * @since 2018年8月27日 上午11:26:44
 * @author chengq
 *
 */

@RestController
@RequestMapping(value = "/oa/nodecondition")
public class NodeConditionController extends BaseController {

    @Autowired
    NodeConditionService nodeConditionService;

    @Autowired
    FlowNodeService flowNodeService;

    /**
     * 流转配置页面添加节点
     *
     * @param nodeCondition
     * @return
     */
    @PostMapping("/addflownode")
    public JackYunResponse<Object> addFlowNodeInCondition(FlowNodeDTO flowNode) {
        if (flowNode.getNodeId() == null) {
            return sendFailure(ResultCode.ERROR);
        }
        flowNodeService.addNodeToCondition(flowNode);
        return sendSuccess();
    }

    /**
     * 查询流转配置页节点
     *
     * @param flowId
     * @return
     */
    @PostMapping("/selectflownode")
    public JackYunResponse<Object> selectFlowNodeInCondition(Long flowId) {
        List<FlowNodeDTO> flowNodeList = flowNodeService.selectNodeInCondition(flowId);
        return sendSuccessData(flowNodeList);
    }

    /**
     * 删除流转配置页节点(伪删除，将serial_num置为null)
     *
     * @param nodeId
     * @return
     */
    @PostMapping("/deleteflownode")
    public JackYunResponse<Object> deleteflowNodeInCondition(Long nodeId) {
        flowNodeService.deleteNodeInCondition(nodeId);
        return sendSuccess();
    }

    /**
     * 查询节点流转配置项
     *
     * @param nodeId
     * @return
     */
    @GetMapping("/selectnodecondition")
    public JackYunResponse<Object> selectNodeCondition(Long nodeId) {
        List<NodeConditionDTO> nodeConditionList = nodeConditionService.selectNodeCondition(nodeId);
        return sendSuccessData(nodeConditionList);
    }

    /**
     * 添加节点流转配置项
     *
     * @param nodeCondition
     * @return
     */
    @PostMapping("/savenodecondition")
    public JackYunResponse<Object> saveNodeCondition(String positionIds, NodeCondition nodeCondition) {

        List<Integer> positionIdList = DeserializationConverter.jsonToList(positionIds, Integer.class);
        nodeConditionService.saveNodeCondition(positionIdList, nodeCondition);
        return sendSuccess();
    }

    /**
     * 更新节点流转配置项
     *
     * @param nodeCondition
     * @return
     */
    @PostMapping("/updatenodecondition")
    public JackYunResponse<Object> updateNodeCondition(String positionIds, NodeCondition nodeCondition) {
        List<Integer> positionIdList = DeserializationConverter.jsonToList(positionIds, Integer.class);
        nodeConditionService.updateNodeCondition(positionIdList, nodeCondition);
        return sendSuccess();
    }

    /**
     * 删除节点流转配置
     *
     * @param id
     * @return
     */
    @PostMapping("/deletenodecondition")
    public JackYunResponse<Object> deleteNodeCondition(Integer id) {
        nodeConditionService.deleteNodeCondition(id);
        return sendSuccess();
    }

    /**
     * 移除节点并更新节点配置
     *
     * @param id
     * @return
     */
    @PostMapping("/afterDelete")
    public JackYunResponse<Object> moveAndSet(Long nodeId) {
        nodeConditionService.afterDelete(nodeId);
        return sendSuccess();
    }
}
