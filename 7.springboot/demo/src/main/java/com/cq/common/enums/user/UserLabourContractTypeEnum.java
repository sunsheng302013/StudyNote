/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.user;

import org.apache.commons.lang.StringUtils;

import com.cq.common.enums.CodeEnum;

/**
 * <p>
 * 类描述:合同类型
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
public enum UserLabourContractTypeEnum implements CodeEnum {

    /** 劳动合同 **/
    LABORCONTRACT(0, "劳动合同"),

    /** 实习协议 **/
    INTERNSHIPAGREEMENT(1, "实习协议"),

    /** 兼职合同 **/
    PARTTIMECONTRACT(2, "兼职合同");

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
    UserLabourContractTypeEnum(Integer code, String msg) {
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
        if (StringUtils.isNotEmpty(msg)) {
            for (UserLabourContractTypeEnum status : UserLabourContractTypeEnum.values()) {
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
            for (UserLabourContractTypeEnum status : UserLabourContractTypeEnum.values()) {
                if (code.equals(status.getCode())) {
                    return status.getMsg();
                }
            }
        }
        return null;
    }
}
