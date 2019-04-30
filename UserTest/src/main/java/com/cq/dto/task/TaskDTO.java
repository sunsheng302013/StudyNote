/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.dto.task;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * <p>
 * 类描述:定时任务参数类
 * </p>
 *
 * @since 2018年11月8日
 * @author xiejy
 */
public class TaskDTO implements Serializable {
    private static final long serialVersionUID = 3780354709296995646L;

    /**
     * 会员名
     */
    private Long memId;

    /**
     * 会员名
     */
    private String memName;

    /** 用户ID **/
    private Long userId;

    /** 用户名 **/
    private String userName;

    /**
     * 任务来源服务名称
     */
    private String serviceName;

    /**
     * 任务类型
     */
    private String taskType;

    /**
     * 任务id
     */
    private Long taskId;

    /**
     * 执行频率 0仅一次, 1固定时间 , 2时间间隔
     */
    private Integer autoRunFreq;

    /**
     * 执行间隔（分）
     */
    private Integer autoRunInterval;

    /**
     * 开始时间
     */
    private String autoRunStarttime;

    /**
     * 结束时间
     */
    private String autoRunEndtime;

    /**
     * 固定执行时间点
     */
    private List<String> runTimes;

    /**
     * 任务执行参数
     */
    private Map<String, Object> params;

    /**
     * 自定义cron表达式
     */
    private String cron;

    /**
     * @return the memId
     */
    public Long getMemId() {
        return memId;
    }

    /**
     * @param memId
     *            the memId to set
     */
    public void setMemId(Long memId) {
        this.memId = memId;
    }

    /**
     * @return the memName
     */
    public String getMemName() {
        return memName;
    }

    /**
     * @param memName
     *            the memName to set
     */
    public void setMemName(String memName) {
        this.memName = memName;
    }

    /**
     * @return the serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName
     *            the serviceName to set
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * @return the taskType
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * @param taskType
     *            the taskType to set
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    /**
     * @return the taskId
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * @param taskId
     *            the taskId to set
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * @return the autoRunFreq
     */
    public Integer getAutoRunFreq() {
        return autoRunFreq;
    }

    /**
     * @param autoRunFreq
     *            the autoRunFreq to set
     */
    public void setAutoRunFreq(Integer autoRunFreq) {
        this.autoRunFreq = autoRunFreq;
    }

    /**
     * @return the autoRunInterval
     */
    public Integer getAutoRunInterval() {
        return autoRunInterval;
    }

    /**
     * @param autoRunInterval
     *            the autoRunInterval to set
     */
    public void setAutoRunInterval(Integer autoRunInterval) {
        this.autoRunInterval = autoRunInterval;
    }

    /**
     * @return the autoRunStarttime
     */
    public String getAutoRunStarttime() {
        return autoRunStarttime;
    }

    /**
     * @param autoRunStarttime
     *            the autoRunStarttime to set
     */
    public void setAutoRunStarttime(String autoRunStarttime) {
        this.autoRunStarttime = autoRunStarttime;
    }

    /**
     * @return the autoRunEndtime
     */
    public String getAutoRunEndtime() {
        return autoRunEndtime;
    }

    /**
     * @param autoRunEndtime
     *            the autoRunEndtime to set
     */
    public void setAutoRunEndtime(String autoRunEndtime) {
        this.autoRunEndtime = autoRunEndtime;
    }

    /**
     * @return the runTimes
     */
    public List<String> getRunTimes() {
        return runTimes;
    }

    /**
     * @param runTimes
     *            the runTimes to set
     */
    public void setRunTimes(List<String> runTimes) {
        this.runTimes = runTimes;
    }

    /**
     * @return the params
     */
    public Map<String, Object> getParams() {
        return params;
    }

    /**
     * @param params
     *            the params to set
     */
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userId
     *            要设置的 userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @param userName
     *            要设置的 userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the cron
     */
    public String getCron() {
        return cron;
    }

    /**
     * @param cron
     *            要设置的 cron
     */
    public void setCron(String cron) {
        this.cron = cron;
    }

    /**
     * toString
     *
     * @return String
     */
    @Override
    public String toString() {
        return "TaskDTO [memId=" + memId + ", memName=" + memName + ", userId=" + userId + ", userName=" + userName + ", serviceName=" + serviceName
                + ", taskType=" + taskType + ", taskId=" + taskId + ", autoRunFreq=" + autoRunFreq + ", autoRunInterval=" + autoRunInterval
                + ", autoRunStarttime=" + autoRunStarttime + ", autoRunEndtime=" + autoRunEndtime + ", runTimes=" + runTimes + ", params=" + params + "]";
    }

}
