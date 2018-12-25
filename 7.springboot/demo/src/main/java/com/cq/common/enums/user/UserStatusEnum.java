/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.user;

import com.cq.common.enums.CodeEnum;

/**
 * <p>
 * 类描述:员工-人员状态
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
public enum UserStatusEnum implements CodeEnum {

    /** 在职 **/
    INCUMBENT(0, "在职"),

    /** 不在职 **/
    NOINCUMBENT(1, "不在职"),

    /** 停职 **/
    SUSPENDED(2, "停职"),

    /** 离职 **/
    RESIGNATION(3, "离职"),

    /** 退休 **/
    RETIREMENT(4, "退休"),

    /** 借调 **/
    SECONDMENT(5, "借调");

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
    UserStatusEnum(Integer code, String msg) {
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
            for (UserStatusEnum status : UserStatusEnum.values()) {
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
            for (UserStatusEnum status : UserStatusEnum.values()) {
                if (code.equals(status.getCode())) {
                    return status.getMsg();
                }
            }
        }
        return null;
    }
}
