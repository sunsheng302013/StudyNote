/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.util;

import com.cq.common.enums.ResultCode;

/**
 * 基础控制类
 *
 * @since 2018年9月5日 上午10:06:08
 * @author chengq
 *
 */
public class BaseController {

    /** 工具类避免实例化 **/
    protected BaseController() {
    }

    private static final int ERROR_CODE = 500;

    private static final int SUCCESS_CODE = 200;

    /**
     * 发送成功消息（带数据）
     *
     * @param <T>
     *            对象类型
     * @param data
     *            返回数据
     * @return 架构组规定JackYunResponse结构体
     */
    public static <T> JackYunResponse<T> sendSuccessData(T data) {
        JackYunResponse<T> response = new JackYunResponse<T>();

        JackYunResult<T> jackYunResult = new JackYunResult<T>();
        jackYunResult.setData(data);

        response.setCode(SUCCESS_CODE);
        response.setSubCode("");
        response.setMsg(ResultCode.SUCCESS.getMsg());
        response.setResult(jackYunResult);
        return response;
    }

    /**
     * 发送成功消息（不带数据）
     *
     * @param <T>
     *            对象类型
     * @return 架构组规定JackYunResponse结构体
     */
    public static <T> JackYunResponse<T> sendSuccess() {
        return sendSuccessData(null);
    }

    /**
     * 发送错误消息
     *
     * @param <T>
     *            对象类型
     * @param code
     *            错误编码
     * @param error
     *            错误信息
     * @return 架构组规定JackYunResponse结构体
     */
    public static <T> JackYunResponse<T> sendFailure(String code, String error) {
        return sendFailure(code, error, null);
    }

    /**
     * 发送错误消息
     *
     * @param <T>
     *            对象类型
     * @param code
     *            错误编码
     * @param error
     *            错误信息
     * @param data
     *            数据类型
     * @return 架构组规定JackYunResponse结构体
     */
    public static <T> JackYunResponse<T> sendFailure(String code, String error, T data) {
        JackYunResponse<T> response = new JackYunResponse<T>();

        JackYunResult<T> jackYunResult = new JackYunResult<T>();
        jackYunResult.setData(data);

        response.setCode(ERROR_CODE);
        response.setSubCode(code);
        response.setMsg(error);
        response.setResult(jackYunResult);

        return response;
    }

    /**
     * 发送错误消息
     *
     * @param resultCode
     *            错误编码
     * @return 架构组规定JackYunResponse结构体
     */
    public static JackYunResponse<Object> sendFailure(ResultCode resultCode) {
        return sendFailure(resultCode.getCode(), resultCode.getMsg(), null);
    }

    /**
     * 发送错误消息
     *
     * @param <T>
     *            对象类型
     * @param resultCode
     *            返回值
     * @param data
     *            数据
     * @return 架构组规定JackYunResponse结构体
     */
    public static <T> JackYunResponse<T> sendFailure(ResultCode resultCode, T data) {
        return sendFailure(resultCode.getCode(), resultCode.getMsg(), data);
    }

}
