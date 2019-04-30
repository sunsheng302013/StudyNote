/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @since 2018年1月25日 上午10:26:46
 * @author YuanMingEn
 *
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface SortField {

    /**
     *
     * @return 排序字段
     */
    String column();
}
