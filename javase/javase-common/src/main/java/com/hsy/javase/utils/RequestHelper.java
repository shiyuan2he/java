package com.hsy.javase.utils;

import java.util.Map;

/**
 * @description <p>request请求相关工具类</p>
 * @author heshiyuan @date 2017年3月9日 下午4:12:11
 * @path: javase-common/com.javase.util/RequestHelper.java
 * @price ￥：5元
 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
 * @email heshiyuan@chtwm.com
 * @callnumber 15910868535
 */
public class RequestHelper {
	private RequestHelper(){}
	/**
	 * 
	 * @description <p>将map当中的key，value打印出来</p>
	 * @param param
	 * @returnType void
	 * @author heshiyuan @date 2017年3月9日 下午4:19:44
	 * @path javase-common/com.javase.util/RequestHelper.java
	 * @date 2017年3月9日 下午4:19:44
	 * ￥：三毛三
	 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
	 * @email heshiyuan@chtwm.com
	 * @callnumber 15910868535
	 */
	public static void printRequestParam(Map<String,Object> param){
		for(Map.Entry<String, Object> entry : param.entrySet()){
			System.out.println(String.format("\"%s\"  :  \"%s\",", entry.getKey(), entry.getValue()));
		}
	}
}

