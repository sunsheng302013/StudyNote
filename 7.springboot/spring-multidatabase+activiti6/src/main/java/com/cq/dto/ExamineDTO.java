/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.dto;

import java.io.Serializable;

/**
 * 审批DTO
 * 
 * @since 2018年8月29日 上午11:27:32
 * @author huangyi
 *
 */
public class ExamineDTO implements Serializable {

    private static final long serialVersionUID = 8718930135560437231L;

    /** 审批意见 **/
    private String comment;

    /** 同于 o 驳回 1 **/
    private Integer examineType;

    /** 审批的流程 **/
    private Long flowId;

    /**
     * 当前任务ID
     */
    private String taskId;

    private String taskName;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getExamineType() {
        return examineType;
    }

    public void setExamineType(Integer examineType) {
        this.examineType = examineType;
    }

    @Override
    public String toString() {
        return "ExamineDTO [comment=" + comment + ", examineType=" + examineType + ", flowId=" + flowId + ", taskId=" + taskId + "]";
    }

}
