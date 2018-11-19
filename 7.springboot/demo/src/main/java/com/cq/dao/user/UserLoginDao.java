/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cq.dto.user.UserLoginDTO;
import com.cq.model.user.UserLogin;

/**
 * <p>
 * 类描述:人员登录信息
 * </p>
 *
 * @since 2018年10月26日
 * @author chengq
 */
@Mapper
public interface UserLoginDao {

    /**
     * 查询员工档案基本信息
     *
     * @param userLoginId
     *            登录人帐号ID
     * @param password
     *            登录密码
     * @return 登录人信息
     */
    List<UserLogin> select(@Param(value = "userLoginId") Long userLoginId, @Param(value = "password") String password);

    /**
     * 创建员工帐号信息
     *
     * @param user
     *            人员档案信息
     * @return 创建行数
     */
    Integer insert(@Param(value = "user") UserLoginDTO user);

    /**
     * 根据id修改员工帐号信息
     *
     * @param user
     *            人员档案信息
     * @return 修改行数
     */
    Integer updateById(@Param(value = "user") UserLoginDTO user);

    /**
     * 根据id删除员工帐号信息(伪删除)
     *
     * @param ids
     *            人员Id
     * @return 删除行数
     */
    Integer removeById(@Param(value = "ids") List<Integer> ids);

    /**
     * 根据id删除员工帐号信息(真实删除)
     *
     * @param ids
     *            人员Id
     * @return 删除行数
     */
    Integer deleteById(@Param(value = "ids") List<Integer> ids);

    /**
     * 重置帐号密码
     *
     * @param userList
     *            员工档案信息
     * @return 更新行数
     */
    Integer resetPwd(List<UserLoginDTO> userList);

}
