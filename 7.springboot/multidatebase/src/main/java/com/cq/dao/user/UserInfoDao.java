package com.cq.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cq.model.user.UserInfo;

/**
 *
 * <p>
 * 类描述:员工档案
 * </p>
 *
 * @since 2018年10月16日
 * @author chengq
 */
@Mapper
public interface UserInfoDao {
    /**
     * 在从表中查询用户
     *
     * @param userId
     *            用户ID
     * @return 用户列表
     */
    List<UserInfo> listUserInfo(Long userId);
}