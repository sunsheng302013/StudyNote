package com.cq.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cq.dto.FlowNodeDTO;
import com.cq.model.FlowNode;

@Mapper
public interface FlowNodeDao {

    /**
     * 根据类别获取节点
     *
     * @param map
     * @return
     */
    public List<FlowNodeDTO> selectByCategory(Map<String, Object> map);

    /**
     * 新建流程节点
     *
     * @param flowNode
     */
    public void saveNode(FlowNode flowNode);

    /**
     * 更新流程节点
     *
     * @param flowNode
     * @return
     */
    public Integer updateNode(FlowNodeDTO flowNode);

    /**
     * 根据nodeId删除节点
     *
     * @param nodeId
     * @return
     */
    public Integer deleteNodeById(@Param(value = "nodeId") Long nodeId);

    /**
     * 查询nodeId在流转配置表中的数量
     *
     * @param nodeId
     * @return
     */
    public Integer selectCountByNodeId(@Param(value = "nodeId") Long nodeId);

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
    public List<FlowNodeDTO> selectNodeInCondition(@Param(value = "flowId") Long flowId);

    /**
     * 删除在流转配置页的节点
     *
     * @param nodeId
     */
    public void deleteNodeInCondition(@Param(value = "nodeId") Long nodeId);

    /**
     * 根据类别获取步骤名称
     *
     * @param map
     * @return
     */
    public List<FlowNodeDTO> selectStepName(Map<String, Object> map);

    /**
     * 根据nodeId获取node对象
     * 
     * @param nodeId
     * @return
     */
    public FlowNodeDTO selectFlowNodeByNodeId(@Param(value = "nodeId") Long nodeId);

}