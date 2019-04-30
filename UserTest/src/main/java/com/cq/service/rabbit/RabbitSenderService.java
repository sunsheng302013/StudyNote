/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.rabbit;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月29日
 * @author chengq
 */
public interface RabbitSenderService {

    /**
     * 发送消息
     *
     * @param exchange
     *            交换机
     * @param routeKey
     *            路由键
     * @param obj
     *            消息体
     */
    void sendRabbitmqDirect(String exchange, String routeKey, String obj);
}
