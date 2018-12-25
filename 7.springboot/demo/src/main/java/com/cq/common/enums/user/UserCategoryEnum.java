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
public enum UserCategoryEnum implements CodeEnum {

    /** 正式工 **/
    FORMALWORKER(0, "正式工"),

    /** 合同工 **/
    CONTRACTWORKERS(1, "合同工"),

    /** 临时工 **/
    TEMPORARYWORKER(2, "临时工"),

    /** 退休返聘 **/
    REHIRING(3, "退休返聘"),

    /** 劳务派遣 **/
    LABORDISPATCH(4, "劳务派遣");

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
    UserCategoryEnum(Integer code, String msg) {
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
            for (UserCategoryEnum status : UserCategoryEnum.values()) {
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
            for (UserCategoryEnum status : UserCategoryEnum.values()) {
                if (code.equals(status.getCode())) {
                    return status.getMsg();
                }
            }
        }
        return null;
    }
}
