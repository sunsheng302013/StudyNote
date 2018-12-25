/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.utils;

/**
 * <p>
 * 类描述:字符串相关工具类
 * </p>
 *
 * @since 2018年10月30日
 * @author chengq
 */
public class StringUtilPlus {

    /** 初始化方法 **/
    protected StringUtilPlus() {
    }

    /**
     * String 首字母大写
     *
     * @param msg
     *            String字符串
     * @return 首字母大写的String字符串
     */
    public static String UpperCaseFirston(String msg) {
        char[] cs = msg.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }
}
