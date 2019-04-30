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

    /** serialVersionUID */
    private static final long serialVersionUID = -4514832086002722755L;

    private String code;

    private String msg;

    private Integer required;

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

    /**
     * @return the required
     */
    public Integer getRequired() {
        return required;
    }

    /**
     * @param required
     *            要设置的 required
     */
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
