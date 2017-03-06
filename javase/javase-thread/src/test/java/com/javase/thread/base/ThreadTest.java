package com.javase.thread.base;
import org.junit.Test;

/**
 * @description <p>请在此处输入类的描述</p>
 * @path javase-thread/
 * @time 2017年3月5日 下午4:33:11
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class ThreadTest {

	@Test
	public void test() {
		MyThread myThread = new MyThread() ;
		myThread.start();
		
		Thread runThread = new Thread(new Runner()) ;
		runThread.start();
	}

}

