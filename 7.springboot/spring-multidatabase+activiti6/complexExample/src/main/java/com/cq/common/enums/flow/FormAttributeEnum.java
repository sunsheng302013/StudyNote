/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.enums.flow;

/**
 * @since 2018年8月29日 上午8:53:23
 * @author huangyi
 *
 */
public enum FormAttributeEnum {

    /** 岗位 **/
    POSITIONID(1, "postionId"),

    /** 请假天数 **/
    DAYS(2, "days"),

    ;
    private Integer code;

    private String attributeName;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    /**
     * @param code
     * @param attributeName
     */
    private FormAttributeEnum(Integer code, String attributeName) {
        this.code = code;
        this.attributeName = attributeName;
    }

}
