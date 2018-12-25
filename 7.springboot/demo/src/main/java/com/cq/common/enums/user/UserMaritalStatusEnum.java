/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.user;

import com.cq.common.enums.CodeEnum;

/**
 * <p>
 * 类描述:员工-婚姻情况
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
public enum UserMaritalStatusEnum implements CodeEnum {

    /** 未婚 **/
    UNMARRIED(0, "未婚"),

    /** 已婚 **/
    MARRIED(1, "已婚"),

    /** 离婚 **/
    DIVORCE(3, "离婚"),

    /** 丧偶 **/
    WIDOWED(4, "丧偶"),

    /** 不详 **/
    UNKNOWN(5, "不详");

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
    UserMaritalStatusEnum(Integer code, String msg) {
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
            for (UserMaritalStatusEnum status : UserMaritalStatusEnum.values()) {
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
            for (UserMaritalStatusEnum status : UserMaritalStatusEnum.values()) {
                if (code.equals(status.getCode())) {
                    return status.getMsg();
                }
            }
        }
        return null;
    }
}
