/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.annotation.DS;
import com.cq.common.util.PageInfo;
import com.cq.dao.user.UserInfoDao;
import com.cq.dto.user.UserInfoDTO;
import com.cq.model.user.UserInfo;
import com.cq.service.user.UserInfoService;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2018年10月17日
 * @author chengq
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    /** 员工档案 **/
    @Autowired
    UserInfoDao userInfoDao;

    /** 今日新增 **/
    public static final Integer TODAY = 1;

    /** 昨日新增 **/
    public static final Integer YESTERDAY = 2;

    /** 本周新增 **/
    public static final Integer WEEK = 3;

    /** 本月新增 **/
    public static final Integer MONTH = 4;

    @Override
    public List<UserInfo> listUserInfo(PageInfo page, UserInfoDTO userInfoDto) {

        // 实例化日期
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        if (userInfoDto.getAddType() != null) {
            /** 今日新增 **/
            if (userInfoDto.getAddType() == TODAY) {
                userInfoDto.setDataGte(calendar.getTime());
            }
            /** 昨日新增 **/
            if (userInfoDto.getAddType() == YESTERDAY) {
                userInfoDto.setDataLte(calendar.getTime());
                calendar.add(Calendar.DAY_OF_MONTH, -1);
                userInfoDto.setDataGte(calendar.getTime());
            }
            /** 本周新增 **/
            if (userInfoDto.getAddType() == WEEK) {
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                userInfoDto.setDataGte(calendar.getTime());
            }
            /** 本月新增 **/
            if (userInfoDto.getAddType() == MONTH) {
                calendar.set(Calendar.DAY_OF_MONTH, 1);
            }
        }

        return null;
    }

    @Override
    @DS
    public List<UserInfo> listUserInfoInMaster(Long userId) {
        return userInfoDao.listUserInfo(userId);
    }

    @Override
    public List<UserInfo> listUserInfoInSlave(Long userId) {
        return userInfoDao.listUserInfo(userId);
    }

}
