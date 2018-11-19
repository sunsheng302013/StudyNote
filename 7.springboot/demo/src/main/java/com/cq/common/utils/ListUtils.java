/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.utils;

import java.util.List;

/**
 * <p>
 * 类描述: 集合工具类
 * </p>
 * 
 * @since 2018年10月10日
 * @author wengjiaxin
 */
public class ListUtils {

    private ListUtils() {
    }

    /**
     * 判断一个List是否为null或者空.
     * 
     * ListUtils.isEmpty(null) = true ListUtils.isEmpty([]) = true ListUtils.isEmpty([null]) = true
     * ListUtils.isEmpty([1]) = false ListUtils.isEmpty([1,2]) = false
     * 
     * @param list
     *            需要判断的List
     * @param <T>
     *            泛型
     * @return 判断结果
     */
    public static <T> boolean isEmpty(List<T> list) {
        boolean isEmpty = true;
        if (list != null) {
            if (list.size() != 0) {
                if (!(list.size() == 1 && list.get(0).equals("null"))) {
                    isEmpty = false;
                }
            }
        }
        return isEmpty;
    }

    /**
     * 判断一个List是否不为null且不为空.
     * 
     * ListUtils.isNotEmpty(null) = false ListUtils.isNotEmpty([]) = false
     * ListUtils.isNotEmpty([null]) = false ListUtils.isNotEmpty([1]) = true
     * ListUtils.isNotEmpty([1,2]) = true
     * 
     * @param list
     *            需要判断的List
     * @param <T>
     *            泛型
     * @return 判断结果
     */
    public static <T> boolean isNotEmpty(List<T> list) {
        return !isEmpty(list);
    }

}
