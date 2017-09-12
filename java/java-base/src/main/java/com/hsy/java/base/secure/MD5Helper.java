package com.hsy.java.base.secure;

import java.security.MessageDigest;

/**
 * 
 * @description 
 *		<p>MD5加密工具类</p>
 * @date 2016年10月10日 下午4:19:43
 * @github 
 * 		http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class MD5Helper{
	static String subMark="paac.wt";	
	// 十六进制下数字到字符的映射数组
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5","6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
	/**
	 * 
	 * @description <p>将传入的字符串按照特定的标识加密</p>
	 * @param inputString
	 * @return
	 * @returnType String
	 * 方法名:stringToMD5ByIdentified
	 * 类名:MD5Helper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月31日 下午4:42:00
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static String stringToMD5ByIdentified(String inputString) {
		return stringToMD5(inputString+subMark);
	}
	/**
	 * 
	 * @description <p>校验原生的MD5加密字符串是否相等</p>
	 * @param originString
	 * @param inputString
	 * @return
	 * @returnType boolean
	 * 方法名:validateMD5
	 * 类名:MD5Helper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月31日 下午4:42:48
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static boolean validateMD5(String originString, String inputString) {
		return  originString.equals(stringToMD5(inputString));
	}
	/**
	 * 
	 * @description <p>按照特定标识加密的字符串比较是否相等</p>
	 * @param originString
	 * @param inputString
	 * @return
	 * @returnType boolean
	 * 方法名:validateMD5ByIdentified
	 * 类名:MD5Helper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月31日 下午4:43:36
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static boolean validateMD5ByIdentified(String originString, String inputString) {
		return  originString.equals(stringToMD5(inputString+subMark));
	}
	/**
	 * @description <p>将传入的 字符串md5进行加密</p>
	 * @param originString
	 * @return
	 * @returnType String
	 * 方法名:encodeByMD5
	 * 类名:MD5Helper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月31日 下午4:30:12
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static String stringToMD5(String originString) {
		if (originString != null) {
			try {
				// 创建具有指定算法名称的信息摘要
				MessageDigest md = MessageDigest.getInstance("MD5");
				// 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
				byte[] results = md.digest(originString.getBytes());
				// 将得到的字节数组变成字符串返回
				String resultString = byteArrayToHexString(results);
				return resultString.toUpperCase();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * @description <p>转换字节数组为十六进制字符串</p>
	 * @param b
	 * @return
	 * @returnType String
	 * 方法名:byteArrayToHexString
	 * 类名:MD5Helper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月31日 下午4:36:00
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}
	/**
	 * @description <p>将一个字节转化成十六进制形式的字符串</p>
	 * @param b
	 * @return
	 * @returnType String
	 * 方法名:byteToHexString
	 * 类名:MD5Helper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月31日 下午4:34:16
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
}
