package com.cq.model;

import java.io.Serializable;
import java.util.Date;

public class UserFlow implements Serializable {

    private static final long serialVersionUID = -4139738198025447452L;

    private Integer id;

    private Long businessKey;

    private Long userId;

    private Long flowId;

    private Integer formId;

    private String nextNodeId;

    private Long participantUserId;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(Long businessKey) {
        this.businessKey = businessKey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public String getNextNodeId() {
        return nextNodeId;
    }

    public void setNextNodeId(String strNodeList) {
        this.nextNodeId = strNodeList;
    }

    public Long getParticipantUserId() {
        return participantUserId;
    }

    public void setParticipantUserId(Long participantUserId) {
        this.participantUserId = participantUserId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "UserFlow [id=" + id + ", businessKey=" + businessKey + ", userId=" + userId + ", flowId=" + flowId + ", formId=" + formId + ", nextNodeId="
                + nextNodeId + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
    }
}