/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.exception;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年1月8日
 * @author chengq
 */
public class QuartzException extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = 306443724447887823L;
    private static final Integer CODEVALUE = 500;

    private String msg;
    private int code = CODEVALUE;

    /**
     * 设置定时任务异常信息
     *
     * @param msg
     *            定时任务异常信息
     */
    public QuartzException(String msg) {
        super(msg);
        this.msg = msg;
    }

    /**
     * 设置定时任务异常和异常信息
     *
     * @param msg
     *            定时任务异常信息
     * @param e
     *            定时任务异常
     */
    public QuartzException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    /**
     * 设置定时任务异常值和异常信息
     *
     * @param msg
     *            定时任务异常信息
     * @param code
     *            定时任务异常值
     */
    public QuartzException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    /**
     * 设置定时任务异常,异常值和异常信息
     * 
     * @param msg
     *            定时任务异常信息
     * @param code
     *            定时任务异常值
     * @param e
     *            定时任务异常
     */
    public QuartzException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg
     *            要设置的 msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code
     *            要设置的 code
     */
    public void setCode(int code) {
        this.code = code;
    }

}