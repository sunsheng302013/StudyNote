package com.cq.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cq.dto.user.UserSpecialDTO;
import com.cq.model.user.UserSpecial;

/**
 *
 * <p>
 * 类描述: 人员档案-人员和特长关系
 * </p>
 *
 * @since 2018年10月30日
 * @author chengq
 */
@Mapper
public interface UserSpecialDao {
    /**
     * 根据userId删除技能特长
     *
     * @param userId
     *            人员ID
     * @return 删除行数
     */
    Integer deleteByUserId(@Param(value = "userId") Long userId);

    /**
     * 根据userId删除技能特长(批量删除)
     *
     * @param userIdList
     *            人员ID
     * @return 删除行数
     */
    Integer deleteBatchByUserId(List<Long> userIdList);

    /**
     * 插入技能特长
     *
     * @param userSpecialList
     *            技能特长
     * @return 插入行数
     */
    int insert(List<UserSpecialDTO> userSpecialList);

    /**
     * 根据UserId查询技能特长
     *
     * @param userId
     *            人员ID
     * @return 技能特长
     */
    List<UserSpecial> selectByUserId(@Param(value = "userId") Long userId);
}