/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.user;

import com.cq.common.enums.CodeEnum;

/**
 * <p>
 * 类描述:身份证校验码枚举
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
public enum IdCardCheckCodeEnum implements CodeEnum {

    /** 1 **/
    NUM0(0, "1"),

    /** 0 **/
    NUM1(1, "0"),

    /** x **/
    NUM2(2, "x"),

    /** 9 **/
    NUM3(3, "9"),

    /** 8 **/
    NUM4(4, "8"),

    /** 7 **/
    NUM5(5, "7"),

    /** 6 **/
    NUM6(6, "6"),

    /** 5 **/
    NUM7(7, "5"),

    /** 4 **/
    NUM8(8, "4"),

    /** 3 **/
    NUM9(9, "3"),
    /** 2 **/
    NUM10(10, "2");

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
    IdCardCheckCodeEnum(Integer code, String msg) {
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
            for (IdCardCheckCodeEnum status : IdCardCheckCodeEnum.values()) {
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
            for (IdCardCheckCodeEnum status : IdCardCheckCodeEnum.values()) {
                if (code.equals(status.getCode())) {
                    return status.getMsg();
                }
            }
        }
        return null;
    }
}
