/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.rabbit.impl;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.service.rabbit.RabbitSenderService;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月30日
 * @author chengq
 */
@Service
public class RabbitSenderServiceImpl implements RabbitSenderService {

    private static final Logger logger = LoggerFactory.getLogger(RabbitSenderServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送到 指定exchange,routekey的指定queue
     *
     * @param exchange
     *            交换机
     * @param routeKey
     *            路由键
     * @param message
     *            消息
     * @throws Exception
     *             异常
     */
    @Override
    public void sendRabbitmqDirect(String exchange, String routeKey, String message) {
        MessageProperties messageProperties = new MessageProperties();
        Message m;
        try {
            m = new Message(message.getBytes("UTF-8"), messageProperties);
        } catch (UnsupportedEncodingException e) {
            throw new AmqpException("UTF-8编码异常", e);
        }
        // 消息唯一ID
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        logger.info("send: " + correlationData.getId());
        rabbitTemplate.convertAndSend(exchange, routeKey, m, correlationData);
    }

}
