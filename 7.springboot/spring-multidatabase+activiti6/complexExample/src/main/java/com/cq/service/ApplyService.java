/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service;

import java.util.List;

import com.cq.dto.ExamineDTO;
import com.cq.dto.ExamineResultDTO;
import com.cq.dto.WorkFlowDTO;
import com.cq.model.FlowHistory;
import com.cq.model.UserFlow;

/**
 * @since 2018年8月28日 下午6:25:50
 * @author huangyi
 *
 */
public interface ApplyService {

    /**
     * 申请流程
     * 
     * @param flowId
     *            流程ID
     * @param formId
     *            申请单据ID
     */
    void apply(Long flowId, Integer formId);

    /**
     * 审批流程
     * 
     * @param examine
     */
    void examine(ExamineDTO examine);

    /**
     * 到流程审批界面
     * 
     * @param taskId
     * @return
     */
    ExamineResultDTO toExamine(String taskId);

    /**
     * 查询当前登录人的办理任务
     * 
     * @param name
     * @return
     */
    List<WorkFlowDTO> findTaskListByName(String name);

    /**
     * 查询审批历史
     * 
     * @param userFlow
     * @return
     */
    List<FlowHistory> listFlowHistory(UserFlow userFlow);

}
