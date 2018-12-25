/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user;

import java.util.List;

import com.cq.common.base.PageInfo;
import com.cq.dto.ExportExcelDTO;
import com.cq.dto.user.UserBaseResultDTO;
import com.cq.dto.user.UserDTO;
import com.cq.dto.user.UserIdCardDTO;
import com.cq.dto.user.UserQueryDTO;
import com.cq.dto.user.UserTransferQueryDTO;
import com.cq.dto.user.UserTransferResultDTO;
import com.cq.dto.user.UserUpdateBatchDTO;

/**
 * <p>
 * 类描述:人员档案基本信息
 * </p>
 *
 * @since 2018年10月26日
 * @author chengq
 */
public interface UserService {

    /**
     * 查询员工档案列表
     *
     * @param userQueryDto
     *            人员查询DTO
     * @param page
     *            分页信息
     * @return 人员list
     */
    List<UserDTO> list(UserQueryDTO userQueryDto, PageInfo page);

    /**
     * 查询员工基本信息
     *
     * @param userId
     *            人员ID
     * @return 人员list
     */
    List<UserDTO> getUser(Long userId);

    /**
     * 查询员工档案列表
     *
     * @param userId
     *            人员ID
     * @return 人员信息
     */
    UserBaseResultDTO get(Long userId);

    /**
     * 身份证解析
     *
     * @param idCardNo
     *            人员身份证号
     * @return UserDTO 新建人员档案
     */
    UserIdCardDTO selectUser(String idCardNo);

    /**
     * 保存员工档案信息
     *
     * @param userDto
     *            员工档案
     * @return 人员ID
     */
    Long save(UserDTO userDto);

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
     * @param idCardNo
     *            身份证信息
     * @return 身份证号
     */
    String idCardValidator(String idCardNo);

    /**
     * 身份证校验合法性和唯一性
     *
     * @param userDto
     *            人员信息
     * @return 身份证号
     */
    String idCardValidator(UserDTO userDto);

    /**
     * 人事调动时查询人员信息
     *
     * @param page
     *            分页信息
     * @param userTransferQueryDto
     *            查询参数
     * @return 人员信息
     */
    List<UserTransferResultDTO> transferList(PageInfo page, UserTransferQueryDTO userTransferQueryDto);

    /**
     *
     * @param page
     *            分页信息
     * @param userQueryDTO
     *            人员档案查询
     * @param exportExcelDTO
     *            导出参数DTO
     * @return 导出excel数据
     */
    List<List<Object>> export(PageInfo page, UserQueryDTO userQueryDTO, ExportExcelDTO exportExcelDTO);

    /**
     * 判断查询条件字段中是否包含子表字段
     *
     * @param userQueryDto
     *            查询参数
     * @param tableName
     *            子表名称
     * @return 查询包含子表字段返回1，不包含返回0
     */
    Integer checkIsHaveTable(UserQueryDTO userQueryDto, String tableName);

}
