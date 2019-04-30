/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dao.task;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cq.dto.task.TaskQueryDTO;
import com.cq.model.task.Task;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年1月8日
 * @author chengq
 */
@Mapper
public interface TaskDao {
    /**
     * 查询任务
     * 
     * @param taskQuery
     *            查询条件
     * @return 任务列表
     */
    List<Task> findTaskList(@Param(value = "taskQuery") TaskQueryDTO taskQuery);
}
