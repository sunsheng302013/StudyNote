/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.enums;

/**
 * 表头查询标记规范
 *
 * @since 2018年3月6日 下午4:17:09
 * @author huangyi
 *
 */
public enum ListHeaderEnum {

    /**
     * 模糊查询like
     */
    TEXT_LIKE("$lk$", "模糊查询like", "Like"),

    /**
     * 大于
     */
    NUM_GT("$gt$", "大于", "Gt"),

    /**
     * 小于
     */
    NUM_LT("$lt$", "小于", "Lt"),

    /**
     * 等于
     */
    EQ("$eq$", "等于", "Equals"),

    /**
     * 大于等于
     */
    GTE("$gteq$", "大于等于", "Gte"),

    /**
     * 小于等于
     */
    LTE("$lteq$", "小于等于", "Lte"),

    /**
     * 区间
     */
    DATE_GTLT("$gtlt$", "区间"),

    /**
     * 包含
     */
    INCLUDE("$in$", "包含", "In");

    private String code;

    private String msg;

    private String suffix;

    /**
     *
     * @param code
     *            编码
     * @param msg
     *            信息
     */
    ListHeaderEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     *
     * @param code
     *            编码
     * @param msg
     *            信息
     * @param suffix
     *            后缀
     */
    ListHeaderEnum(String code, String msg, String suffix) {
        this.code = code;
        this.msg = msg;
        this.suffix = suffix;
    }

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
     * @return the suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * @param suffix
     *            要设置的 suffix
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

}
