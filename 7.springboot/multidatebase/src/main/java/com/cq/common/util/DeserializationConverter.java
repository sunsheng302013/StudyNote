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

    private DeserializationConverter() {
    }

    /**
     * json字符串转化为实体类
     *
     * @param json
     *            字符串
     * @param targertClass
     *            目标类
     * @param <T>
     *            类
     * @return 实体类对象
     */
    static <T> T jsonToEntity(String json, Class<T> targertClass) {
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
     *            字符串
     * @param targertClass
     *            目标类
     * @param <T>
     *            类
     * @return 返回list列表
     */
    public static <T> List<T> jsonToList(String json, Class<T> targertClass) {
        if (!StringUtils.isEmpty(json)) {
            List<T> list = JSON.parseArray(json, targertClass);
            return list;
        }
        return null;
    }

    /**
     * list转化为json字符串
     *
     * @param <T>
     *
     * @param list
     *            集合
     * @param <T>
     *            类
     * @return 返回list列表
     */
    public static <T> String listToJson(List<T> list) {
        if (list != null && list.size() > 0) {
            String json = JSON.toJSONString(list);
            return json;
        }
        return null;
    }

}
