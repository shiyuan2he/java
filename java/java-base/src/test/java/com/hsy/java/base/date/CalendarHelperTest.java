package com.hsy.java.base.date;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author heshiyuan
 * @date 2020/7/2 11:27
 */
public class CalendarHelperTest {

    @Test
    public void testCalendarAMAndPM(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.AM_PM)==Calendar.AM);
        System.out.println(calendar.get(Calendar.AM_PM)==Calendar.PM);

        calendar.add(Calendar.HOUR_OF_DAY, -10);
        System.out.println(calendar.get(Calendar.AM_PM)==Calendar.AM);
        System.out.println(calendar.get(Calendar.AM_PM)==Calendar.PM);

        Calendar gregorianCalendar = GregorianCalendar.getInstance();
        System.out.println(gregorianCalendar.get(GregorianCalendar.AM_PM));
        System.out.println(gregorianCalendar.get(GregorianCalendar.AM_PM));
    }
}