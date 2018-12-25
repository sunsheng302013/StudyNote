/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.controller.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cq.common.base.BaseController;
import com.cq.common.base.CommonContextHolder;
import com.cq.common.base.JackYunResponse;
import com.cq.common.base.MemberHolder;
import com.cq.common.enums.ResultCode;
import com.cq.common.enums.TaskTypeEnum;
import com.cq.common.utils.DeserializationConverter;
import com.cq.dto.task.TaskDTO;
import com.cq.service.user.UserAsynService;

/**
 * <p>
 * 类描述: 定时任务实现类
 * </p>
 *
 * @since 2018年11月20日
 * @author chengq
 */
@RestController
@RequestMapping(value = "/oa")
public class TaskController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private UserAsynService userAsynService;

    /**
     * 定时任务
     *
     * @param taskJson
     *            任务参数json串
     * @return 结果
     */
    @PostMapping(value = "/task/run")
    public JackYunResponse<Object> taskRun(@RequestParam(value = "taskJson") String taskJson) {
        if (taskJson == null) {
            return sendFailure(ResultCode.PARAMETER_ERROR);
        }
        TaskDTO taskDTO = DeserializationConverter.jsonToEntity(taskJson, TaskDTO.class);
        if (taskDTO.getTaskType().equals(TaskTypeEnum.UPDATE_USER_SOCIALAGE.getCode())) {
            userAsynService.autoUpdateAge(MemberHolder.getMemberInfo(), CommonContextHolder.getLoggerSn());
        } else if (taskDTO.getTaskType().equals(TaskTypeEnum.UPDATE_USER_AGE.getCode())) {
            userAsynService.autoUpdateUserAge(MemberHolder.getMemberInfo(), CommonContextHolder.getLoggerSn());
        }

        LOG.info("oa定时任务执行结束: " + taskJson);
        return sendSuccess();
    }
}
