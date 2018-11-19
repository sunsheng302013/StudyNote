/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.base;

/**
 * 返回存储实体和分页信息的类
 *
 * @since 2018年1月11日 下午3:46:04
 * @author CaiYH
 * @param <T>
 *            通用类型
 */
public class JackYunResult<T> {

    /** 业务数据封装 **/
    private T data;

    /** 请求流水号 **/
    private String contextId = String.valueOf(-1L);

    /** 构造函数 **/
    public JackYunResult() {
        Long loggerSn = CommonContextHolder.getLoggerSn();
        this.contextId = String.valueOf(loggerSn);
    }

    /** getter & setter **/

    /**
     * 返回结果集（带数据）
     *
     * @param <T>
     *            通用类型
     * @param data
     *            业务数据
     * @return 返回结果集
     */
    public static <T> JackYunResult<T> buildJackYunResult(T data) {

        JackYunResult<T> result = new JackYunResult<>();

        result.setData(data);

        return result;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data
     *            要设置的 data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the contextId
     */
    public String getContextId() {
        return contextId;
    }

    /**
     * @param contextId
     *            要设置的 contextId
     */
    public void setContextId(String contextId) {
        this.contextId = contextId;
    }

}
