/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 分页查询注解
 *
 * @since 2018年1月3日 上午10:22:31
 * @author YuanMingEn
 *
 */
@Documented
@Retention(RUNTIME)
@Target({ ElementType.METHOD })
public @interface Pagination {

}
