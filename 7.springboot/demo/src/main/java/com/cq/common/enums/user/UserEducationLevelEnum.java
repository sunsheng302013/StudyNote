/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.user;

import com.cq.common.enums.CodeEnum;

/**
 * <p>
 * 类描述:学历枚举
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
public enum UserEducationLevelEnum implements CodeEnum {

    /** 博士后 **/
    POSTDOCTOR(1, "博士后"),

    /** 博士 **/
    DOCTOR(2, "博士"),

    /** 研究生 **/
    GRADUATESTUDENT(3, "研究生"),

    /** 本科 **/
    UNDERGRADUATECOURSE(4, "本科"),

    /** 大专 **/
    JUNIORCOLLEGE(5, "大专"),

    /** 中专 **/
    SPECIALSCHOOL(6, "中专"),

    /** 高中 **/
    SENIORMIDDLESCHOOL(7, "高中"),

    /** 技校 **/
    VOCATIONALSCHOOL(8, "技校"),

    /** 初中 **/
    JUNIORMIDDLESCHOOL(9, "初中"),

    /** 小学 **/
    PRIMARYSCHOOL(10, "小学");

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
    UserEducationLevelEnum(Integer code, String msg) {
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
            for (UserEducationLevelEnum status : UserEducationLevelEnum.values()) {
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
            for (UserEducationLevelEnum status : UserEducationLevelEnum.values()) {
                if (code.equals(status.getCode())) {
                    return status.getMsg();
                }
            }
        }
        return null;
    }
}
