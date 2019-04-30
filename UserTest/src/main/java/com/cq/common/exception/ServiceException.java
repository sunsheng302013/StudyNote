/**
 * Copyright(C) 2017 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.exception;

import java.util.Map;

import com.cq.common.enums.ResultCode;

/**
 * @since 2017年12月7日 上午10:15:13
 * @author YuanMingEn
 *
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 7877144261233781877L;

    private ResultCode resultCode;
    private Map<String, Object> errorData;

    /**
     *
     * @param resultCode
     *            吉客云结果编码
     */
    public ServiceException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
    }

    /**
     *
     * @param resultCode
     *            吉客云结果编码
     * @param errorData
     *            错误数据
     */
    public ServiceException(ResultCode resultCode, Map<String, Object> errorData) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
        this.errorData = errorData;
    }

    /**
     *
     * @return 吉客云结果编码
     */
    public ResultCode getResultCode() {
        return resultCode;
    }

    /**
     *
     * @param resultCode
     *            吉客云结果编码
     */
    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    /**
     *
     * @return 错误数据
     */
    public Map<String, Object> getErrorData() {
        return errorData;
    }

    /**
     *
     * @param errorData
     *            错误数据
     */
    public void setErrorData(Map<String, Object> errorData) {
        this.errorData = errorData;
    }
}
