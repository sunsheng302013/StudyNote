/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cq.common.util.BaseController;
import com.cq.common.util.JackYunResponse;
import com.cq.dto.ExamineDTO;
import com.cq.dto.ExamineResultDTO;
import com.cq.dto.WorkFlowDTO;
import com.cq.model.FlowHistory;
import com.cq.model.UserFlow;
import com.cq.service.ApplyService;

/**
 * @since 2018年9月5日 上午9:40:42
 * @author chengq
 *
 */
@RestController
@RequestMapping("/oa")
public class ApplyController extends BaseController {

    @Autowired
    private ApplyService applyService;

    /**
     * 审批流程
     * 
     * @param examine
     *            审批DTO
     * @return data
     */
    @PostMapping("/examine")
    public JackYunResponse<Object> examine(ExamineDTO examine) {
        applyService.examine(examine);
        return sendSuccess();
    }

    /**
     * 到审批界面
     * 
     * @param taskId
     *            任务Id
     * @return
     */
    @PostMapping("/toexamine")
    public JackYunResponse<Object> toExamine(String taskId) {
        ExamineResultDTO examine = applyService.toExamine(taskId);
        return sendSuccessData(examine);
    }

    /**
     * 查询用户的待办任务
     */
    @PostMapping("/findtasklistbyname")
    public JackYunResponse<Object> findTaskListByName() {
        List<WorkFlowDTO> findTaskListByName = applyService.findTaskListByName("");
        return sendSuccessData(findTaskListByName);
    }

    /**
     * 查询用户的待办任务
     */
    @PostMapping("/historylist")
    public JackYunResponse<Object> historyList(UserFlow userFlow) {
        List<FlowHistory> listFlowHistory = applyService.listFlowHistory(userFlow);
        return sendSuccessData(listFlowHistory);
    }

}
