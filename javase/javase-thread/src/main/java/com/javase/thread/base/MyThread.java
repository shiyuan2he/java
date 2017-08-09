package com.javase.thread.base;
/**
 * @description <p>继承Thread的线程</p>
 * @path javase-thread/com.javase.thread
 * @time 2017年3月4日 下午11:12:50
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class MyThread extends Thread{
	/**
	 * @description <p></p>
	 */
	@Override
	public void run() {
		for (int i=0;i<50;i++) {
			System.out.println("Thread线程："+ Thread.currentThread().getName()+ "~" +i);
		}
	}
}