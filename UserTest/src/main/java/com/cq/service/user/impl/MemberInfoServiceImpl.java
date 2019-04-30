/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.annotation.DatasourceSwitcher;
import com.cq.common.enums.ResultCode;
import com.cq.common.exception.ServiceException;
import com.cq.dao.user.MemberInfoDao;
import com.cq.model.user.MemberInfo;
import com.cq.service.user.MemberInfoService;

/**
 * <p>
 * 类描述:会员信息
 * </p>
 *
 * @since 2019年4月17日
 * @author chengq
 */
@Service
public class MemberInfoServiceImpl implements MemberInfoService {

    @Autowired
    private MemberInfoDao memberInfoDao;

    @Override
    @DatasourceSwitcher
    public void examineMemberInfo(String memberName) {
        MemberInfo memberInfo = memberInfoDao.getByMemberName(memberName);
        if (memberInfo == null) {
            throw new ServiceException(ResultCode.REPEAT_PRINT_LOGIN_FAIL);
        }
    }
}
