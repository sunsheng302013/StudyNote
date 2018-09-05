/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service;

import java.util.List;

import com.cq.dto.NodeConditionDTO;
import com.cq.model.NodeCondition;

/**
 * @since 2018年8月27日 下午2:07:36
 * @author chengq
 *
 */

public interface NodeConditionService {

    /**
     * 添加流转配置项
     *
     * @param nodeCondition
     */
    public void saveNodeCondition(List<Integer> positionIdList, NodeCondition nodeCondition);

    /**
     * 更新流转配置项
     *
     * @param nodeCondition
     * @return
     */
    public void updateNodeCondition(List<Integer> positionIdList, NodeCondition nodeCondition);

    /**
     * 根据nodeId查询节点流转配置项
     *
     * @param nodeId
     * @return
     */
    public List<NodeConditionDTO> selectNodeCondition(Long nodeId);

    /**
     * 删除节点流转配置
     *
     * @param id
     */
    public void deleteNodeCondition(Integer id);

}
