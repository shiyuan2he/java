package com.hsy.java.base.execise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @description <p>请在此处输入类的描述</p>
 * @path javase-common/com.javase.execise
 * @time 2017年2月13日 下午10:37:59
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class NumberOffTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		ExecutorService e = Executors.newFixedThreadPool(10);
	    // 第一种是可变大小线程池，按照任务数来分配线程，
	    // 第二种是单线程池，相当于FixedThreadPool(1)
	    // 第三种是固定大小线程池。
	    // 然后运行
		for(int i=0;i<10;i++){
			e.execute(new Thread(new NumberOff()));
		}
	}
}

