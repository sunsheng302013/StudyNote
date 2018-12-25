/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user;

import java.util.List;

import com.cq.common.base.PageInfo;
import com.cq.dto.user.UserDTO;
import com.cq.dto.user.UserQueryDTO;

/**
 * <p>
 * 类描述:java测试
 * </p>
 *
 * @since 2018年11月28日
 * @author chengq
 */
public interface TestService {

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
