/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.enums.excel;

/**
 * @since 2018年3月20日 下午1:29:35
 * @author huangyi
 *
 */
public enum ExcelDataType {

    /** String类型 **/
    STRING(0),

    /** Boolean类型 **/
    BOOLEAN(1),

    /** Integer类型 **/
    INTEGER(2),

    /** Float类型 **/
    FLOAT(3),

    /** Date类型 **/
    DATE(4),

    /** Double类型 **/
    DOUBLE(5);

    private Integer code;

    /**
     * @param code
     *            枚举值
     */
    ExcelDataType(Integer code) {
        this.code = code;
    }

    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

}
