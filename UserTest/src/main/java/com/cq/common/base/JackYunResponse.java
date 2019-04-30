/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.base;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 接口返回结果
 *
 * @since 2018年1月4日 下午4:27:27
 * @author CaiYH
 * @param <T>
 *            通用类型
 */
public class JackYunResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 成功的返回码 **/
    @JsonIgnore
    public static final int SUCCESS = 200;

    private int code;

    private String subCode;

    private String msg = "";

    private JackYunResult<T> result;

    /**
     * 返回成功,根据subCode填充提示信息
     *
     * @param <T>
     *            通用类型
     * @param subCode
     *            错误码
     * @return 返回结果
     */
    public static <T> JackYunResponse<T> sendSuccess(String subCode) {
        JackYunResponse<T> result = new JackYunResponse<>();
        result.setCode(SUCCESS);
        result.setSubCode(subCode);
        result.setResult(new JackYunResult<>());
        return result;
    }

    /**
     * 返回成功，自定义提示信息
     *
     * @param <T>
     *            通用类型
     * @param subCode
     *            错误码
     * @param message
     *            错误信息
     * @return 返回结果
     */
    public static <T> JackYunResponse<T> sendSuccess(String subCode, String message) {
        JackYunResponse<T> result = new JackYunResponse<>();
        result.setCode(SUCCESS);
        result.setSubCode(subCode);
        result.setMsg(message);
        result.setResult(new JackYunResult<>());
        return result;
    }

    /**
     * 发送成功消息,根据subCode填充提示信息（带数据）
     *
     * @param <T>
     *            通用类型
     * @param data
     *            业务数据
     * @param subCode
     *            错误码
     * @return 返回结果
     */
    public static <T> JackYunResponse<T> sendSuccessData(String subCode, JackYunResult<T> data) {
        JackYunResponse<T> result = new JackYunResponse<>();
        result.setCode(SUCCESS);
        result.setSubCode(subCode);
        result.setResult(data);
        return result;
    }

    /**
     * 发送成功消息,自定义填充提示信息（带数据）
     *
     * @param <T>
     *            通用类型
     * @param subCode
     *            错误码
     * @param message
     *            错误信息
     * @param data
     *            业务数据
     * @return 返回结果
     */
    public static <T> JackYunResponse<T> sendSuccessData(String subCode, String message, JackYunResult<T> data) {
        JackYunResponse<T> result = new JackYunResponse<>();
        result.setCode(SUCCESS);
        result.setSubCode(subCode);
        result.setMsg(message);
        result.setResult(data);
        return result;
    }

    /**
     * 发送错误消息,根据subCode填充提示信息
     *
     * @param <T>
     *            通用类型
     * @param code
     *            200成功 xxx失败
     * @param subCode
     *            错误编码
     * @return 返回结果
     */
    public static <T> JackYunResponse<T> sendFailure(int code, String subCode) {
        JackYunResponse<T> result = new JackYunResponse<>();
        result.setCode(code);
        result.setSubCode(subCode);
        result.setResult(new JackYunResult<>());
        return result;
    }

    /**
     * 发送错误消息,自定义填充提示信息
     *
     * @param <T>
     *            通用类型
     * @param code
     *            200成功 xxx失败
     * @param subCode
     *            错误编码
     * @param error
     *            错误信息
     * @return 返回结果
     */
    public static <T> JackYunResponse<T> sendFailure(int code, String subCode, String error) {
        JackYunResponse<T> result = new JackYunResponse<>();
        result.setCode(code);
        result.setSubCode(subCode);
        result.setMsg(error);
        result.setResult(new JackYunResult<>());
        return result;
    }

    /**
     * 是否调用成功
     *
     * @return true or false
     */
    @JsonIgnore
    public boolean isSuccess() {
        return SUCCESS == this.code;
    }

    /**
     * 打印返回结果
     */
    @JsonIgnore
    public void print() {
        System.out.println(JSON.toJSONString(this));
    }

    /**
     * 返回数据
     *
     * @return 数据
     */
    @JsonIgnore
    public T getData() {

        if (null != this.result) {
            return result.getData();
        }

        return null;
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

    /**
     * @return the subCode
     */
    public String getSubCode() {
        return subCode;
    }

    /**
     * @param subCode
     *            要设置的 subCode
     */
    public void setSubCode(String subCode) {
        this.subCode = subCode;
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
     * @return the result
     */
    public JackYunResult<T> getResult() {
        return result;
    }

    /**
     * @param result
     *            要设置的 result
     */
    public void setResult(JackYunResult<T> result) {
        this.result = result;
    }

}
