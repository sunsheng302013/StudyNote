/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.user;

import com.cq.common.enums.CodeEnum;

/**
 * <p>
 * 类描述:学位枚举
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
public enum UserEducationDegreeEnum implements CodeEnum {

    /** 博士后 **/
    POSTDOCTOR(1, "博士后"),

    /** 博士 **/
    DOCTOR(2, "博士"),

    /** MBA **/
    MBA(3, "MBA"),

    /** 硕士 **/
    GRADUATESTUDENT(4, "硕士"),

    /** 双学士 **/
    DOUBLEDEGREE(5, "双学士"),

    /** 学士 **/
    FIRSTDEGREE(6, "学士"),

    /** 无 **/
    NODEGREE(7, "无");

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
    UserEducationDegreeEnum(Integer code, String msg) {
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
        if (null != msg && !"".equals(msg)) {
            for (UserEducationDegreeEnum status : UserEducationDegreeEnum.values()) {
                if (msg.equals(status.getMsg())) {
                    return status.getCode();
                }
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
        if (null != code) {
            for (UserEducationDegreeEnum status : UserEducationDegreeEnum.values()) {
                if (code.equals(status.getCode())) {
                    return status.getMsg();
                }
            }
        }
        return null;
    }
}
