/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cq.model.user.UserInfo;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月17日
 * @author chengq
 */
@Mapper
public interface UserInfoDao {

    /**
     * 根据userId查询下属人员
     * 
     * @param userId
     *            人员ID
     * @return 下属人员信息
     */
    List<UserInfo> listSubordinate(Long userId);
}
