/**
 * Copyright(C) 2017 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cq.common.base.BaseController;
import com.cq.common.base.JackYunResponse;
import com.cq.common.enums.ResultCode;

/**
 * @since 2017年12月6日 下午8:06:39
 * @author YuanMingEn
 *
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    /**
     * 已定义异常
     *
     * @param e
     *            异常
     * @param request
     *            http请求
     * @return 吉客云返回体
     */
    @ExceptionHandler(ServiceException.class)
    public JackYunResponse<Object> handleResultException(ServiceException e, HttpServletRequest request) {
        LOG.error(e.getResultCode().getMsg());
        if (e.getErrorData() != null) {
            return BaseController.sendFailure(e.getResultCode(), e.getErrorData());
        }
        return BaseController.sendFailure(e);
    }

    /**
     * 未知异常
     *
     * @param e
     *            异常
     * @param request
     *            http请求
     * @return 吉客云返回体
     */
    @ExceptionHandler(Exception.class)
    public JackYunResponse<Object> handleException(Exception e, HttpServletRequest request) {
        LOG.error("", e);
        return BaseController.sendFailure(ResultCode.INTERNAL_ERROR);
    }

}
