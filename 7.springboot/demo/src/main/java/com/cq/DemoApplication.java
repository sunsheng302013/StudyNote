package com.cq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动类
 *
 * @since 2018年9月7日 下午3:55:16
 * @author chengq
 *
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
