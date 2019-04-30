/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.excel;

import com.cq.common.enums.ImportExcelEnumInterface;

/**
 * <p>
 * 类描述:导入人员登录信息枚举类
 * </p>
 *
 * @since 2018年11月26日
 * @author chengq
 */
public enum ImportUserLoginHeaders implements ImportExcelEnumInterface {

    /** 用户ID **/
    USERID("userId", "人员ID", 1),

    /** 登录帐号 **/
    USERLOGINID("userLoginId", "登录帐号", 1),

    /** 登录密码 **/
    PASSWORD("password", "密码", 1),

    /** 是否删除 0 是，1否 **/
    ISDELETED("isDeleted", "是否删除", 1);

    private String code;
    private String msg;
    private Integer required;

    /**
     * @return the code
     */
    @Override
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
    @Override
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
    @Override
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

    /**
     * 初始化
     *
     * @param code
     *            处理类型
     * @param msg
     *            处理类型信息
     * @param required
     *            是否必填
     */
    ImportUserLoginHeaders(String code, String msg, Integer required) {
        this.code = code;
        this.msg = msg;
        this.required = required;
    }
}
