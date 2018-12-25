/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user;

import com.cq.dto.user.UserIdCardDTO;

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
     * @param idCardNo
     *            身份证号
     * @return 用户信息
     */
    UserIdCardDTO getUser(String idCardNo);
}
