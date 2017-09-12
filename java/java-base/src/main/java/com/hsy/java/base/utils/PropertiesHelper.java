package com.hsy.java.base.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @description <p>属性文件帮助工具类</p>
 * @author heshiyuan @date 2017年3月9日 下午3:59:00
 * @path: javase-common/com.javase.util/PropertiesHelper.java
 * @price ￥：5元
 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
 * @email heshiyuan@chtwm.com
 * @callnumber 15910868535
 */
public class PropertiesHelper {
	
	private PropertiesHelper(){}
	@SuppressWarnings("unused")
	private static String propertiesName = "db.properties" ;
	
	public static Map<String,String> parseMap(String fileName){
		return new HashMap<>() ;
	}
}

