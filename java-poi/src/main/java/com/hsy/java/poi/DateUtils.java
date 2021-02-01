package com.hsy.java.poi;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
* @Title: DateUtils.java     
* @author zzf   
* @date 2017年9月26日 下午1:16:40   
* @version V1.0     
* @Description: 时期格式转化类
 */
public class DateUtils {

	/**
	 * 使用线程安全策略
	 */
	private static ThreadLocal<SimpleDateFormat> local = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static String format(Date date) {
        return local.get().format(date);
    }

    public static Date parse(String dateStr) throws ParseException {
        return local.get().parse(dateStr);
    }
    
    
    private static ThreadLocal<SimpleDateFormat> yearMonthDayTime = new ThreadLocal<SimpleDateFormat>() {
        @Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMddHHmmss");
		}
    };
    
    public static String formatYearMonthDayTime(Date date) {
        return yearMonthDayTime.get().format(date);
    }

    public static Date parseYearMonthDayTime(String dateStr) throws ParseException {
        return yearMonthDayTime.get().parse(dateStr);
    }

	private static ThreadLocal<SimpleDateFormat> yearMonthDayTimeSplit = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};
	public static String formatYearMonthDayTimeH(Date date) {
		if(date == null){
			return  "";
		}
		return yearMonthDayTimeSplit.get().format(date);
	}
	public static Date parseYearMonthDayTimeH(String dateStr) throws ParseException {
		return yearMonthDayTimeSplit.get().parse(dateStr);
	}

	/**
	 * 将时间戳转化成时间格式(yyyy-MM-dd HH:mm:ss)
	 * @param longDate
	 * @return
	 */
	public static String formatYmdhms(String longDate){

		String res;
		long lt = new Long(longDate);
		Date date = new Date(lt);
		res = yearMonthDayTimeSplit.get().format(date);
		return res;
	}

	/**
	 * 将时间戳转化成时间格式(yyyy-MM-dd)
	 * @param longDate
	 * @return
	 */
	public static String formatYmd(String longDate){
		long lt = new Long(longDate);
		Date date = new Date(lt);
		return local.get().format(date);
	}
	
    /**
	 * 获取时分秒毫秒
	 *
	 * @return
	 */
	public static String getSeconds() {
		return formatDate(new Date(), "yyyyMMddhhmmssSSS").substring(8);
	}
    /**
	 * 获取YYYYMMDD格式
	 *
	 * @return
	 */
	public static String getDay() {
		return formatDate(new Date(), "yyyyMMdd");
	}
    /**
	 * 获取YYYY-MM-DD格式
	 *
	 * @return
	 */
	public static String getDay(Date date) {
		return formatDate(date, "yyyy-MM-dd");
	}
	/**
	 * 获取YYYY/MM/DD格式
	 *
	 * @return
	 */
	public static String getNewDay(Date date) {
		return formatDate(date, "yyyy/MM/dd");
	}
	public static String formatDate(Date date, String pattern) {
		String formatDate = null;
		if (StringUtils.isNotBlank(pattern)) {
			formatDate = DateFormatUtils.format(date, pattern);
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * 判断时间是否有重叠
	 * @param startTime
	 * @param endTime
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean timeIsOverlap(Date startTime, Date endTime, Date start, Date end) {

		if((startTime.getTime()<=start.getTime()) && endTime.getTime()>=start.getTime()){
			return true;
		}else if((startTime.getTime()>=start.getTime()) && startTime.getTime()<=end.getTime()){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(getDay());
		System.out.println(getSeconds());
	}
}
