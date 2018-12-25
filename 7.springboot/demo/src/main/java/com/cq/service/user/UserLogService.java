/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user;

import java.util.List;
import java.util.Map;

import com.cq.dto.ImportExcelDTO;
import com.cq.model.user.UserLog;

/**
 * <p>
 * 类描述: 人员档案操作日志业务层
 * </p>
 *
 * @since 2018年11月06日
 * @author chengq
 */
public interface UserLogService {

    /**
     * 保存人员档案操作日志
     *
     * @param userLog
     *            人员档案操作日志
     */
    void saveUserLog(UserLog userLog);

    /**
     * 根据人员ID查询人员档案操作日志
     *
     * @param userId
     *            人员ID
     * @return 人员档案操作日志list
     */
    List<UserLog> listUserLog(Long userId);

    /**
     * @param importDto
     * @return
     */
    Map<String, Object> importUserLogCheck(ImportExcelDTO importDto);
}
