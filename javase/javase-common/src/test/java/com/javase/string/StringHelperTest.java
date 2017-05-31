package com.hsy.codebase.utils.javase.string;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @description <p>字符串帮助类的单元测试类</p>
 * @path javase-base/com.hsy.codebase.utils.javase.string
 * @time 2016年7月27日 下午7:43:16
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class StringHelperTest {
	private Logger  _logger = Logger.getLogger(StringHelperTest.class) ;
	@Test
	public void testIsNullOrEmpty() {
		_logger.info("\"\":"+StringHelper.isNullOrEmpty(""));
		_logger.info("\" \":"+StringHelper.isNullOrEmpty(" "));
		_logger.info("null:"+StringHelper.isNullOrEmpty(null));
	}
	
	@Test
	public void testIsNotNullOrEmpty() {
		_logger.info("\"\":"+StringHelper.isNotNullOrEmpty(""));
		_logger.info("\" \":"+StringHelper.isNotNullOrEmpty(" "));
		_logger.info("null:"+StringHelper.isNotNullOrEmpty(null));
	}
	@Test
	public void testSplitToList(){
		StringBuilder sb = new StringBuilder() ;
		sb.append("2,4,3,2") ;
		for (Object element : StringHelper.splitToList(sb.toString(), ",")) {
			System.out.println(element.toString());
//			_logger.info(element.toString());
		}
	}
	@Test
	public void testGetCharCode(){
		String[] str = {"ab","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"} ;
		for(String ss : str){
			System.out.println(StringHelper.getCharCode(ss));
		}
	}
	@Test
	public void testChineseCompareTo(){
		System.out.println(StringHelper.chineseCompareTo("是","否"));
		System.out.println(StringHelper.chineseCompareTo("否","是"));
	}
}

