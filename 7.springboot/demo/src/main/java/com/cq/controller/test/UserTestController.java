/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.controller.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cq.common.base.BaseController;
import com.cq.common.base.JackYunResponse;
import com.cq.common.base.PageInfo;
import com.cq.common.convert.ListHeaderConverter;
import com.cq.dto.user.UserDTO;
import com.cq.dto.user.UserQueryDTO;
import com.cq.service.user.TestService;

/**
 * <p>
 * 类描述: 人员档案控制层
 * </p>
 *
 * @since 2018年10月26日
 * @author chengq
 */
@RestController
@RequestMapping(value = "/oa/user/test")
public class UserTestController extends BaseController {

    @Autowired
    private TestService testService;

    /**
     * 查询人员档案列表
     *
     * @param userQueryDTO
     *            职位管理查询DTO
     * @param page
     *            分页信息
     * @return 职位list
     */
    @GetMapping("/list")
    public JackYunResponse<Object> listUser(UserQueryDTO userQueryDTO, PageInfo page) {
        ListHeaderConverter.headConverter(userQueryDTO);
        List<UserDTO> userList = testService.list(userQueryDTO, page);
        return sendSuccessData(userList, page);
    }
}
