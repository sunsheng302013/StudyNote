/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user;

import org.springframework.web.multipart.MultipartFile;

import com.cq.model.user.UserInfo;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月26日
 * @author chengq
 */
public interface UserFaceService {

    /**
     * 在魔点创建人员
     *
     * @author chengq
     * @param user
     *            人员信息
     * @param jarFile
     *            头像文件
     * @return 魔点人员ID
     */
    Long createUserFaceInfo(UserInfo user, MultipartFile jarFile);
}
