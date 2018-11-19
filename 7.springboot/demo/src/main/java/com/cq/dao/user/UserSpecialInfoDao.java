package com.cq.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cq.model.user.UserSpecialInfo;

/**
 *
 * <p>
 * 类描述: 人员档案-技能特长
 * </p>
 *
 * @since 2018年10月31日
 * @author chengq
 */
@Mapper
public interface UserSpecialInfoDao {

    /**
     * 获取所有技能特长
     *
     * @return 技能特长
     *
     */
    List<UserSpecialInfo> listUserSpecial();
}