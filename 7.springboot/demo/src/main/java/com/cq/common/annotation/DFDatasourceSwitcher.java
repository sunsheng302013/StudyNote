package com.cq.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解 默认db1
 *
 * @since 2018年8月31日 下午4:51:43
 * @author chengq
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface DFDatasourceSwitcher {
    /**
     * DS注解字段，默认db1
     *
     * @return 字段值
     */
    String value() default "db1";
}
