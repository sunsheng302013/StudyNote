/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.enums;

/**
 * 导入枚举接口
 *
 * @since 2018年3月14日 上午11:57:15
 * @author huangyi
 *
 */
public interface ImportExcelEnumInterface {

    /**
     * 获取值
     *
     * @return 值
     */
    String getCode();

    /**
     * 获取消息
     *
     * @return 消息
     */
    String getMsg();

    /**
     * 是否必填
     *
     * @return 是否必填
     */
    Integer getRequired();

}
