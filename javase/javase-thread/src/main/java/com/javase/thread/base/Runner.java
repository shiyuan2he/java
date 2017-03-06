package com.javase.thread.base;
/**
 * @description <p>请在此处输入类的描述</p>
 * @path javase-thread/com.javase.thread.base
 * @time 2017年3月5日 下午4:32:22
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class Runner implements Runnable {

	@Override
	public void run() {
		for (int i=0;i<50;i++) {
			System.out.println("Runnable线程："+ Thread.currentThread().getName()+ "~" +i);
		}
	}

}

