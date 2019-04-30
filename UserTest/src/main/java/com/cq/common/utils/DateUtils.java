/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 * 类描述:时间相关工具类
 * </p>
 *
 * @since 2018年10月30日
 * @author chengq
 */
public class DateUtils {

    private static final Long DAYS = 365L;

    /** 初始化方法 **/
    protected DateUtils() {
    }

    /**
     * 计算当前日期与开始时间的间隔天数
     *
     * @param startDate
     *            开始时间
     * @return 间隔天数
     */
    public static Long until(LocalDate startDate) {
        return startDate.until(LocalDate.now(), ChronoUnit.DAYS);
    }

    /**
     * 计算日期开始时间与结束时间的间隔天数
     *
     * @param startDate
     *            开始时间
     * @param endDate
     *            结束事件
     * @return 间隔天数
     */
    public static Long until(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate, ChronoUnit.DAYS);
    }

    /**
     * LocalDate时间格式转为Date格式
     *
     * @param localDate
     *            时间格式
     * @return 返回Date格式时间
     */
    public static Date localDateToDate(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * Date格式转为LocalDate时间格式
     *
     * @param date
     *            时间格式
     * @return 返回LocalDate格式时间
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        return instant.atZone(zoneId).toLocalDate();
    }

    /**
     * String转为Date格式
     *
     * @param strDate
     *            String格式的时间
     * @param format
     *            时间格式
     * @return Date格式时间
     */
    public static Date stringToDate(String strDate, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * String转为Date格式 默认时间格式为"yyyy-MM-dd hh:mm:ss"
     *
     * @param strDate
     *            String格式的时间
     * @return Date格式时间
     */
    public static Date stringToDate(String strDate) {
        if (strDate.contains(":")) {
            String format = "yyyy-MM-dd hh:mm:ss";
            return stringToDate(strDate, format);
        } else {
            String format = "yyyy-MM-dd";
            return stringToDate(strDate, format);
        }
    }

    /**
     * date转为String格式(默认"yyyy-MM-dd")
     *
     * @param date
     *            date格式日期
     * @return String
     */
    public static String dateToString(Date date) {
        if (null == date) {
            return null;
        }
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * date转为String格式
     *
     * @param date
     *            date格式日期
     * @param format
     *            时间格式
     * @return String
     */
    public static String dateToString(Date date, String format) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 查询某一时间点距离当前时间的年数(保留两位小数)
     *
     * @param date
     *            时间点
     * @return 间隔年数
     */
    public static double getUnitlYear(Date date) {
        LocalDate localDate = dateToLocalDate(date);
        Long days = until(localDate);
        double year = days * 1.0 / DAYS;
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(year));
    }

    /**
     * 获取当天开始时间 "yyyy-mm-dd"格式
     *
     * @return Date 当前时间
     */
    public static Date getNowData() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 本年第几周
     *
     * @param date
     *            当前日期
     * @return 今年第几周
     */
    public static Integer getWeekIndexInYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 第几周
        Integer week = calendar.get(Calendar.WEEK_OF_MONTH);
        return week;
    }

    /**
     * 本月第几周
     *
     * @param date
     *            当前日期
     * @return 本月第几周
     */
    public static Integer getWeekIndexInMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 第几周
        Integer week = calendar.get(Calendar.WEEK_OF_MONTH);
        return week;
    }

    /**
     * 获取本周第几天 从周日开始
     *
     * @param date
     *            当前日期
     * @return 本月第几天
     */
    public static Integer getDayIndex(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 第几天，从周日开始
        Integer day = calendar.get(Calendar.DAY_OF_WEEK);
        return day;
    }

    /**
     * 工具类测试
     *
     * @param args
     *            参数
     */
    public static void main(String[] args) {
        // String birth = "19950921";
        // Date date = stringToDate(birth, "yyyyMMdd");
        // LocalDate localDate = dateToLocalDate(date);
        // Long days = until(localDate);
        // double year = days * 1.0 / DAYS;
        // DecimalFormat df = new DecimalFormat("#.##");
        // Integer year2 = (int) Double.parseDouble(df.format(year));
        Integer week = getWeekIndexInMonth(new Date());
        Integer day = getDayIndex(new Date());
        System.out.println("本月第" + week + "周");
        System.out.println("本周第" + day + "天");
    }
}
