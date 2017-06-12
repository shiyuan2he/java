/**
 * @author 何世远	shiyuan4work@sina.com
 * @Description 文件注释
 * @date 2015年11月14日 下午8:32:44
 * @version 1.0 create at 2015年11月14日 下午8:32:44 by 何世远
 */
package com.javase.clazz;

import com.hsy.codebase.utils.javase.logger.LoggerEx;


interface A{}
interface B{}
interface C{}
class AA {AA(){}	AA(int s){}}
class BB extends AA implements A,B,C{}
/**
 * @author 何世远	shiyuan4work@sina.com
 * @Description 请输入类描述信息
 * @date 2015年11月14日 下午8:32:44
 */
public class ClazzTools {
	private static LoggerEx logger = LoggerEx.getInstance(ClazzTools.class.getName()) ;
	/**
	 * @author 何世远	shiyuan4work@sina.com
	 * @Description 请输入此方法描述信息
	 * @date 2015年11月14日 下午8:32:44
	 */
	public static void main(String[] args) {
		Class<?> clazz = null ;
		try {
			clazz = Class.forName("hsy.utils.clazz.BB") ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (Class<?> c : clazz.getInterfaces()) {
			logger.info(c);
			Class<?> superClass = c.getSuperclass() ;
			Object object = null ;
			try {
				object = superClass.newInstance() ;
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			logger.info(object.getClass());
		}
	}
}




