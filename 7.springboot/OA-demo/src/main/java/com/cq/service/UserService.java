/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service;

import java.util.List;

import com.cq.model.User;

/**
 * @since 2018年8月28日 下午6:23:10
 * @author huangyi
 *
 */
public interface UserService {

    List<User> login(User user);

    /**
     * @return
     */
    String selectNameById(Long userId);

}
