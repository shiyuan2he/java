package com.hsy.javase.logger;

/**
 * @see 系统日志输出
 * @Date 2015.08.12
 * @author 何世远
 *
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
