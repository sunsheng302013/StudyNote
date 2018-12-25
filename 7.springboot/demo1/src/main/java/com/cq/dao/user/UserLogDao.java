package com.cq.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cq.dto.user.UserLogDTO;
import com.cq.model.user.UserLog;

/**
 *
 * <p>
 * 类描述: 人员档案操作日志
 * </p>
 *
 * @since 2018年11月6日
 * @author chengq
 */
@Mapper
public interface UserLogDao {

    /**
     * 插入人员档案操作日志
     *
     * @param userLog
     *            日志
     * @return 插入行数
     */
    Integer insert(UserLog userLog);

    /**
     * 插入多个人员档案操作日志
     *
     * @param userLog
     *            日志
     * @return 插入行数
     */
    Integer insertBatch(UserLogDTO userLog);

    /**
     * 根据userId查询人员档案操作日志
     *
     * @param userId
     *            人员ID
     * @return 操作日志
     */
    List<UserLog> listByUserId(Long userId);
}