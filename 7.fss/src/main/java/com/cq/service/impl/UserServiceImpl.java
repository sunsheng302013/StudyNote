/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.dao.UserMapper;
import com.cq.dto.UserDTO;
import com.cq.service.IUserService;

/**
 * @since 2018年7月9日 上午11:27:33
 * @author differ
 *
 */

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Integer addUser(UserDTO userDTO) {
        return userMapper.insert(userDTO);
    }

    @Override
    public Integer updataStatus(List<Integer> idList) {

        return userMapper.updateStatus(idList);
    }

    @Override
    public UserDTO selectUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserDTO> selectUserList() {
        return userMapper.selectUserList();
    }

    @Override
    public Integer updateUser(UserDTO userDTO) {
        return userMapper.updateUser(userDTO);
    }

}
