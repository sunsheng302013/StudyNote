/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.rabbitmq.base;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.cq.common.rabbitmq.RabbitConfig;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月29日
 * @author chengq
 */
@Configuration
public class RabbitBaseConfig {

    @Value("${spring.rabbitmq.addresses}")
    private String address;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;
    @Value("${spring.rabbitmq.publisher-confirms}")
    private Boolean publisherConfirms;

    /**
     * 构建mq实例工仓
     *
     * @return
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(address);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setPublisherConfirms(publisherConfirms);
        connectionFactory.setVirtualHost(virtualHost);
        return connectionFactory;
    }

    /**
     * rabbitAdmin代理类
     *
     * @return
     */
    @Bean(RabbitConfig.OA_USER_ADMIN)
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    /**
     * 创建rabbitTemplate 消息模板类 prototype原型模式:每次获取Bean的时候会有一个新的实例
     * 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置
     *
     * @return
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        // rabbitTemplate.setMandatory(true);//返回消息必须设置为true
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());// 数据转换为json存入消息队列
        // rabbitTemplate.setReplyAddress(replyQueue().getName());
        // rabbitTemplate.setReplyTimeout(100000000);
        // 发布确认
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            // 消息发送到queue时就执行
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                // log.debug(correlationData+"//////");
                if (!b) {
                    // log.debug("发送到queue失败");
                    throw new RuntimeException("send error " + s);
                }
            }
        });
        return rabbitTemplate;
    }
}
