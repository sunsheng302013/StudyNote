/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.datasource;

/**
 * @since 2018年8月31日 下午4:46:59
 * @author chengq
 *
 */

public class DataSourceContextHolder {
    /**
     * 默认数据源
     */
    public static final String DEFAULT_DS = "datasource2";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    // 设置数据源名
    public static void setDB(String dbType) {
        System.out.println("切换到{" + dbType + "}数据源");
        contextHolder.set(dbType);
    }

    // 获取数据源名
    public static String getDB() {
        return contextHolder.get();
    }

    // 清除数据源名
    public static void clearDB() {
        contextHolder.remove();
    }
}
