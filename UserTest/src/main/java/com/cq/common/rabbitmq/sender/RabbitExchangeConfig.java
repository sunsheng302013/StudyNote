/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.rabbitmq.sender;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cq.common.rabbitmq.RabbitConfig;
import com.cq.common.rabbitmq.base.RabbitBaseConfig;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月28日
 * @author chengq
 */
@Configuration
@AutoConfigureAfter(RabbitBaseConfig.class)
public class RabbitExchangeConfig {

    @Autowired
    @Qualifier(RabbitConfig.OA_USER_ADMIN)
    private RabbitAdmin rabbitAdmin;

    @Bean
    RabbitAdmin rabbitAdminDeclare(RabbitAdmin rabbitAdmin) {

        /** baseInfo-oa交换机 **/
        // 定义交换机 参数列表分别是：1.交换器名称,2.是否长期有效,3.如果服务器在不再使用时自动删除交换器
        TopicExchange baseInfoOaExchange = new TopicExchange(RabbitConfig.EXCHANGE_NAME, true, false);
        rabbitAdmin.declareExchange(baseInfoOaExchange);

        // 定义队列，true-持久化
        Queue oaUserQueue = new Queue(RabbitConfig.OA_USER_QUEUE, true);
        rabbitAdmin.declareQueue(oaUserQueue);

        // 通过路由键绑定队列到交换器 1.queue:绑定的队列,2.exchange:绑定到那个交换器,3.test2.send:绑定的路由名称
        Binding binding = BindingBuilder.bind(oaUserQueue).to(baseInfoOaExchange).with(RabbitConfig.OA_USER_KEY);
        rabbitAdmin.declareBinding(binding);
        return rabbitAdmin;
    }

}
