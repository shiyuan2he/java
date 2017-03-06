package com.javase.thread.gun;
/**
 * @description <p>请在此处输入类的描述</p>
 * @path javase-thread/com.javase.thread.gun
 * @time 2017年3月5日 下午6:19:24
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class Gun {
	private String action = null ;
	public Gun(String actionType){
		this.action = actionType ;
	}
	synchronized public void countBullet(){
		switch(action){
			case "shoot" :
				if(Constant.BULLET_COUNT < 10){
					System.out.print(Constant.BULLET_COUNT + "	开始装弹！	");
					Constant.BULLET_COUNT ++ ;
					System.out.println(Constant.BULLET_COUNT );
				}
				break ;
			case "reload" :
				if(Constant.BULLET_COUNT > 0){
					System.out.print(Constant.BULLET_COUNT + "	开始射击！	");
					Constant.BULLET_COUNT -- ;
					System.out.println(Constant.BULLET_COUNT);
				}
				break ;
		}
	}
}

