/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据表头映射
 *
 * @since 2018年3月9日 上午11:01:10
 * @author JiaFeng Feng
 *
 */
public class ExcelDataHeaderMappingUtil {
    /**
     * 两个数组返回一个map
     *
     * @param headvalue
     * @param value
     * @return
     */
    public static Map<String, Integer> getMap(String[] headvalue, String value[]) {
        Map<String, Integer> map = new HashMap<>(8);
        for (int i = 0; i < headvalue.length; i++) {
            String index = value[i];
            // 如果没有选择就不做映射
            if (!"".equals(index)) {
                map.put(headvalue[i], Integer.valueOf(index));
            }
        }
        return map;
    }
}
