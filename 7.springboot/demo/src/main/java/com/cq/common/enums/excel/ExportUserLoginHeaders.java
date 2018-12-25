/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.excel;

import com.cq.common.enums.CodeEnum;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2018年11月26日
 * @author chengq
 */
public enum ExportUserLoginHeaders implements CodeEnum {

    USERID("userId", 1),

    USERLOGINID("userLoginId", 1),

    PASSWORD("password", 1),

    ISDELETED("isDeleted", 1);

    /** 处理类型code **/
    private Integer code;

    /** 处理类型信息 **/
    private String msg;

    /**
     * @param code
     *            编码
     * @param msg
     *            信息
     */
    ExportUserLoginHeaders(String msg, Integer code) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @return the code
     */
    @Override
    public Integer getCode() {
        return code;
    }

    /**
     * @return the msg
     */
    @Override
    public String getMsg() {
        return msg;
    }

    /**
     * 根据信息查找code
     *
     * @param msg
     *            信息
     * @return code
     */
    public static Integer getCodeByMsg(String msg) {
        for (ExportUserLoginHeaders status : ExportUserLoginHeaders.values()) {
            if (msg.equals(status.getMsg())) {
                return status.getCode();
            }
        }
        return null;
    }

    /**
     * 根据code查询信息
     *
     * @param code
     *            编码
     * @return 信息
     */
    public static String getMsgByCode(Integer code) {
        for (ExportUserLoginHeaders status : ExportUserLoginHeaders.values()) {
            if (code.equals(status.getCode())) {
                return status.getMsg();
            }
        }
        return null;
    }
}
