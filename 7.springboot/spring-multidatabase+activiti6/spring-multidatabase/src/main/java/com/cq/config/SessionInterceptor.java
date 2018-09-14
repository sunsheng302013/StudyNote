/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器
 * 
 * @since 2018年9月5日 下午2:49:54
 * @author chengq
 *
 */
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("uri=" + request.getRequestURI());
        // 登录不做拦截
        if (request.getRequestURI().equals("/oa/login") || request.getRequestURI().equals("/oa/login_view")) {
            return true;
        }
        // 验证session是否存在
        Object obj = request.getSession().getAttribute("user");
        if (obj == null) {
            response.sendRedirect("/oa/login");
            return false;
        }
        return true;
    }

}
