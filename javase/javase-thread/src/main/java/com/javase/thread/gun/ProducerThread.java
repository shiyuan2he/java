package com.javase.thread.gun;
/**
 * @description <p>请在此处输入类的描述</p>
 * @path javase-thread/com.javase.thread.gun
 * @time 2017年3月5日 下午5:38:19
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class ProducerThread implements Runnable{

	@Override
	public void run() {
		new Gun("reload").countBullet();//装载子弹
	}
}

