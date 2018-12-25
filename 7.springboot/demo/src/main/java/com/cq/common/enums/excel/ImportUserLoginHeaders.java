/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.excel;

import com.cq.common.enums.ImportExcelEnumInterface;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2018年11月26日
 * @author chengq
 */
public enum ImportUserLoginHeaders implements ImportExcelEnumInterface {

    USERID("userId", "人员ID", 1),

    USERLOGINID("userLoginId", "登录帐号", 1),

    PASSWORD("password", "密码", 1),

    ISDELETED("isDeleted", "是否删除", 1);

    private String code;
    private String msg;
    private Integer required;

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public Integer getRequired() {
        return required;
    }

    public void setRequired(Integer required) {
        this.required = required;
    }

    private ImportUserLoginHeaders(String code, String msg, Integer required) {
        this.code = code;
        this.msg = msg;
        this.required = required;
    }
}
