/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user;

import com.cq.model.user.MemberInfo;

/**
 * <p>
 * 类描述:人员档案定时刷新
 * </p>
 *
 * @since 2018年11月20日
 * @author chengq
 */
public interface UserAsynService {

    /**
     * 更新年龄司龄
     *
     * @param memberInfo
     *            会员信息
     * @param loggerSn
     *            loggerSn
     */
    void autoUpdateAge(MemberInfo memberInfo, Long loggerSn);

    /**
     * 更新用户年龄及family年龄
     *
     * @param memberInfo
     *            会员信息
     * @param loggerSn
     *            loggerSn
     */
    void autoUpdateUserAge(MemberInfo memberInfo, Long loggerSn);
}
