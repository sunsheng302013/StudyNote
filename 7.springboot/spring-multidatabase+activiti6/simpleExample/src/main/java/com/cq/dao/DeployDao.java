/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cq.dto.ExamineResultDTO;
import com.cq.dto.FlowDTO;
import com.cq.model.DepartInfo;
import com.cq.model.Form;
import com.cq.model.NodeCondition;
import com.cq.model.User;

/**
 * @since 2018年8月24日 下午1:36:44
 * @author huangyi
 *
 */
public interface DeployDao {

    /**
     * 查询流程和流程下节点信息
     * 
     * @return
     */
    FlowDTO getFlow(Long flowId);

    /**
     * 根据nodeId查询node的条件信息
     * 
     * @param list
     * @return
     */
    List<NodeCondition> listCondition(List<Long> list);

    /**
     * 更新processId 到流程表中
     * 
     * @param processKey
     * @param flowId
     * @return
     */
    Integer updateProcessId(@Param("processKey") String processKey, @Param("flowId") Long flowId);

    /**
     * 获取表单根据ID
     * 
     * @param formId
     * @return
     */
    Form getForm(Integer formId);

    /**
     * 获取表单根据ID带流程名称
     * 
     * @param formId
     * @return
     */
    ExamineResultDTO getFormByFormId(Integer formId);

    /***
     * 根据部门Id 和岗位ID确定具体用户
     * 
     * @param user
     * @return
     */
    User getUserByDepartmentIdAndPostionId(User user);

    /**
     * 根据部门ID查询部门
     * 
     * @param departId
     * @return
     */
    DepartInfo getDepartment(Long departId);

}
