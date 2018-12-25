/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.user;

import com.cq.common.enums.CodeEnum;

/**
 * <p>
 * 类描述:员工-人员类别
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
public enum UserLogDetailEnum implements CodeEnum {

    /** 基本信息 **/
    BASEINFO(0, "修改基本信息"),

    /** 任职情况 **/
    POSITIONINFO(1, "修改任职情况"),

    /** 教育经历 **/
    EDUCATIONINFO(2, "修改教育经历"),

    /** 培训经历 **/
    TRAININFO(3, "修改培训经历"),

    /** 技能职称 **/
    SKILLINFO(4, "修改技能职称"),

    /** 家庭成员 **/
    FAMILYINFO(5, "修改家庭成员"),

    /** 工作经历 **/
    WORKINFO(6, "修改工作经历"),

    /** 员工合同 **/
    LABOURCONTRACTINFO(7, "修改员工合同");

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
    UserLogDetailEnum(Integer code, String msg) {
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
            for (UserLogDetailEnum status : UserLogDetailEnum.values()) {
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
            for (UserLogDetailEnum status : UserLogDetailEnum.values()) {
                if (code.equals(status.getCode())) {
                    return status.getMsg();
                }
            }
        }
        return null;
    }
}
