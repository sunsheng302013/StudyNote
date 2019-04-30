/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.task.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.enums.TaskTypeEnum;
import com.cq.model.task.Task;
import com.cq.service.task.SchedulerService;
import com.cq.service.task.StartTaskService;

/**
 * <p>
 * 类描述:启动定时任务
 * </p>
 *
 * @since 2019年4月19日
 * @author chengq
 */
@Service
public class StartTaskServiceImpl implements StartTaskService {

    @Autowired
    private SchedulerService schedulerService;

    @Override
    public void startTask(String taskType) {
        if (TaskTypeEnum.UPDATE_USER_AGE.getCode().equals(taskType)) {
            updateAgeTask();
        } else if (TaskTypeEnum.UPDATE_ENTRY_AGE.getCode().equals(taskType)) {
            updateEntryAgeTask();
        }
    }

    public void updateAgeTask() {
        Task updateAgeTask = new Task();
        updateAgeTask.setJobName("updateAgeByYear");
        updateAgeTask.setJobGroup("updateAge");
        updateAgeTask.setJobClass("com.cq.job.UpdateAgeByYear");
        updateAgeTask.setCronExpression("0 0/1 * * * ? *");
        schedulerService.addTask(updateAgeTask);
    }

    public void updateEntryAgeTask() {
        Task updateEntryAgeTask = new Task();
        updateEntryAgeTask.setJobName("updateEntryAgeTask");
        updateEntryAgeTask.setJobGroup("updateEntryAge");
        updateEntryAgeTask.setJobClass("com.cq.job.UpdateEntryAgeByDay");
        updateEntryAgeTask.setCronExpression("0/5 * * * * ? *");
        schedulerService.addTask(updateEntryAgeTask);
    }

}
