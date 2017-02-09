package com.redis.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * @description <p>请在此处输入类的描述</p>
 * @path redis-jedis/com.redis.test
 * @time 2017年2月9日 下午11:04:59
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class RedisTest {
	private Jedis jedis ;
	@Before
	public void setUp(){
		//链接redis服务器
		jedis = new Jedis("192.168.216.129",6379) ;
		jedis.auth("admin") ;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

