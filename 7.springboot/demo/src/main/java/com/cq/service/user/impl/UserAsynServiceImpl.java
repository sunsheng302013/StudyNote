/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.cq.common.base.CommonContextHolder;
import com.cq.common.base.MemberHolder;
import com.cq.model.user.MemberInfo;
import com.cq.service.user.UserAsynService;

/**
 * <p>
 * 类描述:人员档案定时刷新器
 * </p>
 *
 * @since 2018年11月20日
 * @author chengq
 */
@Service
public class UserAsynServiceImpl implements UserAsynService {

    private static final Logger LOG = LoggerFactory.getLogger(UserAsynServiceImpl.class);

    @Override
    @Async
    public void autoUpdateAge(MemberInfo memberInfo, Long loggerSn) {
        MemberHolder.bindMember(memberInfo);
        CommonContextHolder.setLoggerSn(loggerSn);
        LOG.info("自动更新用户司龄工龄：" + JSON.toJSONString(MemberHolder.getMemberInfo()));
        // userService.updateEntryAge();
        MemberHolder.unbindMember();
        CommonContextHolder.removeLoggerSn();
    }

    @Override
    @Async
    public void autoUpdateUserAge(MemberInfo memberInfo, Long loggerSn) {
        MemberHolder.bindMember(memberInfo);
        CommonContextHolder.setLoggerSn(loggerSn);
        LOG.info("自动更新用户年龄：" + JSON.toJSONString(MemberHolder.getMemberInfo()));
        // userService.updateAge();
        MemberHolder.unbindMember();
        CommonContextHolder.removeLoggerSn();
    }

}
