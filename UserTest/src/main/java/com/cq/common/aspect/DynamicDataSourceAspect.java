/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.cq.common.annotation.DatasourceSwitcher;
import com.cq.common.datasource.DataSourceContextHolder;

/**
 *
 * <p>
 * 类描述: 自定义注解 + AOP的方式实现数据源动态切换
 * </p>
 *
 * @since 2019年1月15日
 * @author chengq
 */
@Aspect
@Component
@Order(value = 0)
public class DynamicDataSourceAspect {

    /**
     * 在注解的方法运行前前改变数据源
     *
     * @param point
     *            切点
     * @param ds
     *            注解
     */
    @Before("@annotation(ds)")
    public void beforeSwitchDS(JoinPoint point, DatasourceSwitcher ds) {
        // 获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        // 获得访问的方法名
        String methodName = point.getSignature().getName();
        // 得到方法的参数的类型
        Class<?>[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
        String dataSource = DataSourceContextHolder.DEFAULT_DS;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@DS注解
            if (method.isAnnotationPresent(DatasourceSwitcher.class)) {
                DatasourceSwitcher annotation = method.getAnnotation(DatasourceSwitcher.class);
                // 取出注解中的数据源名
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 切换数据源
        DataSourceContextHolder.setDB(dataSource);
    }

    /**
     * 注解的方法执行后清楚数据源
     *
     * @param point
     *            切点
     * @param ds
     *            注解
     */
    @After("@annotation(ds)")
    public void afterSwitchDS(JoinPoint point, DatasourceSwitcher ds) {
        DataSourceContextHolder.clearDB();
    }
}
