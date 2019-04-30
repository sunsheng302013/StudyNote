/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.task;

import java.util.List;

import com.cq.dto.task.TaskQueryDTO;
import com.cq.model.task.Task;

/**
 * <p>
 * 类描述:任务调度管理
 * </p>
 *
 * @since 2019年1月8日
 * @author chengq
 */
public interface SchedulerService {

    /**
     * 查询定时任务队列
     *
     * @param taskQuery
     *            任务查询
     *
     * @return 任务队列
     */
    List<Task> findTaskList(TaskQueryDTO taskQuery);

    /**
     * 执行默认定时任务
     */
    void startTask();

    /**
     * 停止任务
     *
     * @param task
     *            任务信息
     * @return 停职任务是否成功
     */
    Boolean pauseTask(Task task);

    /**
     * 重建任务
     *
     * @param task
     *            任务信息
     * @return 重建是否成功
     */
    Boolean updateTask(Task task);

    /**
     * 删除任务
     *
     * @param task
     *            任务信息
     *
     * @return 删除任务是否成功
     */
    Boolean deleteTask(Task task);

    /**
     * 添加任务 实例化Job，将任务触发器加入任务调度中
     *
     * @param task
     *            任务信息
     * @return 添加任务是否成功
     */
    Boolean addTask(Task task);

    /**
     * 恢复定时任务
     *
     * @param task
     *            任务信息
     *
     * @return 恢复任务是否成功
     */
    Boolean resumeTask(Task task);
}
