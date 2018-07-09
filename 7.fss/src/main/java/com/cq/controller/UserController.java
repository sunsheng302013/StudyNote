/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cq.common.JsonUtil;
import com.cq.dto.UserDTO;
import com.cq.service.IUserService;

/**
 * @since 2018年7月9日 上午11:20:13
 * @author differ
 *
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    IUserService userService;

    /**
     * 新增用户
     * 
     * @param UserDTO
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer addUser(UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    /**
     * 批量删除用户
     * 
     * @param userIds
     * @return 删除用户数
     */
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public Integer updateStatus(@RequestParam(value = "userIds") String userIds) {
        List<Integer> idList = JsonUtil.JsonToList(userIds, Integer.class);
        return userService.updataStatus(idList);
    }

    /**
     * 根据用户id查询用户详情
     * 
     */
    @RequestMapping(value = "/selectUserById", method = RequestMethod.POST)
    public UserDTO selectUserById(@RequestParam(value = "id") String id) {
        return userService.selectUserById(id);
    }

    /**
     * 获取用户列表
     */
    @RequestMapping(value = "/selectUserList", method = RequestMethod.GET)
    public List<UserDTO> selectUserList() {
        return userService.selectUserList();
    }

    /**
     * 更新用户信息
     * 
     * @return
     */
    @RequestMapping(value = "/selectUserList", method = RequestMethod.GET)
    public Integer selectUserList(UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }
}
