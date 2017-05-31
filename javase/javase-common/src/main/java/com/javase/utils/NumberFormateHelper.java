package com.javase.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @description <p>数字工具帮助类</p>
 * @author heshiyuan @date 2017年3月9日 下午7:37:42
 * @path: javase-common/com.javase.util/NumberFormateHelper.java
 * @price ￥：5元
 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
 * @email heshiyuan@chtwm.com
 * @callnumber 15910868535
 */
public class NumberFormateHelper {
	private NumberFormateHelper(){}
	
	/**
	 * @description <p>保留两位小数</p>
	 * @param num
	 * @return
	 * @returnType String
	 * @author heshiyuan @date 2017年3月9日 下午7:44:41
	 * @path javase-common/com.javase.util/NumberFormateHelper.java
	 * @date 2017年3月9日 下午7:44:41
	 * ￥：三毛三
	 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
	 * @email heshiyuan@chtwm.com
	 * @callnumber 15910868535
	 */
	public static String getTwoFromNum(String num){
		DecimalFormat formate = new DecimalFormat("0.00") ;
		BigDecimal bd = new BigDecimal(num.replace(",","")) ;
		return formate.format(bd);
	}
	
	public static String getBaiFenShu(){
		return null ;
	}
}

