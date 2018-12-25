/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.user;

import com.cq.common.enums.CodeEnum;

/**
 * <p>
 * 类描述:员工-人事异动类别
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
public enum UserChangeInfoTypeEnum implements CodeEnum {

    /** 入职 **/
    ENTRY(0, "入职"),

    /** 转正 **/
    REGULAR(1, "转正"),

    /** 离职 **/
    LEAVE(2, "离职"),

    /** 停职 **/
    SUSPENDED(3, "停职"),

    /** 复职 **/
    REINSTATEMENT(4, "复职"),

    /** 调岗 **/
    TUNEJOB(5, "调岗"),

    /** 奖励 **/
    ENCOURAGE(6, "奖励"),

    /** 处分 **/
    PUNISH(7, "处分"),

    /** 培训 **/
    TRAIN(8, "培训");

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
    UserChangeInfoTypeEnum(Integer code, String msg) {
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
            for (UserChangeInfoTypeEnum status : UserChangeInfoTypeEnum.values()) {
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
            for (UserChangeInfoTypeEnum status : UserChangeInfoTypeEnum.values()) {
                if (code.equals(status.getCode())) {
                    return status.getMsg();
                }
            }
        }
        return null;
    }
}
