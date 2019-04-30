/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
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

    /** map默认大小 **/
    private static final Integer MAPSIZE = 10;

    private MapUtils() {
    }

    /**
     * 判断一个map是否为空
     *
     * @param <T>
     *            统配符
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
     * @param <T>
     *            统配符
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

    /**
     * 将实体对象转成map key是对象变量名，value是对象变量值
     *
     * @param obj
     *            对象
     * @return map 返回map
     * @throws Exception
     *             异常信息
     */
    public static Map<String, Object> objectToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(obj);
                if (null != value && !"".equals(value)) {
                    if (!"serialVersionUID".equals(fieldName)) {
                        map.put(fieldName, value);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                field.setAccessible(false);
            }
        }
        return map;
    }

    /**
     * 两个数组返回一个map
     *
     * @param headvalue
     *            表头字段
     * @param value
     *            表头字段值
     * @return map
     */
    public static Map<String, Integer> getMap(String[] headvalue, String[] value) {
        Map<String, Integer> map = new HashMap<>(MAPSIZE);
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
