/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.annotation.DS;
import com.cq.dao.UserDao;
import com.cq.model.User;
import com.cq.service.UserService;

/**
 * @since 2018年8月28日 下午6:23:38
 * @author huangyi
 *
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    @DS
    public List<User> login(User user) {
        return userDao.login(user);
    }

    @Override
    @DS
    public String selectNameById(Long userId) {
        String userName = userDao.selectNameById(userId);
        return userName;
    }

}
