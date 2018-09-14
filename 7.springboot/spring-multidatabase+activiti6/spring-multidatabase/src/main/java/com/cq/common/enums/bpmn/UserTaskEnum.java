/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.enums.bpmn;

/**
 * 流程部署文件userTask标签枚举
 * 
 * @since 2018年8月24日 上午11:31:38
 * @author huangyi
 *
 */
public enum UserTaskEnum {

    /** 标签ID **/
    ID("id"),

    /** 标签，名称 **/
    NAME("name"),

    /** 代理人 **/
    ACTIVITIASSIGNEE("activiti:assignee"),

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
    private UserTaskEnum(String tag) {
        this.tag = tag;
    }

}
