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
import com.cq.common.util.JackYunResponse;
import com.cq.dto.FlowNodeDTO;
import com.cq.model.FlowNode;
import com.cq.service.FlowNodeService;

/**
 * 流程节点
 *
 * @since 2018年8月24日 下午2:53:44
 * @author chengq
 *
 */
@RestController
@RequestMapping(value = "/oa/flownode")
public class FlowNodeController extends BaseController {

    @Autowired
    FlowNodeService flowNodeService;

    /**
     * 根据步骤类型查询节点
     *
     * @param category
     * @return
     */
    @GetMapping("/selectbycategory")
    public JackYunResponse<Object> selectByCategory(Integer category, Long flowId) {
        List<FlowNodeDTO> flowNodeList = flowNodeService.selectStepNameByCategory(category, flowId);
        return sendSuccessData(flowNodeList);
    }

    /**
     * 查询流程节点
     *
     * @param flowId
     * @return
     */
    @GetMapping("/selectall")
    public JackYunResponse<Object> selectFlowNodeByFlowId(Long flowId, Integer category) {
        List<FlowNodeDTO> flowNodeList = flowNodeService.selectByFlowIdCategory(flowId, category);
        return sendSuccessData(flowNodeList);
    }

    /**
     * 新建流程节点
     *
     * @param flowNode
     * @return
     */
    @PostMapping("/save")
    public JackYunResponse<Object> saveFlowNode(FlowNode flowNode) {
        flowNodeService.saveNode(flowNode);
        return sendSuccess();
    }

    /**
     * 更新节点(节点没有更新功能，接口暂时不用)
     *
     * @param flowNode
     * @return
     */
    @PostMapping("/update")
    public JackYunResponse<Object> updateFlowNode(FlowNodeDTO flowNode) {
        // 更新失败返回错误信息
        if (0 == flowNodeService.updateNode(flowNode)) {
            return sendFailure(ResultCode.ERROR);
        }
        return sendSuccess();
    }

    /**
     * 删除节点
     *
     * @param nodeId
     * @return
     */
    @PostMapping("/delete")
    public JackYunResponse<Object> deleteFlowNode(Long nodeId) {
        flowNodeService.deleteNode(nodeId);
        return sendSuccess();
    }

}
