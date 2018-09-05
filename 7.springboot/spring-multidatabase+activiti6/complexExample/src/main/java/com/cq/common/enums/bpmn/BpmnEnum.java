/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.enums.bpmn;

/**
 * 流程部署文件生成标签枚举
 * 
 * @since 2018年8月24日 上午11:18:55
 * @author huangyi
 *
 */
public enum BpmnEnum {

    /** 流程 **/
    PROCESS("process"),

    /** 开始事件 **/
    STARTEVENT("startEvent"),

    /** 用户任务 **/
    USERTASK("userTask"),

    /** 流向 **/
    SEQUENCEFLOW("sequenceFlow"),

    /** 排他网关 **/
    EXCLUSIVEGATEWAY("exclusiveGateway"),

    /** 排他网关条件 **/
    CONDITIONEXPRESSION("conditionExpression"),

    /** 结束事件 **/
    ENDEVENT("endEvent"),

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
    private BpmnEnum(String tag) {
        this.tag = tag;
    }

}
