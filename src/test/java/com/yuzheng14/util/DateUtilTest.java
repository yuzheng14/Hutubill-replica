package com.yuzheng14.util;

import org.junit.Test;

import java.util.Date;

public class DateUtilTest {
    @Test
    public void thisMonthTotalDayTest(){
        System.out.println(DateUtil.thisMonthTotalDay());
    }
    @Test
    public void thisMonthLeftDayTest(){
        System.out.println(DateUtil.thisMonthLeftDay());
    }
    @Test
    public void monthEndTest(){
        System.out.println(DateUtil.monthEnd());
    }
    @Test
    public void monthBeginTest(){
        System.out.println(DateUtil.monthBegin());
    }
    @Test
    public void todayTest(){
        System.out.println(DateUtil.today());

    }
}
