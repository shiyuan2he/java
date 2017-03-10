package com.javase.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description <p>日期帮助类</p>
 * @author heshiyuan @date 2017年3月9日 下午6:58:44
 * @path: javase-common/com.javase.util/DateHelper.java
 * @price ￥：5元
 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
 * @email heshiyuan@chtwm.com
 * @callnumber 15910868535
 */
public class DateHelper {
	private DateHelper(){}
	/**
	 * @description <p>将时间转化成指定格式的字符串时间</p>
	 * @param now		需要格式化的时间
	 * @param formate	格式化类型
	 * @return			格式化之后的时间
	 * @returnType String
	 * @author heshiyuan @date 2017年3月9日 下午7:10:53
	 * @path javase-common/com.javase.util/DateHelper.java
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
	 * @path javase-common/com.javase.util/DateHelper.java
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
			return new Date() ;
		}
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
}

