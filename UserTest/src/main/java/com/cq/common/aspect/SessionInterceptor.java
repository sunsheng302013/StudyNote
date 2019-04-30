/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cq.common.base.MemberHolder;
import com.cq.model.user.MemberInfo;
import com.cq.service.user.MemberInfoService;

/**
 * 拦截器
 *
 * @since 2018年9月5日 下午2:49:54
 * @author chengq
 *
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {

    private MemberInfoService memberInfoService;

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String strMemberId = request.getHeader("mem_id");
        Long memberId = Long.parseLong(strMemberId);
        String memberName = request.getHeader("mem_name");
        String strUserId = request.getHeader("user_id");
        Long userId = Long.parseLong(strUserId);
        String userName = request.getHeader("user_name");
        MemberInfo memberInfo = new MemberInfo(memberId, memberName, userId, userName);
        // 验证memberInfo是否存在
        memberInfoService.examineMemberInfo(memberName);
        MemberHolder.bindMember(memberInfo);
        return true;
    }

    public SessionInterceptor(MemberInfoService memberInfoService) {
        this.memberInfoService = memberInfoService;
    }
}
