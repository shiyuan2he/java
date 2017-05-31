/**
 * @author 何世远	shiyuan4work@sina.com
 * @Description 文件注释
 * @date 2015年10月27日 下午8:50:22
 * @version 1.0 create at 2015年10月27日 下午8:50:22 by 何世远
 */
package com.hsy.codebase.utils.javase.array;


import java.util.Arrays;
import java.util.Random;

import com.hsy.codebase.utils.javase.logger.LoggerEx;

/**
 * @author 何世远	shiyuan4work@sina.com
 * @Description 初始化数组
 * @date 2015年10月27日 下午8:50:22
 */
public class ArrayInit {
	private static LoggerEx logger = LoggerEx.getInstance(ArrayInit.class.getName()) ;
	public void init(){
		Integer[] a = {
				new Integer(0),
				new Integer(3),
				7
		} ;
		Integer[] b = new Integer[]{
				new Integer(0),
				new Integer(3),
				7
		} ;
		Random rand = new Random() ;
		int[ ] c = new int[rand.nextInt(3)] ;
		for (int i = 0; i < c.length; i++) {
			c[i] = rand.nextInt(10) ;
		}
		logger.info(Arrays.toString(a));
		logger.info(Arrays.toString(b));
		logger.info(Arrays.toString(c));
	}
}
