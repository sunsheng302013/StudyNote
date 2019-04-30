/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.rabbit;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.cq.common.rabbitmq.RabbitConfig;
import com.cq.common.utils.JsonUtils;
import com.cq.model.user.UserInfo;
import com.rabbitmq.client.Channel;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月28日
 * @author chengq
 */
@Component
public class RabbitListenerServiceImpl {

    private static final Logger LOG = LoggerFactory.getLogger(RabbitListenerServiceImpl.class);

    @RabbitListener(bindings = @QueueBinding(exchange = @Exchange(value = RabbitConfig.EXCHANGE_NAME, durable = "true", type = ExchangeTypes.TOPIC), key = RabbitConfig.OA_USER_KEY, value = @Queue(value = RabbitConfig.OA_USER_QUEUE, durable = "true")), admin = RabbitConfig.OA_USER_ADMIN)
    public void DemoReceiver(Message msg, Channel channel) {
        try {
            String jsonMessage = new String(msg.getBody(), "UTF-8");
            LOG.info("rabbit接收端接收到队列" + RabbitConfig.EXCHANGE_NAME + "的信息 是 =  " + jsonMessage);
            List<UserInfo> userInfo = JsonUtils.jsonToList(jsonMessage, UserInfo.class);
            if (userInfo != null) {
                System.out.println(userInfo.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 消息确认
                channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
