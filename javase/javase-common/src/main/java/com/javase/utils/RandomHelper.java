package com.javase.utils;
/**
 * 
 * @description 
 *		<p>随机数工具类</p>
 * @time 2016年7月6日 下午10:25:40
 * @github 
 * 		http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * @returnType long
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class RandomHelper {
	
	/**
	 * 
	 * @description 
	 *		<p>当前毫秒数</p>
	 * @time 2016年7月6日 下午10:25:40
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType long
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static long curTimeGenerator(){
		return System.currentTimeMillis();
	}
	/**
	 * 
	 * @description 
	 *		<p>生成24位全球唯一标识ID主键-PAAC14776347668456433687</p>
	 * @time 2016年7月6日 下午10:35:19
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType String
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	synchronized public static String IDGenerateValue(final long lastTimestamp){
		final StringBuffer idValue = new StringBuffer() ;
		long timestamp  = curTimeGenerator();
		while (timestamp <= lastTimestamp) {
			 timestamp = curTimeGenerator();
		}
		idValue.append("PAAC").append(timestamp).append(Math.round(Math.random()*10000000)) ;
		return idValue.toString();
	}
	/**
	 * 
	 * @description <p>返回以start开头，以end结尾，中间length个数字的字符串</p>
	 * @param start
	 * @param end
	 * @param length
	 * @return
	 * @returnType String
	 * 方法名:generateValueByParam
	 * 类名:RandomHelper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年11月3日 下午2:20:15
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	synchronized public static String generateValueByParam(String start,String end,int length){
		if(length < 0) return "" ;
		StringBuffer stringCount = new StringBuffer() ;
		stringCount.append("1") ;
		for(int i=0;i<length;i++){
			stringCount.append("0");
		}
		StringBuffer sb = new StringBuffer() ;
		sb.append(start).append(Math.round(Math.random()*Integer.parseInt(stringCount.toString()))).append(end) ;
		return sb.toString() ;
	}
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(IDGenerateValue(System.currentTimeMillis()));
	}
}
