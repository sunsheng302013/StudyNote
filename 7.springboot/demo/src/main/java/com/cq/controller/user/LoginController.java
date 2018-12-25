/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cq.common.base.BaseController;
import com.cq.common.base.JackYunResponse;
import com.cq.common.enums.ResultCode;
import com.cq.model.user.UserLogin;
import com.cq.service.common.UserInfoService;

/**
 * @since 2018年8月28日 下午6:07:49
 * @author huangyi
 *
 */
@RestController
@RequestMapping("/oa")
public class LoginController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 用户登录验证
     *
     * @param userInfo
     *            用户对象
     * @param session
     *            session信息
     * @return 登录验证结果
     */
    @GetMapping("/login")
    public JackYunResponse<Object> login(UserLogin user, HttpSession session) {
        List<UserLogin> list = userInfoService.login(user);
        if (list.size() == 0) {
            return sendFailure(ResultCode.REPEAT_PRINT_LOGIN_FAIL);
        } else {
            session.setAttribute("user", list.get(0));
            return sendSuccess();
        }
    }

}
