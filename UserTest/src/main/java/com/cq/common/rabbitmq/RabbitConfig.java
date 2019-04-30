/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.rabbitmq;

import org.springframework.stereotype.Component;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月28日
 * @author chengq
 */
@Component
public class RabbitConfig {

    /**
     * 交换机名称 exchange
     */

    public static final String EXCHANGE_NAME = "spring.rabbit.oa.exchange";

    /**
     * 路由键名称 rount_key
     */

    public static final String OA_USER_KEY = "spring.rabbit.oa.user.key";

    /**
     * 请求队列 queue
     */

    public static final String OA_USER_QUEUE = "oa.user.toqueue";

    /**
     * 容器 contain
     */

    public static final String OA_USER_CONTAIN = "oa_user.contain";

    /**
     * admin
     */

    public static final String OA_USER_ADMIN = "oa.user.admin";

}
