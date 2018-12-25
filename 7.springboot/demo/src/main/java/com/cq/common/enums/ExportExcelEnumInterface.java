/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.enums;

/**
 * 导出枚举接口
 *
 * @since 2018年3月14日 上午11:57:15
 * @author huangyi
 *
 */
public interface ExportExcelEnumInterface {

    /**
     * 获取导出字段
     *
     * @return 结果
     */
    String getDbName();

    /**
     * 获取导出类型
     *
     * @return 结果
     */
    Integer getDataType();
}
