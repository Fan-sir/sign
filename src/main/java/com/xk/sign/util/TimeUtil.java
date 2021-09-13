package com.xk.sign.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component("timeUtil")
public class TimeUtil {

    @Value("${week}")
    Integer week;

    public static float time(long indexTime) {
        Date date = new Date();
        long nowTime = date.getTime();
        float time = (int) (nowTime - indexTime);
        time = time / 3600000;
        BigDecimal bd = new BigDecimal(time);
        return bd.setScale(2, RoundingMode.HALF_UP).floatValue();
    }

    public static String getDayOfWeekEng() {
        final String[] dayNames = {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek < 0) dayOfWeek = 0;
        return dayNames[dayOfWeek];
    }

    public Integer getWeek() {
        Calendar c = new GregorianCalendar();
        //设置星期一为一周开始的第一天
        c.setFirstDayOfWeek(Calendar.MONDAY);
        //设置在一年中第一个星期所需最少天数
        c.setMinimalDaysInFirstWeek(1);
//        c.set(2021, Calendar.JANUARY, 1, 20, 59, 59);
        //获得当前日期属于今年的第几周
        int weekOfYearLastWeek = c.get(Calendar.WEEK_OF_YEAR);
        if (weekOfYearLastWeek - week < 0) {
            weekOfYearLastWeek = weekOfYearLastWeek + week;
        } else {
            weekOfYearLastWeek = weekOfYearLastWeek - week;
        }
        System.out.println("当前日期属于第" + weekOfYearLastWeek + "周");

        return weekOfYearLastWeek;
    }
}
