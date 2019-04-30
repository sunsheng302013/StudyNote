/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.model.task;

import java.io.Serializable;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年1月8日
 * @author chengq
 */
public class Task implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 2292784648584499394L;

    private Long id;

    /** 任务名称 **/
    private String jobName;

    /** 任务分组 **/
    private String jobGroup;

    /** 任务状态 **/
    private String jobStatus;

    /** 任务执行方法 **/
    private String jobClass;

    /** cron 表达式 **/
    private String cronExpression;

    /** 任务描述 **/
    private String jobDescription;

    /** 时区 **/
    private String timeZoneId;

    /****/
    private Long startTime;

    /****/
    private Long endTime;

    /** 状态 **/
    private String state;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            要设置的 id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the jobName
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * @param jobName
     *            要设置的 jobName
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * @return the jobGroup
     */
    public String getJobGroup() {
        return jobGroup;
    }

    /**
     * @param jobGroup
     *            要设置的 jobGroup
     */
    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    /**
     * @return the jobStatus
     */
    public String getJobStatus() {
        return jobStatus;
    }

    /**
     * @param jobStatus
     *            要设置的 jobStatus
     */
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    /**
     * @return the jobClass
     */
    public String getJobClass() {
        return jobClass;
    }

    /**
     * @param jobClass
     *            要设置的 jobClass
     */
    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    /**
     * @return the cronExpression
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * @param cronExpression
     *            要设置的 cronExpression
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    /**
     * @return the jobDescription
     */
    public String getJobDescription() {
        return jobDescription;
    }

    /**
     * @param jobDescription
     *            要设置的 jobDescription
     */
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    /**
     * @return the timeZoneId
     */
    public String getTimeZoneId() {
        return timeZoneId;
    }

    /**
     * @param timeZoneId
     *            要设置的 timeZoneId
     */
    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    /**
     * @return the startTime
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     *            要设置的 startTime
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public Long getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     *            要设置的 endTime
     */
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     *            要设置的 state
     */
    public void setState(String state) {
        this.state = state;
    }

}
