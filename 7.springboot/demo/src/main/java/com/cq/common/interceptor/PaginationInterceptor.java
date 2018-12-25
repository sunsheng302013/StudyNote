/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */

package com.cq.common.interceptor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cq.common.annotation.SortField;
import com.cq.common.base.PageInfo;

/**
 * 拦截器：分页方法
 *
 * @since 2018年1月24日 下午8:23:10
 * @author YuanMingEn
 *
 */

@Aspect
@Component
public class PaginationInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(PaginationInterceptor.class);

    /**
     * 定义拦截规则
     */
    @Pointcut("execution(* com.cq.service..*(..)) && @annotation(com.cq.common.annotation.Pagination)")
    public void methodPointcut() {
    }

    /**
     * 拦截器具体实现
     *
     * @param pjp
     *            ProceedingJoinPoint
     * @return Object
     * @throws Throwable
     *             异常
     */

    @Around("methodPointcut()")
    public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        // 获取被拦截的方法
        Method method = signature.getMethod();
        // 获取被拦截的方法名
        String methodName = method.getName();
        LOG.debug("=========分页排序拦截==========>方法：{" + methodName + "}");

        // 方法的返回类型
        Type returnType = method.getGenericReturnType();
        LOG.debug("=========分页排序拦截==========>返回类型：{" + returnType.getTypeName() + "}");

        // 所有请求参数
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            LOG.debug("=========分页排序拦截==========>方法参数: {" + arg + "}");
            // 带有Page参数的方法才处理
            if (arg instanceof PageInfo) {
                PageInfo page = (PageInfo) arg;
                if (page.getSortField() == null || "".equals(page.getSortField())) {
                    continue;
                }
                // 如果传入的sortFiled = info.xxxx,需要去掉info.转成xxxx
                String sortField = page.getSortField();
                if (sortField.contains(".")) {
                    sortField = sortField.substring(sortField.lastIndexOf(".") + 1, sortField.length());
                }
                page.setSortField(sortField);
                processPage(page, returnType);
            }
        }

        result = pjp.proceed();
        return result;
    }

    /**
     * 处理参数类型带有Page对象的方法
     *
     * @param page
     * @param returnType
     */

    @SuppressWarnings("rawtypes")
    private void processPage(PageInfo page, Type returnType) {
        // 如果是泛型参数的类型，得到其Generic的类型
        if (returnType instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) returnType;
            // 得到泛型里的class类型对象。
            Class genericClazz = (Class) pt.getActualTypeArguments()[0];
            LOG.debug("=========分页排序拦截==========>返回类型List中的泛型type：{" + genericClazz.getSimpleName() + "}");

            // 得到所有需要填充的字典字段
            Class<?> clazz = genericClazz;
            // 循环自己和父类所有属性
            for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    boolean findSortFiled = processSortField(page, field);
                    if (findSortFiled) {
                        break;

                    }
                }
            }
        }
    }

    /**
     * 处理排序字段替换
     *
     * @param page
     * @param field
     * @return
     */
    private boolean processSortField(PageInfo page, Field field) {
        boolean findSortFiled = false;
        // 如果返回对象中的可以排序字段==传入page对象中的sortFiled相等,则替换
        // 例子：page.sortFiled = "waveNo" 转成 -> page.sortFiled = "wave_no"
        if (page.getSortField() != null && page.getSortField().equals(field.getName())) {
            LOG.debug("=========分页排序拦截==========>得到page对象中的排序字段：{" + page.getSortField() + "}");
            // 如果排序字段没有设置SortFiled注解，表示该字段不能排序，设成null
            page.setSortField(null);
            field.setAccessible(true);
            if (field.isAnnotationPresent(SortField.class)) {
                try {
                    SortField sortFiled = field.getAnnotation(SortField.class);
                    String column = sortFiled.column();
                    page.setSortField(column);

                    LOG.debug("=========分页排序拦截==========>替换page对象中的排序字段为：{" + sortFiled.column() + "}");
                    findSortFiled = true;
                } catch (Throwable t) {
                    LOG.error("", t);
                } finally {
                    field.setAccessible(false);
                }
            }
        }
        return findSortFiled;
    }
}
