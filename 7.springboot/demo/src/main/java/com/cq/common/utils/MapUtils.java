/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.utils;

import java.util.Map;

/**
 * <p>
 * 类描述: Map工具类
 * </p>
 *
 * @since 2018年11月20日
 * @author chengq
 */
public class MapUtils {

    private MapUtils() {
    }

    /**
     * 判断一个map是否为空
     *
     * @param map
     *            map对象
     * @return true or false
     */
    public static <T> boolean isEmpty(Map<T, T> map) {
        return (map == null || map.isEmpty());
    }

    /**
     * 根据key值获取map中相应的value值(String)
     *
     * @param map
     *            map对象
     * @param key
     *            map中key值
     * @return value值
     */
    public static <T> String getString(final Map<T, T> map, final Object key) {
        if (map != null) {
            Object answer = map.get(key);
            if (answer != null) {
                return answer.toString();
            }
        }
        return null;
    }
}
