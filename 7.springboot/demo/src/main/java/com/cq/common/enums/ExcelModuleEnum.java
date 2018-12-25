/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.enums;

/**
 * @since 2018年9月5日 上午10:28:19
 * @author chengq
 *
 */
public enum ExcelModuleEnum {

    /** 人员登录信息导入 **/
    USERLOGIN_IMPORT("userlogin", "人员登录信息导入");

    private String name;
    private String msg;

    /**
     *
     * @param code
     *            要设置的code
     * @param msg
     *            要设置的msg
     */
    ExcelModuleEnum(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            要设置的 name
     */
    public void setName(String name) {
        this.name = name;
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

}
