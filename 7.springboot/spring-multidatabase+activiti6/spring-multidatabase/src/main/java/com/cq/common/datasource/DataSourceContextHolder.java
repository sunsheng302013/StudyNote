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

    private DataSourceContextHolder() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 默认数据源
     */
    public static final String DEFAULT_DS = "datasource1";

    private static final ThreadLocal<String> CONTEXTHOLDER = new ThreadLocal<>();

    /**
     * 设置数据源名
     * 
     * @param dbType
     *            数据源
     */
    public static void setDB(String dbType) {
        System.out.println("切换到{" + dbType + "}数据源");
        CONTEXTHOLDER.set(dbType);
    }

    /**
     * 获取数据源名
     * 
     * @return 返回数据源名称
     */
    public static String getDB() {
        return CONTEXTHOLDER.get();
    }

    /**
     * 清除数据源名
     */
    public static void clearDB() {
        CONTEXTHOLDER.remove();
    }
}
