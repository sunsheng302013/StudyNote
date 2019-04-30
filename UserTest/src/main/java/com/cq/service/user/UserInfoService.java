/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user;

import java.util.List;

import com.cq.model.user.UserInfo;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月29日
 * @author chengq
 */
public interface UserInfoService {

    /**
     * 根据人员ID查询下级人员
     *
     * @param userId
     *            人员ID
     * @return 人员信息
     */
    List<UserInfo> listSubordinate(Long userId);
}
