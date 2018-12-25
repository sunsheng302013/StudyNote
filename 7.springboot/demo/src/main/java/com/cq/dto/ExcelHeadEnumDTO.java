/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.dto;

import java.io.Serializable;

/**
 * @since 2018年3月13日 下午4:51:54
 * @author huangyi
 *
 */
public class ExcelHeadEnumDTO implements Serializable {

    private static final long serialVersionUID = -3556786125903348171L;

    private String code;

    private String msg;

    private Integer required;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getRequired() {
        return required;
    }

    public void setRequired(Integer required) {
        this.required = required;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ExcelHeadEnumDTO [code=");
        builder.append(code);
        builder.append(", msg=");
        builder.append(msg);
        builder.append(", required=");
        builder.append(required);
        builder.append("]");
        return builder.toString();
    }

}
