package com.cq.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cq.model.UserFlow;

@Mapper
public interface UserFlowDao {

    /**
     * 新增用户流程关联表
     * 
     * @param userFlow
     * @return
     */
    Integer insert(UserFlow userFlow);

    /**
     * 更新下一个节点ID
     * 
     * @param userFlow
     * @return
     */
    Integer updateNextNodeId(UserFlow userFlow);

    /**
     * 获取用户流程关联表 by businessKey
     * 
     * @param businessKey
     * @return
     */
    UserFlow getUserFlow(Long businessKey);

    /**
     * 查询业务key 根据 userId flowId formId
     * 
     * @param userFlow
     * @return
     */
    UserFlow getUserFlowBusinesKey(UserFlow userFlow);
}