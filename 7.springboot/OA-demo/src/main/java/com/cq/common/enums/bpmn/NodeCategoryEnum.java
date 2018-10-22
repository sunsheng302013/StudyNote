/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.enums.bpmn;

/**
 * @since 2018年8月24日 下午3:36:01
 * @author huangyi
 *
 */
public enum NodeCategoryEnum {

    /** 开始事件 **/
    STARTEVENT(1, "开始事件"),

    /** 用户任务 **/
    USERTASK(2, "用户任务"),

    /** 排他网关 **/
    EXCLUSIVEGATEWAY(3, "排它网关"),

    /** 并行网关 **/
    PARALLELGATEWAY(4, "并行网关"),

    /** 结束事件 **/
    ENDEVENT(10, "结束事件"),;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * @param code
     * @param msg
     */
    NodeCategoryEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
