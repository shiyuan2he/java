package com.hsy.java.java.base.string;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

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
	private static final Logger _logger = LoggerFactory.getLogger(StringHelperTest.class) ;
	@Test
	public void testIsNullOrEmpty() {
		//_logger.info("\"\":"+StringHelper.isNullOrEmpty(""));
		//_logger.info("\" \":"+StringHelper.isNullOrEmpty(" "));
		//_logger.info("null:"+StringHelper.isNullOrEmpty(null));
	}
	
	@Test
	public void testIsNotNullOrEmpty() {
		//_logger.info("\"\":"+StringHelper.isNotNullOrEmpty(""));
		//_logger.info("\" \":"+StringHelper.isNotNullOrEmpty(" "));
		//_logger.info("null:"+StringHelper.isNotNullOrEmpty(null));
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
	@Test
	public void testReplacementWithBrace(){
		_logger.info(StringHelper.replacementWithBrace("快速转出单笔最高可转出{}",500000));
        _logger.info("----------------------------------------");
		_logger.info(StringHelper.replacementWithBrace("手机号{}可转出{}",111111,50000)) ;
        _logger.info("----------------------------------------");
		_logger.info(StringHelper.replacementWithBrace("手机号{}可转出{}傻傻的发呆",111111,23434)) ;
        _logger.info("----------------------------------------");
		_logger.info(StringHelper.replacementWithBrace("{}可转出{}傻傻的发呆",3434,3423)) ;
        _logger.info("----------------------------------------");
		_logger.info(StringHelper.replacementWithBrace("{}可转出{}傻傻的发呆{}","sf","sdf",34342)) ;
	}
    @Test
    public void testString(){
        String ss = "{\"hmac\":\"hmac\",\"status\":\"0\",\"code\":\"CS0000\",\"msg\":\"success\",\"data\":{\"totalPage\":1,\"pageSize\":3,\"list\":[{\"fundCode\":\"000007\",\"incomeIndex\":\"?????\",\"fundName\":\"??1\",\"incomeData\":\"1.25%\"},{\"fundCode\":\"000011\",\"incomeIndex\":\"?????\",\"fundName\":\"??2\",\"incomeData\":\"8.25%\"},{\"fundCode\":\"000004\",\"incomeIndex\":\"?????\",\"fundName\":\"?????????C\",\"incomeData\":\"-18.86%\"}],\"totalCount\":3,\"pageNum\":1}}";
        try {
            String str = new String(ss.getBytes("ISO-8859-1"),"utf-8");
            _logger.info(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

