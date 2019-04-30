/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.task;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月19日
 * @author chengq
 */
public interface StartTaskService {

    /**
     * 启动定时任务
     *
     * @param taskType
     *            定时任务类型
     */
    void startTask(String taskType);
}
