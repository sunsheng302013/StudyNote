/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cq.common.annotation.DS;
import com.cq.dao.user.UserLogDao;
import com.cq.model.user.UserLog;
import com.cq.service.common.UserInfoService;
import com.cq.service.user.UserLogService;

/**
 * <p>
 * 类描述:人员档案操作日志
 * </p>
 *
 * @since 2018年11月06日
 * @author chengq
 */
@Repository
@Mapper
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    private UserLogDao userLogDao;

    @Autowired
    private UserInfoService userInfoService;

    @Override
    @DS
    public void saveUserLog(UserLog userLog) {
        userLog.setOperatorId(userInfoService.getCurrentUserId());
        userLog.setOperatorName(userInfoService.getCurrentUserRealName());
        userLogDao.insert(userLog);
    }

    @Override
    @DS
    public List<UserLog> listUserLog(Long userId) {
        return userLogDao.listByUserId(userId);
    }
}
