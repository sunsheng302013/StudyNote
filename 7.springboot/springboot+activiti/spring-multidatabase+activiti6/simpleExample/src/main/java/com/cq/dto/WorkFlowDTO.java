/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.dto;

import java.io.Serializable;

import com.cq.model.Form;

/**
 * 流程信心
 * 
 * @since 2018年8月10日 下午3:39:43
 * @author huangyi
 *
 */
public class WorkFlowDTO extends Form implements Serializable {

    private static final long serialVersionUID = -744422208978052738L;

    /** 任务ID **/
    private String taskId;

    /** 办理人 **/
    private String approver;

    /** 任务名称 **/
    private String taskName;

    /** 任务的创建时间 **/
    private String taskCreateTime;

    /** 业务ID **/
    private String businessKey;

    /** 用户名 **/
    private String userName;

    private String flowName;

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskCreateTime() {
        return taskCreateTime;
    }

    public void setTaskCreateTime(String taskCreateTime) {
        this.taskCreateTime = taskCreateTime;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    @Override
    public String toString() {
        return "WorkFlowDTO [taskId=" + taskId + ", approver=" + approver + ", taskName=" + taskName + ", taskCreateTime=" + taskCreateTime + ", businessKey="
                + businessKey + ", userName=" + userName + ", flowName=" + flowName + "]";
    }

}
