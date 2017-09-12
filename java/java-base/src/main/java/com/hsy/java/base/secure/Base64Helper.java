package com.hsy.java.base.secure;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * @description 
 *		<p>Base64加密工具类</p>
 * @date 2016年10月10日 下午4:19:43
 * @github 
 * 		http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class Base64Helper {
	private final static String CHARSET = "utf-8" ;

	/**
	 * 
	 * @description <p>base64加密/p>
	 * @param str
	 * @return
	 * @returnType String
	 * 方法名:stringToBase64
	 * 类名:Base64Helper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月10日 下午4:26:53
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static String stringToBase64(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes(CHARSET);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}

	/**
	 * 
	 * @description <p>base64解密</p>
	 * @param s
	 * @return
	 * @returnType String
	 * 方法名:base64ToString
	 * 类名:Base64Helper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月10日 下午4:26:58
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static String base64ToString(String s) {
		byte[] b = null;
		String result = null;
		if (s != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(s);
				result = new String(b, CHARSET);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	} 
}
