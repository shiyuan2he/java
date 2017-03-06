package com.javase.thread.gun;

import org.junit.Test;

/**
 * @description <p>请在此处输入类的描述</p>
 * @path javase-thread/com.javase.thread.gun
 * @time 2017年3月5日 下午6:04:19
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class GunTest {

	@Test
	public void test() {
		for(int i=0;i<1000;i++){
			new Thread(new ProducerThread()).start();
			new Thread(new ConsumerThread()).start();
		}
	}
}

