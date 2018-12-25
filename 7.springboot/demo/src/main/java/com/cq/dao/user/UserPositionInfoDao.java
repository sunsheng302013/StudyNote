package com.cq.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cq.common.base.PageInfo;
import com.cq.dto.user.UserPositionInfoDTO;
import com.cq.dto.user.UserPositionInfoQueryDTO;

/**
 *
 * <p>
 * 类描述:人员档案任职情况DAO
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
@Mapper
public interface UserPositionInfoDao {

    /**
     * 根据userId获取任职情况
     *
     * @param userId
     *            人员ID
     * @return 任职情况
     */
    List<UserPositionInfoDTO> list(@Param(value = "userId") Long userId);

    /**
     * 获取所有员工的任职情况
     *
     * @param page
     *            分页信息
     * @param userPositionInfoQueryDto
     *            任职情况查询信息
     * @return 任职情况
     */
    List<UserPositionInfoDTO> listBatch(@Param(value = "page") PageInfo page,
            @Param(value = "userPositionInfoQueryDto") UserPositionInfoQueryDTO userPositionInfoQueryDto);

    /**
     * 获取总数
     *
     * @param userPositionInfoQueryDto
     *            任职情况查询信息
     * @return 总数
     */
    Integer listBatchCount(@Param(value = "userPositionInfoQueryDto") UserPositionInfoQueryDTO userPositionInfoQueryDto);

    /**
     * 新增任职情况
     *
     * @param userPositionInfoDto
     *            人员任职情况
     * @return 插入行数
     */
    Integer insert(UserPositionInfoDTO userPositionInfoDto);

    /**
     * 批量保存
     *
     * @param userPositionInfoDtoList
     *            人员任职情况
     * @return 插入行数
     */
    Integer save(List<UserPositionInfoDTO> userPositionInfoDtoList);

    /**
     * 多个人员批量设置任职情况
     *
     * @param userPositionInfoDto
     *            人员任职情况
     * @return 插入行数
     */
    Integer insertBatch(UserPositionInfoDTO userPositionInfoDto);

    /**
     * 根据userId批量删除任职情况(批量删除)
     *
     * @param userIdList
     *            人员ID
     * @return 删除行数
     */
    Integer deleteBatchByUserId(List<Long> userIdList);

    /**
     * 根据userId批量删除任职情况
     *
     * @param userId
     *            人员ID
     * @return 删除行数
     */
    Integer deleteByUserId(Long userId);

    /**
     * 根据主键ID批量删除任职情况
     *
     * @param idList
     *            人员任职情况主键ID
     * @return 删除行数
     */
    Integer deleteBatchById(List<Integer> idList);

    /**
     * 根据positionId更新人员任职情况
     *
     * @param userPositionInfoDto
     *            人员任职情况
     * @return 更新行数
     */
    Integer updateByPositionId(UserPositionInfoDTO userPositionInfoDto);

    /**
     * 根据主键Id更新人员任职情况
     *
     * @param userPositionInfoDto
     *            人员任职情况
     * @return 更新行数
     */
    Integer updateById(UserPositionInfoDTO userPositionInfoDto);

    /**
     * 根据userId和positionId获取任职情况
     *
     * @param userId
     *            人员ID
     * @param positionId
     *            职位ID
     * @return 任职情况
     */
    UserPositionInfoDTO getByPositionId(@Param(value = "userId") Long userId, @Param(value = "positionId") Long positionId);
}