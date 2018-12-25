/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.user;

import com.cq.common.enums.CodeEnum;

/**
 * <p>
 * 类描述:员工-政治面貌
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
public enum UserPoliticsStatusEnum implements CodeEnum {

    /** 群众 **/
    MASSES(0, "群众"),

    /** 共青团员 **/
    COMMUNISTYOUTHLEAGUE(1, "共青团员"),

    /** 中共党员 **/
    CPCMEMBER(2, "中共党员"),

    /** 中共预备党员 **/
    CPCPMEMBER(3, "中共预备党员"),

    /** 民主党派 **/
    DEMOCRATICPARTY(4, "民主党派");

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
    UserPoliticsStatusEnum(Integer code, String msg) {
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
            for (UserPoliticsStatusEnum status : UserPoliticsStatusEnum.values()) {
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
            for (UserPoliticsStatusEnum status : UserPoliticsStatusEnum.values()) {
                if (code.equals(status.getCode())) {
                    return status.getMsg();
                }
            }
        }
        return null;
    }
}
