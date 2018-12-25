/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.basic;

/**
 * <p>
 * 类描述:返回结果
 * </p>
 *
 * @since 2018年11月28日
 * @author chengq
 */
public class BaseResult {

    /** 返回编码 **/
    private int resultCode;

    /** 返回消息 **/
    private String resultMessage;

    /**
     * @return the resultCode
     */
    public int getResultCode() {
        return resultCode;
    }

    /**
     * @param resultCode
     *            要设置的 resultCode
     */
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * @return the resultMessage
     */
    public String getResultMessage() {
        return resultMessage;
    }

    /**
     * @param resultMessage
     *            要设置的 resultMessage
     */
    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

}
