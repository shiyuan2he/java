/**
 * @path paac-core/com.codelibrary.javaee.utils/DateHelper.java	
 * @time May 2, 2016 10:25:31 AM
 * @githob 
 *     http://githob.com/shiyuan2he
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
package com.hsy.java.base.date;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	/**
	 * @description <p>将时间转化成指定格式的字符串时间</p>
	 * @param formate	格式化类型
	 * @return			格式化之后的时间
	 * @returnType String
	 * @author heshiyuan @date 2017年3月9日 下午7:10:53
	 * @date 2017年3月9日 下午7:10:53
	 * ￥：三毛三
	 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
	 * @email heshiyuan@chtwm.com
	 * @callnumber 15910868535
	 */
	public static String getStrFromDateOfFormate(Date dateTime,String formate){
		SimpleDateFormat sdf = null ;
		if(!"".equals(formate) && null!=formate){
			sdf = new SimpleDateFormat(formate) ;
		}else{
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		return sdf.format(dateTime);
	}
	/**
	 * @description <p>将字符类型的时间转化成指定格式的时间</p>
	 * @param strTime	需要转化的字符串时间
	 * @param formate	格式化类型
	 * @return			格式化之后的时间
	 * @returnType Date
	 * @author heshiyuan @date 2017年3月9日 下午7:15:51
	 * @date 2017年3月9日 下午7:15:51
	 * ￥：三毛三
	 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
	 * @email heshiyuan@chtwm.com
	 * @callnumber 15910868535
	 */
	public static Date getDateFromStrOfFormate(String strTime,String formate){
		SimpleDateFormat sdf = null ;
		if(!"".equals(formate) && null!=formate){
			sdf = new SimpleDateFormat(formate) ;
		}else{
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		try {
			return sdf.parse(strTime) ;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null ;
	}
	/**
	 * @description <p>判断日期是不是周末</p>
	 * @param calendar
	 * @return
	 * @returnType boolean
	 * @author heshiyuan @date 2017年3月9日 下午8:29:19
	 * @path javase-common/com.javase.util/DateHelper.java
	 * @date 2017年3月9日 下午8:29:19
	 * @price ￥：三毛三
	 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
	 * @email heshiyuan@chtwm.com
	 * @callnumber 15910868535
	 */
	public static boolean isWeekEnd(Calendar calendar){
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) ;
		if(dayOfWeek == 1 || dayOfWeek == 7){ //每周第一天是周日，最后一天是周六
			return true ;
		}else {
			return false ;
		}
	}
	/**
	 * @description 
	 *		<p></p>
	 * @time 2016年10月16日 下午9:23:02
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType String
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static String dateToString(Date time){ 
	    SimpleDateFormat formatter; 
	    formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss"); 
	    String ctime = formatter.format(time); 
	    return ctime; 
	}

    /**
     * @description <p>获得世界协调时的近似值,0时区时间</p>
     * @author heshiyuan
     * @dateTime 2018/10/30 17:05
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    public static Date getUTCTime(){
        Calendar cal = Calendar.getInstance();
        //获得时区和 GMT-0 的时间差,偏移量
        int offset = cal.get(Calendar.ZONE_OFFSET);
        //获得夏令时  时差
        int dstoff = cal.get(Calendar.DST_OFFSET);
        cal.add(Calendar.MILLISECOND, - (offset + dstoff));
        return cal.getTime();

    }

    /**
     * @description <p>获得世界协调时的近似值</p>
     * @param format	格式化的时间格式
     * @author heshiyuan
     * @dateTime 2018/10/30 17:05
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    public static String getUTCTime(String format){
        String formatDate = format(getUTCTime(), format);
        return formatDate;
    }

    /**
     * @description <p>根据传入得本地时间获得 获得 这个对应得UTC 时间</p>
     * @author heshiyuan
     * @dateTime 2018/10/30 17:05
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    public static String getUTCTimeByLocalTime(String localDate,String format){
        Calendar cal = Calendar.getInstance();
        //获得时区和 GMT-0 的时间差,偏移量
        int offset = cal.get(Calendar.ZONE_OFFSET);
        //获得夏令时  时差
        int dstoff = cal.get(Calendar.DST_OFFSET);
        Date date = new Date(getMillSecond(format, localDate) - (offset + dstoff));//获得当前是UTC时区的时间毫秒值
        String formatDate = format(date, format);
        return formatDate;
    }

    /**
     * @description <p>根据utc时间的字符串形式,获得当前时区的本地时间</p>
     * @param utcTime  时间字符串形式
     * @param format   时间格式为:yyyyMMddHHmmssS   精确到毫秒值
     * @author heshiyuan
     * @dateTime 2018/10/30 17:06
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    public static Date getLocalZoneTime(String utcTime,String format){
        Calendar cal = Calendar.getInstance();
        //获得时区和 GMT-0 的时间差,偏移量
        int offset = cal.get(Calendar.ZONE_OFFSET);
        //获得夏令时  时差
        int dstoff = cal.get(Calendar.DST_OFFSET);
        //cal.add(getMillSecond(format, utcTime),+(offset + dstoff));
        Date date = new Date(getMillSecond(format, utcTime) + (offset + dstoff));//获得当前是时区的时间毫秒值
        return date;

    }

    /**
     * 根据utc时间的字符串形式,获得当前时区的本地时间
     * @param utcTime  时间字符串形式
     * @param format   时间格式为:yyyyMMddHHmmssS   精确到毫秒值
     * @author heshiyuan
     * @dateTime 2018/10/30 17:06
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    public static String getLocalZoneTimeString(String utcTime,String format){
        return format(getLocalZoneTime(utcTime, format),format);
    }

    /**
     * 根据时间的字符串形式获得时间的毫秒值
     * @param format   最好为yyyyMMddHHmmssS 精确到毫秒值,这样转换没有精度损失
     * @author heshiyuan
     * @dateTime 2018/10/30 17:07
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    public static long getMillSecond(String format,String time){
        Date parse = parse(time, format);
        return parse.getTime();
    }

    /**
     * 使用用户格式格式化日期
     * @param date 日期
     * @param pattern 日期格式
     * @author heshiyuan
     * @dateTime 2018/10/30 17:07
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    public static String format(Date date, String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return (returnValue);
    }

    /**
     * 使用用户格式提取字符串日期
     * @param strDate 日期字符串
     * @param pattern 日期格式
     * @author heshiyuan
     * @dateTime 2018/10/30 17:07
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    public static Date parse(String strDate, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String SIMPLE_DAY_FORMAT = "yyyyMMdd";
    public static final Long MILLIS_OF_ONE_YEAR = 31536000000L;

    /**
     * 获取当前UTC时间
     *
     * @return 返回UTC时间毫秒
     */
    public static long now() {
        Calendar cal = Calendar.getInstance();
        int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
        int dstOffset = cal.get(Calendar.DST_OFFSET);
        cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        return cal.getTimeInMillis();
    }


    public static String nowStr() {
        Calendar cal = Calendar.getInstance();
        int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
        int dstOffset = cal.get(Calendar.DST_OFFSET);
        cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(cal.getTime());
    }

    public static String now(String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(new Date(now()));
    }

    public static int nowYearMonthDay() {
        Calendar cal = Calendar.getInstance();
        int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
        int dstOffset = cal.get(Calendar.DST_OFFSET);
        cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        SimpleDateFormat formatter = new SimpleDateFormat(SIMPLE_DAY_FORMAT);
        return Integer.parseInt(formatter.format(cal.getTime()));
    }

    /**
     * 获取当前UTC时间
     *
     * @return 返UTC秒
     */
    public static long currentTime() {
        Calendar cal = Calendar.getInstance();
        int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
        int dstOffset = cal.get(Calendar.DST_OFFSET);
        cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        return cal.getTimeInMillis() / 1000;
    }


    public static LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        return zdt.toLocalDate();
    }


    public static Long getTimeMilliseconds(String time) {
        if (!StringUtils.isNotBlank(time)) {
            return now();
        }
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(formatter.parse(time));
            int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
            int dstOffset = cal.get(Calendar.DST_OFFSET);
            cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
            return cal.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String fromMilliseconds(Long milliseconds) {
        if (milliseconds == null || milliseconds == 0) {
            milliseconds = now();
        }
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        Date date = new Date(milliseconds);
        return formatter.format(date);
    }


    public static String fromMilliseconds(long milliseconds) {
        if (milliseconds == 0) {
            milliseconds = now();
        }
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        Date date = new Date(milliseconds);
        return formatter.format(date);
    }


    public static long simpleDay2Milliseconds(int day) {
        SimpleDateFormat formatter = new SimpleDateFormat(SIMPLE_DAY_FORMAT);
        try {
            return formatter.parse(String.valueOf(day)).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int milliseconds2SimpleDay(long milliseconds) {
        Date date = new Date(milliseconds);
        SimpleDateFormat formatter = new SimpleDateFormat(SIMPLE_DAY_FORMAT);
        return Integer.parseInt(formatter.format(date));
    }
}

