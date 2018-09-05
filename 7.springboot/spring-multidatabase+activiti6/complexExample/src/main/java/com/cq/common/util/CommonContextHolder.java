/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.util;

import java.util.Date;

/**
 * @since 2018年9月5日 上午10:19:03
 * @author chengq
 *
 */
public class CommonContextHolder {

    /**
     * @return
     */
    public static Long getLoggerSn() {
        return new Date().getTime();
    }

}
