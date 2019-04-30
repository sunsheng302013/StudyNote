package com.cq.common.utils;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * <p>
 * 类描述: String工具类
 * </p>
 *
 * @since 2019年1月9日
 * @author chengq
 */
public class StringUtilsPlus {

    /** 字母偏移量 **/
    private static final Integer NUM = 32;

    /** 初始化方法 **/
    protected StringUtilsPlus() {
    }

    /**
     * 是否为空 为空时返回true
     *
     * @param str
     *            字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String str) {
        return null == str || "".equals(str);
    }

    /**
     * 是否为空 不为空时返回true
     *
     * @param str
     *            字符串
     * @return 是否不为空
     */
    public static boolean isNotEmpty(String str) {
        return null != str && !"".equals(str);
    }

    /**
     * 去空格
     *
     * @param str
     *            字符串
     * @return 去除空格
     */
    public static String trim(String str) {
        if (isNotEmpty(str)) {
            return str.trim();
        }
        return null;
    }

    /**
     * 获取Map参数值
     *
     * @param map
     *            map对象
     * @return map参数值
     */
    public static String getMapString(Map<String, String> map) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            result.append(entry.getValue()).append(" ");
        }
        return result.toString();
    }

    /**
     * 获取List参数值
     *
     * @param list
     *            list对象
     * @return list参数值
     */
    public static String getListString(List<String> list) {
        if (ListUtils.isNotEmpty(list)) {
            return StringUtils.join(list.toArray(), ",");
        }
        return null;
    }

    /**
     * String 首字母大写
     *
     * @param msg
     *            String字符串
     * @return 首字母大写的String字符串
     */
    public static String upperCaseFirston(String msg) {
        char[] cs = msg.toCharArray();
        cs[0] -= NUM;
        return String.valueOf(cs);
    }
}
