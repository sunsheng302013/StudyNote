/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cq.common.base.PageInfo;
import com.cq.dto.user.UserDTO;
import com.cq.dto.user.UserQueryDTO;
import com.cq.dto.user.UserTransferQueryDTO;
import com.cq.dto.user.UserTransferResultDTO;
import com.cq.dto.user.UserUpdateBatchDTO;
import com.cq.model.user.UserSpecialInfo;

/**
 * <p>
 * 类描述:人员档案基本信息
 * </p>
 *
 * @since 2018年10月26日
 * @author chengq
 */
@Service
public interface UserService {

    /**
     * 查询员工档案列表
     *
     * @param userQueryDto
     *            职位管理查询DTO
     * @param page
     *            分页信息
     * @return 职位list
     */
    List<UserDTO> list(UserQueryDTO userQueryDto, PageInfo page);

    /**
     * 选择未建档人员(选择未归档人员，解析身份信息，不保存)
     *
     * @param userDto
     *            人员档案Json串
     * @return UserDTO 新建人员档案
     */
    UserDTO selectUser(UserDTO userDto);

    /**
     * 保存员工档案信息
     *
     * @param userDto
     *            员工档案
     * @return 保存行数
     */
    Integer save(UserDTO userDto);

    /**
     * 批量删除员工档案信息
     *
     * @param userIdList
     *            员工ID列表
     * @return 删除行数
     */
    Integer delete(List<Long> userIdList);

    /**
     * 批量修改员工档案信息
     *
     * @param userUpdateBatchDto
     *            员工列表
     * @return 修改行数
     */
    Integer updateBatch(UserUpdateBatchDTO userUpdateBatchDto);

    /**
     * 身份证校验合法性和唯一性
     *
     * @param userDto
     *            身份证信息
     */
    void idCardValidator(UserDTO userDto);

    /**
     *
     * @return 用户技能特长
     */
    List<UserSpecialInfo> listUserSpecial();

    /**
     * 人事调动时查询人员信息
     *
     * @param userTransferQueryDto
     *            查询参数
     * @return 人员信息
     */
    List<UserTransferResultDTO> transferList(UserTransferQueryDTO userTransferQueryDto);

}
