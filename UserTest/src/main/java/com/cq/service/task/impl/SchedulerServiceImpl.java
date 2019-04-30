/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.task.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cq.common.annotation.DatasourceSwitcher;
import com.cq.common.exception.QuartzException;
import com.cq.dao.task.TaskDao;
import com.cq.dto.task.TaskQueryDTO;
import com.cq.model.task.Task;
import com.cq.service.task.SchedulerService;

/**
 * <p>
 * 类描述:定时任务管理类
 * </p>
 *
 * @since 2019年1月8日
 * @author chengq
 */
@Service
public class SchedulerServiceImpl implements SchedulerService {
    @Autowired
    private TaskDao taskDao;

    @Autowired
    private Scheduler scheduler;

    @Override
    @SuppressWarnings("unchecked")
    public Boolean addTask(Task info) {
        String jobName = info.getJobName(), jobGroup = info.getJobGroup(), cronExpression = info.getCronExpression(), jobDescription = info.getJobDescription();
        try {
            if (checkExists(jobName, jobGroup)) {
                throw new QuartzException(String.format("Job已经存在, jobName:{%s},jobGroup:{%s}", jobName, jobGroup));
            }
            // 定义一个TriggerKey 定义name/group
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
            // 定义一个JobKey 定义name/group
            JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
            // 基于表达式构建触发器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing();
            // CronTrigger表达式触发器 继承于Trigger TriggerBuilder 用于构建触发器实例
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withDescription(jobDescription).withSchedule(scheduleBuilder).build();
            Class<? extends Job> clazz = (Class<? extends Job>) Class.forName(info.getJobClass());
            // JobDetail是具体Job实例,通过JobBuilder构建JobDetail实例
            JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(jobKey).withDescription(jobDescription).build();
            // 加入任务调度
            scheduler.scheduleJob(jobDetail, trigger);
            return true;
        } catch (SchedulerException | ClassNotFoundException e) {
            throw new QuartzException("类名不存在或执行表达式错误");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean resumeTask(Task task) {
        try {
            scheduler.resumeJob(JobKey.jobKey(task.getJobName(), task.getJobGroup()));
            return true;
        } catch (Exception e) {
            throw new QuartzException("FAILED");
        }
    }

    @Override
    @DatasourceSwitcher("quartz")
    public List<Task> findTaskList(TaskQueryDTO taskQuery) {
        return taskDao.findTaskList(taskQuery);
    }

    /**
     * 修改定时任务
     *
     * @param info
     */
    @Override
    public Boolean updateTask(Task info) {
        String jobName = info.getJobName(), jobGroup = info.getJobGroup(), cronExpression = info.getCronExpression(), jobDescription = info.getJobDescription(),
                createTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        try {
            if (!checkExists(jobName, jobGroup)) {
                throw new QuartzException(String.format("Job不存在, jobName:{%s},jobGroup:{%s}", jobName, jobGroup));
            }
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
            JobKey jobKey = new JobKey(jobName, jobGroup);
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing();
            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withDescription(createTime).withSchedule(cronScheduleBuilder)
                    .build();

            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            jobDetail.getJobBuilder().withDescription(jobDescription);
            HashSet<Trigger> triggerSet = new HashSet<>();
            triggerSet.add(cronTrigger);

            scheduler.scheduleJob(jobDetail, triggerSet, true);
            return true;
        } catch (SchedulerException e) {
            throw new QuartzException("类名不存在或执行表达式错误");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean pauseTask(Task task) {
        TriggerKey triggerKey = TriggerKey.triggerKey(task.getJobName(), task.getJobGroup());
        try {
            if (checkExists(task.getJobName(), task.getJobGroup())) {
                // 停止触发器
                scheduler.pauseTrigger(triggerKey);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QuartzException(e.getMessage());
        }
    }

    @Override
    public Boolean deleteTask(Task task) {
        TriggerKey triggerKey = TriggerKey.triggerKey(task.getJobName(), task.getJobGroup());
        try {
            if (checkExists(task.getJobName(), task.getJobGroup())) {
                // 停止触发器
                scheduler.pauseTrigger(triggerKey);
                // 移除触发器
                scheduler.unscheduleJob(triggerKey);
                return true;
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
            throw new QuartzException(e.getMessage());
        }
        return false;
    }

    /**
     * 验证是否存在
     *
     * @param jobName
     * @param jobGroup
     * @throws SchedulerException
     */
    private boolean checkExists(String jobName, String jobGroup) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        return scheduler.checkExists(triggerKey);
    }

    @Override
    public void startTask() {

    }
}
