/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service;

import java.util.List;

import com.cq.dto.FlowNodeDTO;
import com.cq.model.FlowNode;

/**
 * 流程节点操作
 *
 * @since 2018年8月24日 下午3:03:07
 * @author chengq
 *
 */
public interface FlowNodeService {

    /**
     * 保存节点
     *
     * @param flowNode
     */
    public void saveNode(FlowNode flowNode);

    /**
     * 更新节点
     *
     * @param flowNode
     * @return
     */
    public Integer updateNode(FlowNodeDTO flowNode);

    /**
     * 删除节点
     *
     * @param id
     * @return
     */
    public Integer deleteNode(Long nodeId);

    /**
     * 添加节点到流转配置页面
     *
     * @param flowNode
     * @return
     */
    public Integer addNodeToCondition(FlowNodeDTO flowNode);

    /**
     * 查询在流转配置页的节点
     *
     * @param flowId
     * @return
     */
    public List<FlowNodeDTO> selectNodeInCondition(Long flowId);

    /**
     * 删除在流转配置页的节点
     *
     * @param nodeId
     */
    public void deleteNodeInCondition(Long nodeId);

    /**
     * 根据类别获取步骤名称
     *
     * @param category
     * @param flowId
     * @return
     */
    List<FlowNodeDTO> selectStepNameByCategory(Integer category, Long flowId);

    /**
     * 根据类别获取节点
     *
     * @param flowId
     * @param category
     * @return
     */
    public List<FlowNodeDTO> selectByFlowIdCategory(Long flowId, Integer category);

}
