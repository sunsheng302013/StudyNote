/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.task.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.cq.common.utils.DateUtils;

/**
 * <p>
 * 类描述:每年更新年龄
 * </p>
 *
 * @since 2019年1月14日
 * @author chengq
 */
@Component
@EnableScheduling
public class UpdateAgeByYear implements Job {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        String date = DateUtils.dateToString(new Date());
        this.logger.info(date + ":更新年龄和入职年龄");
        // userService.updateAge();
    }
}
