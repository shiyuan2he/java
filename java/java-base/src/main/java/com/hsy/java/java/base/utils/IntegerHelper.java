package com.hsy.java.java.base.utils;
/**
 * @description <p>Integer帮助工具类</p>
 * @author heshiyuan @date 2017年3月9日 下午3:27:33
 * path:javase-common/com.javase.util/IntegerHelper.java
 * ￥：5元
 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
 * @email heshiyuan@chtwm.com
 * @callnumber 15910868535
 */
public class IntegerHelper {
	
	private IntegerHelper(){}
	/**
	 * @description <p>判断字符串是否是Integer类型</p>
	 * @returnType boolean
	 * @param str	待判断的字符串
	 * @return 是否是数字
	 * @author heshiyuan @date 2017年3月9日 下午3:32:43
	 * javase-common/com.javase.util/IntegerHelper.java
	 * 2017年3月9日 下午3:32:43
	 * ￥：三毛三
	 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
	 * @email heshiyuan@chtwm.com
	 * @callnumber 15910868535
	 */
	public static boolean isInteger(String str){
		try{
			Integer.parseInt(String.valueOf(str)) ;
			return true ;
		}catch(NumberFormatException e){
			return false ;
		}	
	}
}

