/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.datasource;

import java.io.IOException;

import javax.sql.DataSource;

import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @since 2018年8月22日 下午2:12:53
 * @author huangyi
 *
 */
@Configuration
public class OaPrimaryDataSourceConfig extends AbstractProcessEngineAutoConfiguration {

    @Bean("primaryDatasource")
    @ConfigurationProperties(prefix = "spring.primary.datasource")
    public DataSource activitiDataSource() {
        return DataSourceBuilder.create().build();
    }

    /** 主库事务管理器 **/
    @Bean(name = "primaryTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("primaryDatasource") DataSource dataSource) throws Exception {
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource);
        return manager;
    }

    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(
            @Qualifier("primaryTransactionManager") PlatformTransactionManager transactionManager, SpringAsyncExecutor springAsyncExecutor) throws IOException {
        return baseSpringProcessEngineConfiguration(activitiDataSource(), transactionManager, springAsyncExecutor);
    }
}
