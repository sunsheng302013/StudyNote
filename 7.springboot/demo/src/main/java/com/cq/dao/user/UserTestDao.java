/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dao.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cq.common.base.PageInfo;
import com.cq.dto.user.UserDTO;
import com.cq.dto.user.UserQueryDTO;

/**
 * <p>
 * 类描述:人员档案基本信息
 * </p>
 *
 * @since 2018年10月26日
 * @author chengq
 */
@Mapper
public interface UserTestDao {

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
     * 查询员工档案总数
     *
     * @param map
     *            人员查询参数
     * @return UserDTO 人员档案
     */
    List<Long> listCount(Map<String, Object> map);
}
