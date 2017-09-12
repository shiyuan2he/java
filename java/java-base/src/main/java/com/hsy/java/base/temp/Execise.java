package com.hsy.java.base.temp;
/**
 * @description <p>请在此处输入类的描述</p>
 * @path javase-common/
 * @time 2017年2月19日 下午8:03:07
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class Execise {
	private static int getNumbers(int length){
		if(length <= 2){
			return 1 ;
		}else{
			return getNumbers(length-2)+getNumbers(length-1) ;
		}
	}
	public static void main(String[] args) {
		System.out.println(getNumbers(30)); ;
	}
}

