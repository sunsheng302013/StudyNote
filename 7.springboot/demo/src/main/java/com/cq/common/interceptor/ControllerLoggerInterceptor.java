/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.interceptor;

import java.lang.reflect.Method;
import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

/**
 * 拦截器：控制日志输出
 *
 * @since 2018年1月30日 下午8:23:10
 * @author YuanMingEn
 *
 */
@Aspect
@Component
public class ControllerLoggerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerLoggerInterceptor.class);

    /**
     * 定义拦截规则
     */
    @Pointcut("execution(* com.cq.controller..*(..)))")
    public void methodPointcut() {
    }

    /**
     * 拦截器具体实现
     *
     * @param pjp
     *            ProceedingJoinPoint
     * @throws Throwable
     *             异常
     * @return Object
     */
    @Around("methodPointcut()")
    public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        // 获取被拦截的方法
        Method method = signature.getMethod();
        // 获取被拦截的方法名
        String methodName = method.getName();

        // 所有请求参数
        Object[] args = pjp.getArgs();
        int i = 0;
        String params = "";
        for (Object arg : args) {
            params += "[" + i + "]: " + JSON.toJSONString(arg) + " ";
            i++;
        }
        String intf = "{" + pjp.getTarget().getClass().getSimpleName() + "." + methodName + "}";
        Long sn = Calendar.getInstance().getTimeInMillis();
        LOG.info("===>>>>>>>>[" + sn + "]接口请求参数>>>>>>>>" + intf + params);

        result = pjp.proceed();
        // LOG.info("===>>>>>>>>[" + sn + "]接口返回结果>>>>>>>>" + intf + JSON.toJSONString(result));

        return result;
    }

}
