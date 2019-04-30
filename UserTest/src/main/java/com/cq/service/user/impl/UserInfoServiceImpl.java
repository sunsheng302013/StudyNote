/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.annotation.DatasourceSwitcher;
import com.cq.common.rabbitmq.RabbitConfig;
import com.cq.common.utils.JsonUtils;
import com.cq.dao.user.UserInfoDao;
import com.cq.model.user.UserInfo;
import com.cq.service.rabbit.RabbitSenderService;
import com.cq.service.user.UserInfoService;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月29日
 * @author chengq
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    public RabbitSenderService rabbitSenderService;

    @Override
    @DatasourceSwitcher
    public List<UserInfo> listSubordinate(Long userId) {
        List<UserInfo> subordinateList = userInfoDao.listSubordinate(userId);
        String msg = JsonUtils.listToJson(subordinateList);

        rabbitSenderService.sendRabbitmqDirect(RabbitConfig.EXCHANGE_NAME, RabbitConfig.OA_USER_KEY, msg);
        return subordinateList;
    }

}
