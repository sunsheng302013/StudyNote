package com.cq.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cq.model.UserFlow;

@Mapper
public interface UserFlowDao {

    /**
     * 删除用户流程关联表
     * 
     * @param userFlow
     * @return
     */
    Integer delete(UserFlow userFlow);

    /**
     * 批量删除用户流程关联表
     * 
     * @param list
     * @return
     */
    Integer batchDelete(List<Integer> list);

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
    Integer updateNextNodeId(Map<String, Object> map);

    /**
     * 获取用户流程关联表 by businessKey
     * 
     * @param businessKey
     * @return
     */
    List<UserFlow> getUserFlow(Map<String, Object> map);

    /**
     * 获取用户流程关联表Id by businessKey
     * 
     * @param businessKey
     * @return
     */
    Long getFormId(Long businessKey);

    /**
     * 查询业务key 根据 userId flowId formId
     * 
     * @param userFlow
     * @return
     */
    UserFlow getUserFlowBusinesKey(UserFlow userFlow);
}