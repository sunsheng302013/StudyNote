/**
 * Copyright(C) 2017 Hangzhou Differsoft Co., Ltd. All rights reserved.
 */
package com.cq.service.common.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.annotation.DS;
import com.cq.dao.user.UserLoginDao;
import com.cq.model.user.UserLogin;
import com.cq.service.common.UserInfoService;

/**
 *
 *
 * @author xus
 * @since 2018-07-03 17:07
 *
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserLoginDao userLoginDao;

    @Override
    @DS
    public List<UserLogin> login(UserLogin user) {
        return userLoginDao.select(user.getUserLoginId(), user.getPassword());
    }

    @Override
    public String getCurrentUserRealName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long getCurrentUserId() {
        // TODO Auto-generated method stub
        return null;
    }

}
