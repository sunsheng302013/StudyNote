/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cq.model.User;

/**
 * @since 2018年9月5日 上午10:51:18
 * @author chengq
 *
 */
public class SessionUtil {

    private static final String GLOBLE_SESSION_KEY = "user";

    public static User get() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return (User) request.getSession().getAttribute(GLOBLE_SESSION_KEY);
    }

    public static void set(String username) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if (username != null) {
            request.getSession().setAttribute(GLOBLE_SESSION_KEY, username);
        } else {
            request.getSession().removeAttribute(GLOBLE_SESSION_KEY);
        }
    }
}
