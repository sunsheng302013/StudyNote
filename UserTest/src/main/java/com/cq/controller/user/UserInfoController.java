/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cq.common.base.BaseController;
import com.cq.common.base.JackYunResponse;
import com.cq.model.user.UserInfo;
import com.cq.service.user.UserInfoService;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年1月28日
 * @author chengq
 */
@RestController
@RequestMapping("/userinfo")
public class UserInfoController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 创建人员
     *
     * @param user
     *            用户对象
     * @return 登录验证结果
     */
    @PostMapping("/create")
    public JackYunResponse<Object> create(String strUserInfo) {

        return sendSuccessData(strUserInfo);
    }

    /**
     *
     * @param userId
     * @return
     */
    @GetMapping("/listsubordinate")
    public JackYunResponse<Object> locationList(Long userId) {
        List<UserInfo> subordinateList = userInfoService.listSubordinate(userId);
        return sendSuccessData(subordinateList);
    }
}
