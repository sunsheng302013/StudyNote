/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.task;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2018年11月20日
 * @author chengq
 */
public class TaskDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -5320252676384988242L;

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
     *            要设置的 memId
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
     *            要设置的 memName
     */
    public void setMemName(String memName) {
        this.memName = memName;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            要设置的 userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            要设置的 userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName
     *            要设置的 serviceName
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
     *            要设置的 taskType
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
     *            要设置的 taskId
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
     *            要设置的 autoRunFreq
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
     *            要设置的 autoRunInterval
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
     *            要设置的 autoRunStarttime
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
     *            要设置的 autoRunEndtime
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
     *            要设置的 runTimes
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
     *            要设置的 params
     */
    public void setParams(Map<String, Object> params) {
        this.params = params;
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

}
