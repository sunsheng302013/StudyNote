/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums;

/**
 * <p>
 * 类描述:定时任务类型枚举
 * </p>
 *
 * @since 2018年11月8日
 * @author xiejy
 */
public enum TaskTypeEnum {
    /**
     * 更新用户司龄
     */
    UPDATE_ENTRY_AGE("updateEntryAge", "更新司龄定时任务"),

    /**
     * 更新用户年龄
     */
    UPDATE_USER_AGE("updateUserAge", "更新年龄定时任务");

    private String code;
    private String msg;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            要设置的 code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg
     *            要设置的 msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     *
     * @param code
     *            code
     * @param msg
     *            msg
     */
    TaskTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
