package org.hsy.java.base.string;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

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
	public void testFormat(){
        String s1 = "10%";
        String s2 = "11.11%";
        BigDecimal decimal1 = new BigDecimal(s1.replaceAll("%", ""));
        BigDecimal decimal2 = new BigDecimal(s2.replaceAll("%", ""));
        System.out.println(decimal1.compareTo(decimal2));
        System.out.println(decimal2.compareTo(decimal1));
        System.out.println(decimal2.compareTo(decimal2));
        Assert.assertEquals(decimal1.compareTo(decimal2), -1);
    }

	@Test
    public void lineToHump(){
        _logger.info("", StringHelper.lineToHump("dict"));
        _logger.info("", StringHelper.lineToHump("t_dict"));
    }
	@Test
	public void toUpperCaseFirstOne(){
	    _logger.info("", StringHelper.toUpperCaseFirstOne("dict"));
	    _logger.info("", StringHelper.toUpperCaseFirstOne("t_dict"));
    }
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
    @Test
    public void testEquals(){
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        String s5 = new String("ab");
        _logger.info("{}",s3 == s4); // false
        _logger.info("{}",s3.equals(s1 + s2)); // true
        _logger.info("{}",s3 == s5);// false
        _logger.info("{}",s3.equals(s5));// true
    }

    @Test
    public void testEquals2(){
        String s1 = "a";
        String s2 = "a";

        String s3 = new String("a");
        String s4 = new String("a");
        _logger.info("{}",s1 == s2);// true
        _logger.info("{}",s1.equals(s2)); //true
        _logger.info("{}",s3 == s4);// false
        _logger.info("{}",s3.equals(s4));//true
        _logger.info("{}",s1 == s4);// false
        _logger.info("{}",s1.equals(s4));// true
        s3 = s3.intern();
        _logger.info("{}",s3 == s4);// false
        _logger.info("{}",s3 == s1);// true
        _logger.info("{}",s3 == s2);// true

        Double d1 = 1.0;
        Double d2 = 1.0;
        System.out.println("d1==d2\t" + (d1 == d2));// false
        System.out.println("d1==d2\t" + (2.0 == d1+d2));// true
    }
    static String s0 = "a";
    @Test
    public void testEquals3(){
        String s3 = new String("a");
        s3 = s3.intern();
        String s1 = "a";
        String s2 = "a";

        _logger.info("{}",s1 == s2);// true
        _logger.info("{}",s1==s3); //true
        _logger.info("{}",s0==s1); //true
        _logger.info("{}",s0==s3); //true
    }
}

