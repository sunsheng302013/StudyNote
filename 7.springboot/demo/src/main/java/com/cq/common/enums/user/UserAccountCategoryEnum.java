/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.user;

import com.cq.common.enums.CodeEnum;

/**
 * <p>
 * 类描述:员工户口类型枚举
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
public enum UserAccountCategoryEnum implements CodeEnum {

    /** 本地城镇 **/
    LOCALTOWN(0, "本地城镇"),

    /** 外地城镇 **/
    FIELDTOWN(1, "外地城镇"),

    /** 外地城镇 **/
    LOCALRURAL(2, "本地农村"),

    /** 外地农村 **/
    FIELDRURAL(3, "外地农村");

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
    UserAccountCategoryEnum(Integer code, String msg) {
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
            for (UserAccountCategoryEnum status : UserAccountCategoryEnum.values()) {
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
            for (UserAccountCategoryEnum status : UserAccountCategoryEnum.values()) {
                if (code.equals(status.getCode())) {
                    return status.getMsg();
                }
            }
        }
        return null;
    }
}
