package com.javase.execise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description <p>
 * 				一群人围成一圈报数，报三的人退出，剩下的人继续报数，问最后剩下的人是谁？
 * 				</p>
 * @path javase-common/com.javase.execise
 * @time 2017年2月12日 下午11:31:44
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class NumberOff implements Runnable {
	static int mark = 0 ;
	/**
	 * 
	 * @description 
	 *		<p></p>
	 * @time 2017年2月12日 下午11:38:12
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType void
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	public static void numberOff(String[] strArray){
		List<String> strList = new ArrayList<>(Arrays.asList(strArray)) ;
		for(int i=0;i<strArray.length;i++){
			if(null != strArray[i]){
				mark ++ ;
				if(mark == 3){
					strList.set(i, null) ;
				}
			}
		}
		int size = (int) strList.stream().filter(element -> element != null).count() ;
		if(size < 3){
			System.out.println(strList
								.stream()
								.filter(element -> element != null)
								.collect(Collectors.toList())
								.toString());
		}else{
			String[] tempStrArray = new String[strList.size()] ;
			tempStrArray = strList.toArray(tempStrArray) ;
			numberOff(tempStrArray) ;
		}
	}
	@Override
	public void run() {
		String[] strArray = {"王一","王二","王三","王四","王五","王六","王七","王八","王九","王十"} ;
		List<String> strList = new ArrayList<>(Arrays.asList(strArray)) ;
		for(int i=0;i<strArray.length;i++){
			if(null != strArray[i]){
				mark ++ ;
				if(mark == 3){
					strList.set(i, null) ;
				}
			}
		}
		int size = (int) strList.stream().filter(element -> element != null).count() ;
		if(size < 3){
			System.out.println(strList
								.stream()
								.filter(element -> element != null)
								.collect(Collectors.toList())
								.toString());
		}else{
			String[] tempStrArray = new String[strList.size()] ;
			tempStrArray = strList.toArray(tempStrArray) ;
			numberOff(tempStrArray) ;
		}
	}
	public static void main(String[] args) {
		String[] strArray = {"王一","王二","王三","王四","王五","王六","王七","王八","王九","王十"} ;
		numberOff(strArray) ;
	}
}

