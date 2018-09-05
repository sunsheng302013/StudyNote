/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.enums.bpmn;

/**
 * 流程部署文件conditionExpression标签枚举
 * 
 * @since 2018年8月24日 上午11:31:38
 * @author huangyi
 *
 */
public enum ConditionExpressionEnum {

    /** xsi:type **/
    XSITYPE("xsi:type"),

    /** 条件开始前缀 **/
    VALUE_START("${"),

    /** 条件结束前缀 **/
    VALUE_END("}"),

    ;

    /** 标签 **/
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * @param tag
     */
    private ConditionExpressionEnum(String tag) {
        this.tag = tag;
    }

}
