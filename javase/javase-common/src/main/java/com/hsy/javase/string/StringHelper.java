package com.hsy.javase.string;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description <p>字符串帮助类，基于java8-92版本和commons-lang3 jar包</p>
 * @path paac-base/com.hsy.codebase.utils.javase.string.StringHelp.java	
 * @time 2016年6月1日 下午9:45:37
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class StringHelper extends StringUtils{
	//private static Logger _logger = Logger.getLogger(StringHelper.class) ;
	/**
	 * 
	 * @description 
	 *		<p>判断连个字符串是否相等</p>
	 * @time 2016年7月27日 下午8:20:08
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType boolean
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static boolean equals(String str1,String str2){
		return StringUtils.equals(str1, str2) ;
	}
	/**
	 * 
	 * @description 
	 *		<p>判断字符串是否是空，null或""</p>
	 *		<pre>
     * 			StringUtils.isNotEmpty(null)      = false
     * 			StringUtils.isNotEmpty("")        = false
     * 			StringUtils.isNotEmpty(" ")       = true
     * 			StringUtils.isNotEmpty("bob")     = true
     * 			StringUtils.isNotEmpty("  bob  ") = true
     * 		</pre>
	 * @time 2016年5月29日 下午8:45:50
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType boolean 
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static boolean isNullOrEmpty(String str){
		return null == str || "null".equalsIgnoreCase(str) || "".equals(str) || StringUtils.isEmpty(str) ;
	}
	/**
	 * 
	 * 
	 * @description 
	 *		<p>判断字符串非空</p>
	 * @time 2016年7月3日 下午5:14:20
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType boolean
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static boolean isNotNullOrEmpty(String str){
		return !isNullOrEmpty(str) ;
	}
	/**
	 * 
	 * @description 
	 *		<p></p>
	 * @time 2016年7月27日 下午8:34:47
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType boolean
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static boolean match(String regex, Object obj) {
		if (obj == null)
			return false;
		String str = "";
		if (obj instanceof String || obj instanceof Integer || obj instanceof Double || obj instanceof Float
				|| obj instanceof Long) {
			str = obj.toString();
		} else if (obj instanceof Date) {
//			str = DateUtil.Date2Str((Date) obj);
		}
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	/**
	 * @description <p>去除指定字符串里的空格</p>
	 * @param str
	 * @returnType void
	 * 方法名:cutSpace
	 * 类名:StringHelper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年8月17日 上午11:20:23
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static String cutSpace(String str){
		if(isNullOrEmpty(str)){
			//_logger.error("this str is null!");
			return "" ;
		}
		return str.trim() ;
	}
	/**
	 * @description <p>将指定字符串按照指定标识符分割成list集合</p>
	 * @param srcString
	 * @param separator
	 * @return
	 * @returnType List<T>
	 * 方法名:splitToList
	 * 类名:StringHelper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年8月17日 上午11:32:02
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> splitToList(String srcString, String separator) {
		if (srcString == null) {
			return null;
		}
		if(srcString.contains(separator)){
			String[] data = srcString.split(separator);
			if (data == null || data.length == org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO) {
				return null;
			}
			return (List<T>) Arrays.asList(data);
		}else{
			return null ;
		}
	}
	
	private static String _FromEncode_ = "GBK";
	private static String _ToEncode_ = "GBK";
	/**
	 * 
	 * @description <p>将中文字符转化成相同的编码比较大小</p>
	 * @param str1
	 * @param str2
	 * @return
	 * @returnType int
	 * 方法名:compare
	 * 类名:StringHelper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月28日 下午3:04:20
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static int compare(String str1, String str2) {
		int result = 0;
		String m_s1 = null;
		String m_s2 = null;
		try {
			m_s1 = new String(str1.getBytes(_FromEncode_), _ToEncode_);
			m_s2 = new String(str2.getBytes(_FromEncode_), _ToEncode_);
		} catch (Exception e) {
			return str1.compareTo(str2);
		}
		result = chineseCompareTo(m_s1, m_s2);
		return result;
	}
	/**
	 * @description <p>比较中文字符是否相等</p>
	 * @param s1
	 * @param s2
	 * @return
	 * @returnType int
	 * 方法名:chineseCompareTo
	 * 类名:StringHelper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年8月17日 下午1:48:32
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static int chineseCompareTo(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		int n = Math.min(len1, len2);
		for (int i = 0; i < n; i++) {
			int s1_code = getCharCode(s1.charAt(i) + "");
			int s2_code = getCharCode(s2.charAt(i) + "");
			if (s1_code * s2_code < 0)
				return Math.min(s1_code, s2_code);
			if (s1_code != s2_code)
				return s1_code - s2_code;
		}
		return len1 - len2;
	}
	/**
	 * @description <p>获取字符串的hashCode值</p>
	 * @param s
	 * @return
	 * @returnType int
	 * 方法名:getCharCode
	 * 类名:StringHelper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年8月17日 上午11:55:44
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static int getCharCode(String s) {
		if (s == null || s.equals(""))
			return -1;
		byte b[] = s.getBytes();
		int value = 0;
		for (int i = 0; i < b.length && i <= 2; i++) {
			value = value * 100 + b[i];
		}
		return value;
	}
	/**
	 * 
	 * @description <p>获取文字首字母</p>
	 * @param res
	 * @return
	 * @returnType String
	 * 方法名:getBeginCharacter
	 * 类名:StringHelper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月28日 下午3:05:13
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static String getBeginCharacter(String res) {
		String a = res;
		String result = "";
		for (int i = 0; i < a.length(); i++) {
			String current = a.substring(i, i + 1);
			if (compare(current, "\u554A ") < 0)
				result = result + current;
			else if (compare(current, "\u554A ") >= 0
					&& compare(current, "\u5EA7 ") <= 0)
				if (compare(current, "\u531D ") >= 0)
					result = result + "z";
				else if (compare(current, "\u538B ") >= 0)
					result = result + "y";
				else if (compare(current, "\u6614 ") >= 0)
					result = result + "x";
				else if (compare(current, "\u6316 ") >= 0)
					result = result + "w";
				else if (compare(current, "\u584C ") >= 0)
					result = result + "t";
				else if (compare(current, "\u6492 ") >= 0)
					result = result + "s";
				else if (compare(current, "\u7136 ") >= 0)
					result = result + "r";
				else if (compare(current, "\u671F ") >= 0)
					result = result + "q";
				else if (compare(current, "\u556A ") >= 0)
					result = result + "p";
				else if (compare(current, "\u54E6 ") >= 0)
					result = result + "o";
				else if (compare(current, "\u62FF ") >= 0)
					result = result + "n";
				else if (compare(current, "\u5988 ") >= 0)
					result = result + "m";
				else if (compare(current, "\u5783 ") >= 0)
					result = result + "l";
				else if (compare(current, "\u5580 ") >= 0)
					result = result + "k";
				else if (compare(current, "\u51FB ") > 0)
					result = result + "j";
				else if (compare(current, "\u54C8 ") >= 0)
					result = result + "h";
				else if (compare(current, "\u5676 ") >= 0)
					result = result + "g";
				else if (compare(current, "\u53D1 ") >= 0)
					result = result + "f";
				else if (compare(current, "\u86FE ") >= 0)
					result = result + "e";
				else if (compare(current, "\u642D ") >= 0)
					result = result + "d";
				else if (compare(current, "\u64E6 ") >= 0)
					result = result + "c";
				else if (compare(current, "\u82AD ") >= 0)
					result = result + "b";
				else if (compare(current, "\u554A ") >= 0)
					result = result + "a";
		}
		return result;
	}
	/**
	 * 
	 * @description <p>将中文字符串转化为首字母组合 如果字符串中有字母直接输出字母 如果字符串中有数字输出数字</p>
	 * @param str
	 * @return
	 * @returnType String
	 * 方法名:getFirstStr
	 * 类名:StringHelper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月28日 下午3:06:37
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static String getFirstStr(String str) {
		String result = "";
		char a = ' ';
		for (int i = 0; i < str.length(); i++) {
			a = str.charAt(i);
			char aa[] = { a };
			String sss = new String(aa);
			if (Character.isDigit(aa[0]))
				sss = a + "";
			else if (a >= 'a' && a <= 'z' || a >= 'A' && a <= 'Z')
				sss = a + "";
			else
				sss = getBeginCharacter(sss);
			result = result + sss;
		}
		return result;
	}
}

