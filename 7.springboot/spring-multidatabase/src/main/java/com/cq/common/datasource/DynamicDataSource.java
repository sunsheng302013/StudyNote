/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.datasource;

/**
 * @since 2018年8月31日 下午4:46:31
 * @author chengq
 *
 */

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by pure on 2018-05-06.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("数据源为" + DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }
}
