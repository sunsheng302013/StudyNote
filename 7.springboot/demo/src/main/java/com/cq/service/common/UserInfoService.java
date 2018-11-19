/**
 * Copyright(C) 2017 Hangzhou Differsoft Co., Ltd. All rights reserved.
 */
package com.cq.service.common;

import java.util.List;

import com.cq.model.user.UserLogin;

/**
 * 用户信息服务
 *
 * @author xus
 * @since 2018-07-03 17:04
 *
 */
public interface UserInfoService {

    /**
     * 验证登录人信息
     *
     * @param user
     *            人员信息
     * @return 人员信息
     */
    List<UserLogin> login(UserLogin user);

    /**
     * 获取当前用户的姓名
     *
     * @return 用户名
     */
    String getCurrentUserRealName();

    /**
     * 获取当前用户的userId
     *
     * @return 用户ID
     */
    Long getCurrentUserId();

}
