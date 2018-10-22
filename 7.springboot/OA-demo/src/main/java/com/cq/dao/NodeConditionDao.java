package com.cq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cq.dto.NodeConditionDTO;
import com.cq.model.NodeCondition;

@Mapper
public interface NodeConditionDao {

    /**
     * 新建流转配置项
     *
     * @param nodeCondition
     */
    public void insertNodeCondition(NodeCondition nodeCondition);

    /**
     * 更新流转配置项
     *
     * @param nodeCondition
     */
    public Integer updateNodeCondition(NodeCondition nodeCondition);

    /**
     * 根据nodeId查询流转配置项
     *
     * @param nodeId
     * @return
     */
    public List<NodeConditionDTO> listNodeCondition(@Param(value = "nodeId") Long nodeId);

    /**
     * 根据id删除流转配置项
     *
     * @param id
     */
    public void deleteNodeCondition(@Param(value = "id") Integer id);

    /**
     * 根据nodeId获取只想该节点的流转配置项
     *
     * @param nodeId
     * @return
     */
    public List<NodeCondition> getLastNodeCondition(@Param(value = "nodeId") Long nodeId);
}