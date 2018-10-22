/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cq.common.util.BaseController;
import com.cq.common.util.JackYunResponse;
import com.cq.common.util.ListHeaderConverter;
import com.cq.common.util.PageInfo;
import com.cq.dto.user.UserInfoDTO;
import com.cq.model.user.UserInfo;
import com.cq.service.user.UserInfoService;

/**
 * <p>
 * 类描述:表头查询测试类
 * </p>
 *
 * @since 2018年10月16日
 * @author chengq
 */
@RestController
@RequestMapping(value = "/oa/userInfo")
public class UserController extends BaseController {

    /** 员工档案查询 **/
    @Autowired
    UserInfoService userInfoService;

    /**
     *
     * @param page
     *            分页信息
     * @param userInfoDto
     *            用户查询参数
     * @return 用户信息
     */
    @GetMapping("/list")
    public JackYunResponse<Object> listUser(PageInfo page, UserInfoDTO userInfoDto) {
        ListHeaderConverter.headConverter(userInfoDto);
        List<UserInfo> userList = userInfoService.listUserInfo(page, userInfoDto);
        return sendSuccessData(userList);
    }

    /**
     *
     * @param userId
     *            用户查询参数
     * @return 用户信息
     */
    @GetMapping("/master")
    public JackYunResponse<Object> listUserInMaster(Long userId) {
        List<UserInfo> userList = userInfoService.listUserInfoInMaster(userId);
        return sendSuccessData(userList);
    }

    /**
     *
     * @param userId
     *            用户查询参数
     * @return 用户信息
     */
    @GetMapping("/slave")
    public JackYunResponse<Object> listUserInSlave(Long userId) {
        List<UserInfo> userList = userInfoService.listUserInfoInSlave(userId);
        return sendSuccessData(userList);
    }
}
