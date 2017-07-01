/**
 * @path paac-core/com.codelibrary.javaee.utils/DateHelper.java	
 * @time May 2, 2016 10:25:31 AM
 * @githob 
 *     http://githob.com/shiyuan2he
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
package com.javase.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	/**
	 * @description <p>将时间转化成指定格式的字符串时间</p>
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
}

