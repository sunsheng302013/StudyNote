/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.enums.flow;

/**
 * @since 2018年8月29日 上午8:58:02
 * @author huangyi
 *
 */
public enum OperateConditionEnum {
    /** 等于 **/
    Equal(1, "=="),

    /** 不等于 **/
    NOT_EQUAL_TO(2, "!="),

    /** 大于 **/
    GREATER_THAN(3, ">"),

    /** 小于 **/
    LESS_THAN(4, "<"),

    /** 大于等于 **/
    GTE(5, ">="),

    /** 小于等于 **/
    LTE(4, "<="),

    /** 包含 **/
    INCLUDE(5, "in"),

    ;
    private Integer code;

    private String operateCondition;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getOperateCondition() {
        return operateCondition;
    }

    public void setOperateCondition(String operateCondition) {
        this.operateCondition = operateCondition;
    }

    /**
     * @param code
     * @param operateCondition
     */
    private OperateConditionEnum(Integer code, String operateCondition) {
        this.code = code;
        this.operateCondition = operateCondition;
    }

}
