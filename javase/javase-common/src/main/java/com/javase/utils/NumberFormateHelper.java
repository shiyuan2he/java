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
	/**
	 * @notSureOfHsy <p>不确定的点</p>
	 * @description
	 *		<p>将数据转化成万</p>
	 * @param money
	 * @return
	 * @time 2017年3月29日 下午3:49:52
	 * @github
	 * 		http://github.com/shiyuan2he
	 * @author heshiyuan
	 * @email heshiyuan@chtwm.com
	 * @returnType Integer
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static String parseMoneyToWan(Integer money){
		if(null == money) return "无限额" ;
		if(money <= 0) return "0万";
		StringBuilder formateStr = new StringBuilder() ;
		if(money / 10000 > 0){
			if(money % 10000 == 0){
				return formateStr.append(money / 10000).toString()+ "万";
			}else{
				return cutO(Double.parseDouble(formateStr.append(money / 10000).toString()) + Double.parseDouble(parseMoneyToWan(money % 10000).replaceAll("万","")) + "")+ "万";
			}
		}else if(money / 1000 > 0){
			formateStr.append("0.").append(money) ;
		}else if(money / 100 > 0){
			formateStr.append("0.0").append(money) ;
		}else if(money / 10 > 0){
			formateStr.append("0.00").append(money) ;
		}else{
			formateStr.append("0.000").append(money) ;
		}
		return cutO(formateStr.toString()) + "万";
	}
	/**
	 *
	 * @description
	 *		<p>去掉字符串末尾的0</p>
	 * @param money
	 * @return
	 * @time 2017年3月29日 下午8:07:50
	 * @github
	 * 		http://github.com/shiyuan2he
	 * @author heshiyuan
	 * @email heshiyuan@chtwm.com
	 * @returnType String
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static String cutO(String money){
		boolean isLast = true ;
		StringBuilder sb = new StringBuilder();
		String[] code = money.split("\\.") ;
		for(int i=code[1].length()-1;i>=0;i--){
			if(isLast&&'0' == code[1].charAt(i)){
				continue ;
			}else{
				sb.append(code[1].charAt(i));
				isLast = false ; //最后以为不是0，
			}
		}
		return code[0] + "." + sb.reverse().toString() ;
	}
	public static void main(String[] args){
		System.out.println(parseMoneyToWan(1499999));  //149.9999万
		System.out.println(parseMoneyToWan(1500000));  //150万
		System.out.println(parseMoneyToWan(111115));
		System.out.println(parseMoneyToWan(11115));
		System.out.println(parseMoneyToWan(1115));
		System.out.println(parseMoneyToWan(115));
		System.out.println(parseMoneyToWan(15));
		System.out.println(parseMoneyToWan(5));
	}
}

