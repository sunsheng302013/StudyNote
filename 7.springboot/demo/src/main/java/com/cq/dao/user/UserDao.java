/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dao.user;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cq.common.base.PageInfo;
import com.cq.dto.user.UserBaseResultDTO;
import com.cq.dto.user.UserDTO;
import com.cq.dto.user.UserQueryDTO;
import com.cq.dto.user.UserTransferQueryDTO;
import com.cq.dto.user.UserTransferResultDTO;
import com.cq.dto.user.UserUpdateBatchDTO;
import com.cq.model.user.User;

/**
 * <p>
 * 类描述:人员档案基本信息
 * </p>
 *
 * @since 2018年10月26日
 * @author chengq
 */
@Mapper
public interface UserDao {

    /**
     * 查询员工档案基本信息
     *
     * @param page
     *            分页信息
     * @param userQueryDto
     *            人员查询参数
     * @return UserDTO 人员档案
     */
    List<UserDTO> list(@Param(value = "page") PageInfo page, @Param(value = "userQueryDto") UserQueryDTO userQueryDto);

    /**
     * 查询员工档案基本信息
     *
     * @param userId
     *            人员查询参数
     * @return UserDTO 人员档案
     */
    List<UserDTO> getUser(@Param(value = "userId") Long userId);

    /**
     * 查询员工档案总数
     *
     * @param map
     *            人员查询参数
     * @return UserDTO 人员档案
     */
    List<Long> listCount(Map<String, Object> map);

    /**
     * 查询员工档案基本信息
     *
     * @param userId
     *            人员查询参数
     * @return UserDTO 人员档案
     */
    UserBaseResultDTO get(@Param(value = "userId") Long userId);

    /**
     * 根据erpUserId修改员工档案
     *
     * @param user
     *            人员档案信息
     * @return 修改行数
     */
    Integer updateByErpUserId(@Param(value = "user") User user);

    /**
     * 批量修改员工档案基本信息
     *
     * @param userUpdateBatchDto
     *            员工档案信息
     * @return 更新行数
     */
    Integer updateBatch(UserUpdateBatchDTO userUpdateBatchDto);

    /**
     * 根据erpUserId 更新人员状态(批量处理)
     *
     * @param erpUserIds
     *            erp人员ID
     * @param userStatus
     *            人员状态
     * @return 修改行数
     */
    Integer updateBatchUserStatusByErpUserId(@Param(value = "erpUserIds") List<Long> erpUserIds, @Param(value = "userStatus") Integer userStatus);

    /**
     * 根据erpUserId 更新人员状态(单个)
     *
     * @param erpUserId
     *            erp人员ID
     * @param userStatus
     *            人员状态
     * @return 修改行数
     */
    Integer updateUserStatusByErpUserId(@Param(value = "erpUserId") Long erpUserId, @Param(value = "userStatus") Integer userStatus);

    /**
     * 根据erpUserId 更新转正日期
     *
     * @param erpUserId
     *            erp人员ID
     * @param regularDate
     *            转正日期
     * @return 修改行数
     */
    Integer updateRegularDateByErpUserId(@Param(value = "erpUserId") Long erpUserId, @Param(value = "regularDate") Date regularDate);

    /**
     * 根据erpUserId 更新离职日期
     *
     * @param erpUserId
     *            erp人员ID
     * @param leaveDate
     *            离职日期
     * @return 修改行数
     */
    Integer updateLeaveDateByErpUserId(@Param(value = "erpUserId") Long erpUserId, @Param(value = "leaveDate") String leaveDate);

    /**
     * 员工档案唯一性校验(证件类型+身份证号)
     *
     * @param idCardNo
     *            员工身份证信息
     * @return 0代表不存在，1代表唯一
     */
    Integer uniquenessCheck(@Param(value = "idCardNo") String idCardNo);

    /**
     * 员工档案唯一性校验(证件类型+身份证号)
     *
     * @param userDto
     *            人员资料
     * @return 0代表不存在，1代表唯一
     */
    Integer uniquenessCheckExceptOneSelf(@Param(value = "userDto") UserDTO userDto);

    /**
     * 删除员工基本信息 伪删除
     *
     * @param userIdList
     *            员工ID
     * @return 删除行数
     */
    Integer fakeDelete(List<Long> userIdList);

    /**
     * 根据userId获取erpUserId
     *
     * @param userId
     *            人员ID
     * @return ERP人员ID
     */
    List<Long> getErpUserIdByUserId(List<Long> userId);

    /**
     * 删除员工基本信息
     *
     * @param userId
     *            员工ID
     * @return 删除行数
     */
    Integer delete(Long userId);

    /**
     * 插入员工档案信息
     *
     * @param userDto
     *            员工档案信息
     * @return 插入行数
     */
    Integer insert(UserDTO userDto);

    /**
     * 更新员工档案信息
     *
     * @param userDto
     *            员工档案信息
     * @return 插入行数
     */
    Integer update(UserDTO userDto);

    /**
     * 更新司龄
     */
    void updateEntryAge();

    /**
     * 更新工龄
     */
    void updateSocialAge();

    /**
     * 更新user表中的age
     */
    void updateAge();

    /**
     * 人事调动时查询人员信息
     *
     * @param page
     *            分页信息
     * @param userTransferQueryDto
     *            查询参数
     * @return 人员信息
     */
    List<UserTransferResultDTO> transferList(@Param(value = "page") PageInfo page,
            @Param(value = "userTransferQueryDto") UserTransferQueryDTO userTransferQueryDto);

    /**
     * 人事调动时查询人员信息总数
     *
     * @param userTransferQueryDto
     *            查询参数
     * @return 人员ID
     */
    List<Long> transferListCount(@Param(value = "userTransferQueryDto") UserTransferQueryDTO userTransferQueryDto);

    /**
     * 根据erpUserId获取userId
     *
     * @param erpUserId
     *            erp人员ID
     * @return 人员ID
     */
    Long getUserIdByErpUserId(Long erpUserId);
}
