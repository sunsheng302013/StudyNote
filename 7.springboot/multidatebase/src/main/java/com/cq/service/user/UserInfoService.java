/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user;

import java.util.List;

import com.cq.common.util.PageInfo;
import com.cq.dto.user.UserInfoDTO;
import com.cq.model.user.UserInfo;

/**
 * <p>
 * 类描述:表单查询
 * </p>
 *
 * @since 2018年10月17日
 * @author chengq
 */
public interface UserInfoService {

    /**
     * 查询员工档案信息
     *
     * @param page
     *            分页查询参数
     * @param userInfoDto
     *            查询参数
     * @return 员工档案信息
     */
    List<UserInfo> listUserInfo(PageInfo page, UserInfoDTO userInfoDto);

    /**
     * 在主表中查询用户
     *
     * @param userId
     *            用户ID
     * @return 用户列表
     */
    List<UserInfo> listUserInfoInMaster(Long userId);

    /**
     * 在从表中查询用户
     *
     * @param userId
     *            用户ID
     * @return 用户列表
     */
    List<UserInfo> listUserInfoInSlave(Long userId);
}
