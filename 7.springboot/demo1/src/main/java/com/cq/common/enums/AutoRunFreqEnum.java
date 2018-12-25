package com.cq.common.enums;

/**
 * 定时任务执行频率
 *
 * @Author: xus
 * @Description:
 * @Date: Created in 2017-12-12 11:54
 */
public enum AutoRunFreqEnum implements CodeEnum {

    /** 仅一次 **/
    ONCE(0, "仅一次"),

    /** 固定时间 **/
    FIXED_TIME(1, "固定时间"),

    /** 时间间隔 **/
    INTERVAL_TIME(2, "时间间隔"),

    /** CRON表达式 **/
    CUSTOM_CRON(10, "CRON表达式"),;

    private Integer code;
    private String msg;

    /**
     *
     * @param code
     *            code
     * @param msg
     *            msg
     */
    AutoRunFreqEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @return the code
     */
    @Override
    public Integer getCode() {
        return code;
    }

    /**
     * @return the msg
     */
    @Override
    public String getMsg() {
        return msg;
    }

    /**
     * @param code
     *            要设置的 code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @param msg
     *            要设置的 msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
