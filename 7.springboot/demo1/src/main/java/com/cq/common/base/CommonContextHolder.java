/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.base;

import java.util.Date;

/**
 * 获取当前时间
 * 
 * @since 2018年9月5日 上午10:19:03
 * @author chengq
 *
 */
public class CommonContextHolder {

    private CommonContextHolder() {
    }

    /**
     * @return 当前时间
     */
    public static Long getLoggerSn() {
        return new Date().getTime();
    }

}
