package com.ediancha.edcbusiness.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 2017/8/28.
 */

public class TimeFormatUtils {
    /**
  * 将时间戳转换为时间
  */
    public static String stampToDate(long s) {
        Date d = new Date(s*1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(d);
    }

    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long lt = new Long(s);
        Date date = new Date(lt*1000);
        res = simpleDateFormat.format(date);
        return res;
    }
    public static String stamp2Date(long s) {
        Date d = new Date(s*1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(d);
    }

    public static String stamp2Date(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long lt = new Long(s);
        Date date = new Date(lt*1000);
        res = simpleDateFormat.format(date);
        return res;
    }


}
