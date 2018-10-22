/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 多数据源配置类 Created by pure on 2018-05-06.
 */
@Configuration
public class DataSourceConfig {
    /**
     * 数据源db1
     *
     * @return 数据源
     */
    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.datasource.db1") // application.properteis中对应属性的前缀
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 数据源db2
     *
     * @return 数据源
     */
    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.datasource.db2") // application.properteis中对应属性的前缀
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     *
     * @return 数据源
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSource2());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap<Object, Object>();
        dsMap.put("db1", dataSource1());
        dsMap.put("db2", dataSource2());

        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

    /**
     * 配置@Transactional注解事物
     *
     * @return 事务管理对象
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
