/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.controller.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cq.common.base.BaseController;
import com.cq.common.base.JackYunResponse;
import com.cq.dto.task.TaskQueryDTO;
import com.cq.model.task.Task;
import com.cq.service.task.SchedulerService;
import com.cq.service.task.StartTaskService;

/**
 * <p>
 * 类描述: 定时任务实现类
 * </p>
 *
 * @since 2018年11月20日
 * @author chengq
 */
@RestController
@RequestMapping(value = "/task")
public class TaskController extends BaseController {

    @Autowired
    private SchedulerService schedulerService;

    @Autowired
    private StartTaskService startTaskService;

    /**
     * 启动定时任务
     *
     * @param taskType
     *            任务类型
     * @return 是否成功
     */
    @PostMapping(value = "/start")
    public JackYunResponse<Object> startTask(String taskType) {
        startTaskService.startTask(taskType);
        return sendSuccess();
    }

    /**
     * 添加并启动定时任务
     *
     * @param task
     *            定时任务
     * @return 是否成功
     */
    @PostMapping(value = "/add")
    public JackYunResponse<Object> addTask(Task task) {
        boolean flag = schedulerService.addTask(task);
        return sendSuccessData(flag);
    }

    /**
     * 重建任务
     *
     * @param task
     *            任务信息
     * @return 重建是否成功
     */
    @PostMapping(value = "/update")
    public JackYunResponse<Object> updateTask(Task task) {
        boolean flag = schedulerService.updateTask(task);
        return sendSuccessData(flag);
    }

    /**
     * 查询定时任务队列
     *
     * @param taskQuery
     *            任务查询
     *
     * @return 任务队列
     */
    @PostMapping(value = "/queryJob")
    public JackYunResponse<Object> queryJob(TaskQueryDTO taskQuery) {
        List<Task> taskEntities = schedulerService.findTaskList(taskQuery);
        return sendSuccessData(taskEntities);
    }

    /**
     * 删除任务
     *
     * @param task
     *            任务信息
     *
     * @return 删除任务是否成功
     */
    @PostMapping(value = "/delete")
    public JackYunResponse<Object> deleteTask(Task task) {
        boolean flag = schedulerService.deleteTask(task);
        return sendSuccessData(flag);
    }

    /**
     * 停止任务
     *
     * @param task
     *            任务信息
     * @return 停职任务是否成功
     */
    @PostMapping(value = "/pause")
    public JackYunResponse<Object> pauseTask(Task task) {
        boolean flag = schedulerService.pauseTask(task);
        return sendSuccessData(flag);
    }

    /**
     * 恢复定时任务
     *
     * @param task
     *            任务信息
     *
     * @return 恢复任务是否成功
     */
    @PostMapping(value = "/resume")
    public JackYunResponse<Object> resumeTask(Task task) {
        boolean flag = schedulerService.resumeTask(task);
        return sendSuccessData(flag);
    }
}
