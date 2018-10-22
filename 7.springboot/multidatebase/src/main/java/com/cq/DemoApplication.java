package com.cq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 *
 * <p>
 * 类描述:启动类
 * </p>
 *
 * @since 2018年10月16日
 * @author chengq
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class DemoApplication {

    /** 启动类避免被其他类初始化 **/
    protected DemoApplication() {
    }

    /**
     * 启动入口
     *
     * @param args
     *            参数
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
