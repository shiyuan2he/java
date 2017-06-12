package com.javase.logger;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * @author 何世远
 * @Description 日志工具类
 * @date 2015年10月27日 下午8:43:38
 */
public class LoggerEx {

	static{
		PropertyConfigurator.configure("log4j.properties");
	}
	/**
	 * 日志类储存器
	 */
	private static final Map<String, LoggerEx> cache = new HashMap<String, LoggerEx>();
	/**
	 * 日志类
	 */
	private Logger _log;
	
	/**
	 * 
	 * @author 何世远	shiyuan4work@sina.com
	 * 
	 * @Description 根据传入类名初始化日志类
	 * @date 2015年10月27日 下午8:44:17
	 */
	public LoggerEx(String name){
		_log = Logger.getLogger(name);
	}
	/**
	 * 
	 * @author 何世远	shiyuan4work@sina.com
	 * @Description 根据传入的类初始化日志类
	 * @date 2015年10月27日 下午8:47:47
	 */
	public LoggerEx(@SuppressWarnings("rawtypes") Class clazz){
		_log = Logger.getLogger(clazz);
	}
	/**
	 * 
	 * @author 何世远	shiyuan4work@sina.com
	 * @Description 日志工具类添加同步并且是单例的
	 * @date 2015年10月27日 下午8:48:16
	 */
	synchronized public static LoggerEx getInstance(String name) {
    	LoggerEx instance = null;
        if(null == cache.get(name)){
        	instance = new LoggerEx(name);
        	cache.put(name, instance);
        }
        return cache.get(name);
    }
	
	public void debug(Object message){
		_log.debug(message);
	}
	public void info(Object message){
		_log.info(message);
	}
	public void warn(Object message){
		_log.warn(message);
	}
	public void error(Object message){
		_log.error(message);
	}
}
