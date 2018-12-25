/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user;

import com.cq.dto.user.UserDTO;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2018年11月5日
 * @author chengq
 */
public interface UserIdCardAnalyzeService {

    /**
     * 根据身份证解析用户信息
     *
     * @param userDto
     *            人员档案对象
     * @return 用户信息
     */
    UserDTO getUser(UserDTO userDto);
}
