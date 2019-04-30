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
     * 数据源master
     *
     * @return 数据源
     */
    @Bean(name = "master")
    @ConfigurationProperties(prefix = "spring.datasource.master") // application.properteis中对应属性的前缀
    public DataSource dataSourceMaster() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 数据源slave
     *
     * @return 数据源slave
     */
    @Bean(name = "slave")
    @ConfigurationProperties(prefix = "spring.datasource.slave") // application.properteis中对应属性的前缀
    public DataSource dataSourceSlave() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 数据源quartz
     *
     * @return 数据源quartz
     */
    @Bean(name = "quartz")
    @ConfigurationProperties(prefix = "spring.datasource.quartz") // application.properteis中对应属性的前缀
    public DataSource dataSourceQuartz() {
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
        dynamicDataSource.setDefaultTargetDataSource(dataSourceSlave());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap<Object, Object>();
        dsMap.put("master", dataSourceMaster());
        dsMap.put("slave", dataSourceSlave());
        dsMap.put("quartz", dataSourceQuartz());

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
