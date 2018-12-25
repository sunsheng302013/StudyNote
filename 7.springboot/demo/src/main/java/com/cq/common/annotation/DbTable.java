/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * <p>
 * 类描述:子表字段注解。 用途：查询字段添加该注解，value为子表名称，若该字段为null，则不关联该子表，若该字段不为null，则关联子表查询
 * </p>
 *
 * @since 2018年12月25日
 * @author chengq
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface DbTable {
    String name();
}
