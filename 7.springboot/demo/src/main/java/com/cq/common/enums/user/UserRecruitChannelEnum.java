/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.user;

import com.cq.common.enums.CodeEnum;

/**
 * <p>
 * 类描述:员工-招聘渠道
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
public enum UserRecruitChannelEnum implements CodeEnum {

    /** 招聘网站0 **/
    ONLINE(0, "招聘网站"),

    /** 官方邮箱1 **/
    MAIL(1, "官方邮箱"),

    /** 内推2 **/
    INTRAPOLATION(2, "内推"),

    /** 同业推荐3 **/
    INDUSTRYRECOMMENDATION(3, "同业推荐"),

    /** 猎头4 **/
    HEADHUNTING(4, "猎头"),

    /** 招聘会5 **/
    JOBFAIR(5, "招聘会"),

    /** 宣讲会6 **/
    SEMINAR(6, "宣讲会");

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
    UserRecruitChannelEnum(Integer code, String msg) {
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
            for (UserRecruitChannelEnum status : UserRecruitChannelEnum.values()) {
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
            for (UserRecruitChannelEnum status : UserRecruitChannelEnum.values()) {
                if (code.equals(status.getCode())) {
                    return status.getMsg();
                }
            }
        }
        return null;
    }
}
