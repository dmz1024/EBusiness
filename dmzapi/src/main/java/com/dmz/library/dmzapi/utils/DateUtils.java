package com.dmz.library.dmzapi.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
    // 输入年月日,获得星期值
    public static String returnWeek(int year, int month, int day) {
        // 根据日历类对象的方法，实例化一个当前的日历类对象
        Calendar calendar = Calendar.getInstance();
        // 设置日历对象的年月日
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);// �·���0-11
        calendar.set(Calendar.DAY_OF_MONTH, day);

        // 得到本月中的第一天是星期几
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};// 字符串数组
        return weeks[week];

    }

    // 输入年月,得到那个月1号是星期几
    public static int returnFirstdayIsWeek(int year, int month) {
        // 根据日历类对象的方法，实例化一个当前的日历类对象
        Calendar calendar = Calendar.getInstance();
        // 设置日历对象的年月日
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);// 月份是0-11
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // 得到本月中的第一天是星期几
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int[] weeks = {0, 1, 2, 3, 4, 5, 6};// 字符串数组

        return weeks[week];
    }

    // 输入年月,得到那个月一共多少天
    public static int maxDayOfMonth(int year, int month) {
        // 根据日历类对象的方法，实例化一个当前的日历类对象
        Calendar calendar = Calendar.getInstance();
        // 设置日历对象的年月日
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);// 月份是0-11
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // 得到当前月份的最大值
        int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return day;
    }


    public static String getYMD() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return sDateFormat.format(System.currentTimeMillis());
    }



    public static int getHour(){
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.HOUR_OF_DAY);
    }
}