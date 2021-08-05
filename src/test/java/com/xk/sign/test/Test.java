package com.xk.sign.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {
    public static void main(String[] args) {
        int week = 17;
        Calendar c = new GregorianCalendar();
        //设置星期一为一周开始的第一天
        c.setFirstDayOfWeek(Calendar.MONDAY);
        //设置在一年中第一个星期所需最少天数
        c.setMinimalDaysInFirstWeek(1);
        c.set(2021, Calendar.AUGUST, 9, 0, 0, 0);
        //获得当前日期属于今年的第几周
        int weekOfYearLastWeek = c.get(Calendar.WEEK_OF_YEAR);
        if (weekOfYearLastWeek - week < 0) {
            weekOfYearLastWeek = weekOfYearLastWeek + week;
        } else {
            weekOfYearLastWeek = weekOfYearLastWeek - week;
        }
        System.out.println("当前日期属于第" + weekOfYearLastWeek + "周");


    }

}
