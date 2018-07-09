/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service;

import java.util.List;

import com.cq.dto.UserDTO;

/**
 * @since 2018年7月9日 上午11:27:06
 * @author differ
 *
 */
public interface IUserService {

    /**
     * 添加用户
     * 
     * @param userDTO
     * @return
     */
    Integer addUser(UserDTO userDTO);

    /**
     * 批量删除用户
     * 
     * @param idList
     * @return
     */
    Integer updataStatus(List<Integer> idList);

    /**
     * 根据用户Id查询用户详细信息
     * 
     * @param id
     * @return
     */
    UserDTO selectUserById(String id);

    /**
     * 获取用户列表
     * 
     * @return
     */
    List<UserDTO> selectUserList();

    /**
     * 更新用户信息
     * 
     * @param userDTO
     * @return
     */
    Integer updateUser(UserDTO userDTO);

}
