/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.dto;

import java.io.Serializable;

/**
 * @since 2018年8月29日 下午4:29:49
 * @author xiejy
 *
 */
public class FormDTO implements Serializable {

    private static final long serialVersionUID = 4576380995890697540L;

    private Integer id;

    private Long flowId;

    private String applyTime;

    private String startTime;

    private String endTime;

    private Float days;

    private String memo;

    private Long userId;

    private String userName;

    private String flowName;

    /** 1审批中 2 已经审批 3 驳回 **/
    private Integer status;

    /**
     * @return the flowId
     */
    public Long getFlowId() {
        return flowId;
    }

    /**
     * @param flowId
     *            the flowId to set
     */
    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    /**
     * @return the applyTime
     */
    public String getApplyTime() {
        return applyTime;
    }

    /**
     * @param applyTime
     *            the applyTime to set
     */
    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     *            the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     *            the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the days
     */
    public Float getDays() {
        return days;
    }

    /**
     * @param days
     *            the days to set
     */
    public void setDays(Float days) {
        this.days = days;
    }

    /**
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo
     *            the memo to set
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the flowName
     */
    public String getFlowName() {
        return flowName;
    }

    /**
     * @param flowName
     *            the flowName to set
     */
    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

}
