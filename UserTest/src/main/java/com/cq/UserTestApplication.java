package com.cq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 *
 * @since 2018年9月7日 下午3:55:16
 * @author chengq
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableScheduling
public class UserTestApplication {

    /**
     * 默认初始化方法
     */
    protected UserTestApplication() {
    }

    /**
     * 启动服务
     *
     * @param args
     *            参数
     */
    public static void main(String[] args) {
        SpringApplication.run(UserTestApplication.class, args);
    }
}
