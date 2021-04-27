package com.yuzheng14.util;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * @author yuzheng14
 */
@Component
public class DateUtil {
    private final static long MILLISENCONDS_OF_ONE_DAY =1000*60*60*24;
    private final static Calendar calendar =Calendar.getInstance();

    public static java.sql.Date util2sql(java.util.Date date){
        return new java.sql.Date(date.getTime());
    }

    /**
     * 获取当天，但是小时分钟秒和毫秒均为0
     * @return
     */
    public static Date today(){
        calendar.setTime(new Date());

        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);

        return calendar.getTime();
    }

    /**
     * 获取月初
     * @return
     */
    public static Date monthBegin(){
        calendar.setTime(new Date());

        calendar.set(Calendar.DATE,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);

        return calendar.getTime();
    }

    /**
     * 获取月末
     * @return
     */
    public static Date monthEnd(){
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);

        calendar.set(Calendar.DATE,1);
        calendar.add(Calendar.MONTH,1);
        calendar.add(Calendar.DATE,-1);

        return calendar.getTime();
    }

    /**
     * 获取本月一共有多少天
     * @return
     */
    public static int thisMonthTotalDay(){
        long lastDayMilliSeconds=monthEnd().getTime();
        long firstDayMilliSeconds=monthBegin().getTime();
        return (int)((lastDayMilliSeconds-firstDayMilliSeconds)/MILLISENCONDS_OF_ONE_DAY)+1;
    }

    /**
     * 获取本月还剩多少天
     * @return
     */
    public static int thisMonthLeftDay(){
        long lastDayMilliSeconds=monthEnd().getTime();
        long todayMilliSeconds=today().getTime();
        return (int)((lastDayMilliSeconds-todayMilliSeconds)/MILLISENCONDS_OF_ONE_DAY)+1;
    }
}
