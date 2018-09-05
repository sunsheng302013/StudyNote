/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cq.common.enums.ResultCode;
import com.cq.common.util.BaseController;
import com.cq.common.util.JackYunResponse;
import com.cq.model.User;
import com.cq.service.UserService;

/**
 * @since 2018年8月28日 下午6:07:49
 * @author huangyi
 *
 */
@RestController
@RequestMapping("/oa")
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * 
     * @param user
     * @return
     */
    @PostMapping("/login")
    public JackYunResponse<Object> login(User user, HttpSession session) {
        List<User> list = userService.login(user);
        if (list.size() == 0) {
            return sendFailure(ResultCode.REPEAT_PRINT_LOGIN_FAIL);
        } else {
            session.setAttribute("user", list.get(0));
            return sendSuccess();
        }
    }

}
