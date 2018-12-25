/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.user;

import org.apache.commons.lang3.StringUtils;

import com.cq.common.enums.CodeEnum;

/**
 * <p>
 * 类描述:合同期限类型
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
public enum UserLabourIsIncludeEnum implements CodeEnum {

    /** 否 **/
    NO(0, "否"),

    /** 是 **/
    YES(1, "是");

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
    UserLabourIsIncludeEnum(Integer code, String msg) {
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
            for (UserLabourIsIncludeEnum status : UserLabourIsIncludeEnum.values()) {
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
            for (UserLabourIsIncludeEnum status : UserLabourIsIncludeEnum.values()) {
                if (code.equals(status.getCode())) {
                    return status.getMsg();
                }
            }
        }
        return null;
    }
}
