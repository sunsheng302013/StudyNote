/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.util;

import java.util.List;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

/**
 * @Description: json字符串返序列化
 * @since 2018年8月28日 下午5:13:56
 * @author chengq
 *
 */
public class DeserializationConverter {

    /**
     * json字符串转化为实体类
     *
     * @param json
     * @param targertClass
     * @param <T>
     * @return
     */
    public static <T> T jsonToEntity(String json, Class<T> targertClass) {
        if (!StringUtils.isEmpty(json)) {
            T entity = JSON.parseObject(json, targertClass);
            return entity;
        }
        return null;
    }

    /**
     * json字符串转化为list
     *
     * @param json
     * @param targertClass
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String json, Class<T> targertClass) {
        if (!StringUtils.isEmpty(json)) {
            List<T> list = JSON.parseArray(json, targertClass);
            return list;
        }
        return null;
    }
}
