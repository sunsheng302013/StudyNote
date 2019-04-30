package com.cq.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解 默认master
 *
 * @since 2018年8月31日 下午4:51:43
 * @author chengq
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DatasourceSwitcher {
    /**
     * DS注解字段，默认master
     *
     * @return 字段值
     */
    String value() default "master";
}
