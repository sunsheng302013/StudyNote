/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * @since 2018年7月9日 下午1:29:46
 * @author differ
 * @param <T>
 *
 */
public class JsonUtil {

    /**
     * json字符串转化为list列表
     * 
     * @param json
     * @param targetClass
     * @return
     */
    public static <T> List<T> JsonToList(String json, Class<T> targetClass) {
        List<T> jsonList = JSONObject.parseArray(json, targetClass);
        return jsonList;
    }
}
