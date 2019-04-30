/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.test.date;

import java.util.Date;

import com.cq.common.utils.DateUtils;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年3月20日
 * @author chengq
 */
public class WeekTest {

    public static void main(String[] args) {
        Date date = DateUtils.stringToDate("2019-06-01");
        Integer week = DateUtils.getWeekIndexInMonth(date);
        System.out.println("本月度第:" + week);
    }
}
