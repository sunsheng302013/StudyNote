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
import com.cq.common.base.PageInfo;
import com.cq.common.convert.ListHeaderConverter;
import com.cq.common.enums.ResultCode;
import com.cq.common.utils.DeserializationConverter;
import com.cq.dto.user.UserDTO;
import com.cq.dto.user.UserQueryDTO;
import com.cq.dto.user.UserTransferQueryDTO;
import com.cq.dto.user.UserTransferResultDTO;
import com.cq.dto.user.UserUpdateBatchDTO;
import com.cq.model.user.UserLog;
import com.cq.model.user.UserSpecialInfo;
import com.cq.service.user.UserLogService;
import com.cq.service.user.UserService;

/**
 * <p>
 * 类描述: 人员档案控制层
 * </p>
 *
 * @since 2018年10月26日
 * @author chengq
 */
@RestController
@RequestMapping(value = "/oa/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserLogService userLogService;

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
        List<UserDTO> userList = userService.list(userQueryDTO, page);
        return sendSuccessData(userList, page);
    }

    /**
     * 选择未建档人员(选择未归档人员，解析身份信息，不保存)
     *
     * @param user
     *            人员档案Json串
     * @return 新建人员档案
     */
    @PostMapping("/select")
    public JackYunResponse<Object> selectUser(String user) {
        UserDTO userDto = DeserializationConverter.jsonToEntity(user, UserDTO.class);
        userDto = userService.selectUser(userDto);
        return sendSuccessData(userDto);
    }

    /**
     * 保存人员档案
     *
     * @param user
     *            人员档案Json串
     * @return 新建人员档案
     */
    @PostMapping("/save")
    public JackYunResponse<Object> save(String user) {
        UserDTO userDto = DeserializationConverter.jsonToEntity(user, UserDTO.class);
        userService.save(userDto);
        return sendSuccessData(userDto);
    }

    /**
     * 删除人员档案信息（批量）
     *
     * @param userIdStr
     *            人员IDJson串
     * @return 操作结果
     */
    @PostMapping("/delete")
    public JackYunResponse<Object> deleteUser(String userIdStr) {
        if (userIdStr == null) {
            return sendFailure(ResultCode.PARAMETER_ERROR);
        }
        List<Long> userIdList = DeserializationConverter.jsonToList(userIdStr, Long.class);
        userService.delete(userIdList);
        return sendSuccess();
    }

    /**
     * 批量修改人员档案信息
     *
     * @param userUpdate
     *            人员Json串
     * @return 操作结果
     */
    @PostMapping("/updatebatch")
    public JackYunResponse<Object> updateBatchUser(String userUpdate) {
        UserUpdateBatchDTO userUpdateBatchDto = DeserializationConverter.jsonToEntity(userUpdate, UserUpdateBatchDTO.class);
        userService.updateBatch(userUpdateBatchDto);
        return sendSuccess();
    }

    /**
     * 查询日志列表
     *
     * @param userId
     *            人员ID
     * @return 日志列表
     */
    @GetMapping("/log/list")
    public JackYunResponse<Object> listUserLog(Long userId) {
        List<UserLog> logList = userLogService.listUserLog(userId);
        return sendSuccessData(logList);
    }

    /**
     * 查询技能特长
     *
     * @return 技能特长
     */
    @GetMapping("/special")
    public JackYunResponse<Object> listUserSpecial() {
        List<UserSpecialInfo> logList = userService.listUserSpecial();
        return sendSuccessData(logList);
    }

    /**
     * 人事调动时查询人员信息
     *
     * @param userTransferQueryDto
     *            人员ID
     * @return 人员信息
     */
    @GetMapping("/transfer")
    public JackYunResponse<Object> transferList(UserTransferQueryDTO userTransferQueryDto) {
        List<UserTransferResultDTO> userTransferResultDtoList = userService.transferList(userTransferQueryDto);
        return sendSuccessData(userTransferResultDtoList);
    }
}
