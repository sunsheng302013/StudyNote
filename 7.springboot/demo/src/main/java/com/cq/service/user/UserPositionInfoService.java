/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user;

import java.util.List;

import com.cq.common.base.PageInfo;
import com.cq.dto.ExportExcelDTO;
import com.cq.dto.user.UserPositionInfoDTO;
import com.cq.dto.user.UserPositionInfoQueryDTO;
import com.cq.dto.user.UserPositionInfoResultDTO;
import com.cq.dto.user.UserPositionInfoSaveDTO;

/**
 * <p>
 * 类描述: 人员档案任职情况
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
public interface UserPositionInfoService {

    /**
     * 查询单个用户的任职情况
     *
     * @param userId
     *            用户ID
     * @return 用户任职情况
     */
    UserPositionInfoResultDTO list(Long userId);

    /**
     * 批量查询用户的任职情况
     *
     * @param page
     *            分页信息
     * @param userPositionInfoQueryDto
     *            用户任职情况
     * @return 用户任职情况
     */
    List<UserPositionInfoDTO> listBatch(PageInfo page, UserPositionInfoQueryDTO userPositionInfoQueryDto);

    /**
     * 批量保存任职情况
     *
     * @param userPositionInfoSaveDto
     *            人员任职情况
     * @return 插入行数
     */
    Integer saveUserPositionInfo(UserPositionInfoSaveDTO userPositionInfoSaveDto);

    /**
     * 多个人员批量新增任职情况
     *
     * @param userPositionInfoDto
     *            人员任职情况
     * @return 插入行数
     */
    Integer insertBatch(UserPositionInfoDTO userPositionInfoDto);

    /**
     * 人员修改任职情况
     *
     * @param userPositionInfoDto
     *            人员任职情况
     * @return 插入行数
     */
    Integer update(UserPositionInfoDTO userPositionInfoDto);

    /**
     * 删除人员任职情况
     *
     * @param idList
     *            主键ID列表
     * @return 删除行数
     */
    Integer delete(List<Integer> idList);

    /**
     * 根据userId和positionId获取任职情况
     *
     * @param userId
     *            人员ID
     * @param positionId
     *            职位ID
     * @return 任职情况
     */
    UserPositionInfoDTO getByPositionId(Long userId, Long positionId);

    /**
     * 导出
     *
     * @param userPositionInfoQueryDTO
     *            查询参数Json
     * @param page
     *            分页信息
     * @param exportExcelDTO
     *            导出参数DTO
     * @return 导出数据
     */
    List<List<Object>> export(PageInfo page, UserPositionInfoQueryDTO userPositionInfoQueryDTO, ExportExcelDTO exportExcelDTO);

}
