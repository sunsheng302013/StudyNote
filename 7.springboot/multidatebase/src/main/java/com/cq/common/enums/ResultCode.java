/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.enums;

/**
 * @since 2018年9月5日 上午10:28:19
 * @author chengq
 *
 */
public enum ResultCode {

    /**
     * 第1位：预留字段，默认0
     *
     * 2,3位：系统大类（仓储作业系统WMS：05）
     *
     * 4,5位：模块 (系统级公共错误为00,设置-库区目录01，设置-货位目录02，设置-周转策略03，设置-分配策略04，设置-波次策略05，设置-补货策略06，设置-上架策略07,
     * 出库验货12)
     *
     * 6位：错误等级0~9，从低到高
     *
     * 7到10位：错误码
     *
     * 接口返回信息枚举类型
     */
    // common
    /** 操作成功 **/
    SUCCESS("200", "操作成功"),

    /** 操作失败 **/
    ERROR("500", "操作失败"),

    /** 内部错误，请稍后重试 **/
    INTERNAL_ERROR("0050090001", "内部错误，请稍后重试"),

    /** 参数错误 **/
    PARAMETER_ERROR("0050090002", "参数错误"),

    /** 参数超过长度限制 **/
    PARAMETER_LENGTH_FLOW("0050090003", "参数超过长度限制"),

    /** 密码错误 **/
    REPEAT_PRINT_LOGIN_FAIL("0050090004", "密码错误"),

    /** 流程已发布 无法删除 **/
    HAD_DEPLOY("0050090005", "流程已发布 无法删除"),;
    private String code;
    private String msg;

    /**
     *
     * @param code
     *            要设置的code
     * @param msg
     *            要设置的msg
     */
    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            要设置的 code
     */
    public void setCode(String code) {
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

}
