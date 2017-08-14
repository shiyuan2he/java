package com.hsy.javase.util.bean;

import com.hsy.javase.bean.BeanHelper;
import com.hsy.javase.logger.SystemLogger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BeanHelperTest {
	@Test
	public void testEquals(){
		Map<String,String> map01 = new HashMap<String,String>() ;
			map01.put("field1", "1") ;
			map01.put("field2", "2") ;
			map01.put("field3", "3") ;
		Map<String,String> map02 = new HashMap<String,String>() ;
			map01.put("field1", "1") ;
			map01.put("field2", "2") ;
			map01.put("field3", "3") ;
			
		SystemLogger.log(BeanHelper.equals(map01, map02)); // false
		SystemLogger.log(BeanHelper.equals(map01, map01)); // true
		SystemLogger.log(BeanHelper.equals(map02, map02)); // true
		map01 = map02 ;
		SystemLogger.log(BeanHelper.equals(map01, map02)); // true
	}
}
