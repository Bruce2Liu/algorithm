package com.example.algorithm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期时间工具类
 * 日期：date，时间：time
 * @author liujunhui
 * @date 2021/1/12 9:08
 */
public class DateTimeUtil {

    /**
     * 1.关于日期时间格式中字母大小写含义
     * https://www.cnblogs.com/suizhikuo/p/10189431.html
     * 2.大写HH取的是24小时，小写的hh取得12小时
     */
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String TIME_FORMAT = "HH:mm:ss";

    public static final String CST_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";

    /** ==========================================Date API================================================== */

    public static Date getNowDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static Date parseDate(String date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 日期字符串格式转换
     * @param dateStr 被转换的日期字符串
     * @param srcPattern 被转换的日期格式
     * @param destPattern 转换的目标格式
     * @return String
     */
    public static String transDateFormat(String dateStr, String srcPattern, String destPattern) {
        Date date = parseDate(dateStr, srcPattern);
        return date == null ? null : formatDate(date, destPattern);
    }

    /** ==========================================Java8时间新特性================================================== */

    /**
     * 格式化日期时间
     * @param temporal 需要转换的日期时间
     * @param pattern 日期时间格式
     * @return
     */
    public static String format(TemporalAccessor temporal, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(temporal);
    }

    /**
     * 获取当前日期时间
     */
    public static String getLocalDateTime() {
        return format(LocalDateTime.now(), DATETIME_FORMAT);
    }

    /**
     * 日期时间字符串转为日期时间
     */
    public static LocalDateTime parseLocalDateTime(String dateStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateStr, formatter);
    }

    public static void main(String[] args) throws ParseException {
        String dateTime = getLocalDateTime();

        LocalDateTime localDateTime1 = LocalDateTime.parse("2021-02-20T10:50:38");
        LocalDateTime localDateTime = parseLocalDateTime("2021-02-20 10:50:38", DATETIME_FORMAT);

        LocalDate.parse("2020-05-12", DateTimeFormatter.ofPattern(DATE_FORMAT));
        String time = format(LocalTime.now(), TIME_FORMAT);

        transDateFormat("2020-11-12", "yyyy-MM-dd", "yyyy年MM月d日");

        String dateStr = "Wed Jul 31 00:00:00 CST 2019";
        Date date = parseDate(dateStr, CST_FORMAT);

        System.out.println(1);
    }
}
