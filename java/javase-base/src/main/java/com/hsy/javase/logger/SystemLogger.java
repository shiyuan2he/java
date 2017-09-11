package com.hsy.javase.logger;
/**
 * @description <p>系统日志输出</p></p>
 * @author heshiyuan
 * @date 16/08/2017 6:41 PM
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class SystemLogger {
	public static void log(Object... msgs){
		StringBuilder sb = new StringBuilder() ;
		for(Object msg : msgs){
			sb.append(msg.toString()) ;
		}
		System.out.println(sb.toString());
	}
}
