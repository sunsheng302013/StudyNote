/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cq.common.aspect.SessionInterceptor;
import com.cq.service.user.MemberInfoService;

/**
 * @since 2018年9月5日 下午2:42:23
 * @author chengq
 *
 */
@Configuration
public class SessionConfig implements WebMvcConfigurer {

    @Autowired
    private MemberInfoService userInfoService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor(userInfoService)).addPathPatterns("/**");
    }
}
