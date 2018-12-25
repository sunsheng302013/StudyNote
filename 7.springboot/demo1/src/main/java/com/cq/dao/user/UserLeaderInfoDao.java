package com.cq.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cq.model.user.UserLeaderInfo;

/**
 *
 * <p>
 * 类描述:人员档案上下级关系
 * </p>
 *
 * @since 2018年10月29日
 * @author chengq
 */
@Mapper
public interface UserLeaderInfoDao {

    /**
     * 根据userId删除直属上下级信息
     *
     * @param userId
     *            人员ID
     * @return 删除行数
     */
    Integer deleteByUserId(@Param(value = "userId") Long userId);

    /**
     * 根据userId删除直属上下级信息(批量删除)
     *
     * @param userIdList
     *            人员ID
     * @return 删除行数
     */
    Integer deleteBatchByUserId(List<Long> userIdList);

    /**
     * 根据userId删除直属上级信息(批量删除)
     *
     * @param userIdList
     *            人员ID
     * @return 删除行数
     */
    Integer deleteParentPosition(List<Long> userIdList);

    /**
     * 插入直属上下级信息
     *
     * @param userLeaderList
     *            直属上下级信息
     * @return 插入行数
     */
    int insert(List<UserLeaderInfo> userLeaderList);

    /**
     * 批量插入直属上下级信息
     *
     * @param userIds
     *            人员ID列表
     * @param userLeaderList
     *            直属上下级信息
     * @return 插入行数
     */
    int insertBatch(@Param(value = "userIds") List<Long> userIds, @Param(value = "userLeaderList") List<UserLeaderInfo> userLeaderList);

    /**
     * 根据UserId查询直属上下级信息
     *
     * @param userId
     *            人员ID
     * @return 直属上下级信息
     */
    List<UserLeaderInfo> selectByUserId(@Param(value = "userId") Long userId);
}