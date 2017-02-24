package com.javase.execise;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * @description <p>请在此处输入类的描述</p>
 * @path javase-common/com.javase.execise
 * @time 2017年2月25日 上午12:29:22
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class SortTest {
	/**
	 * 
	 * @description 
	 *		<p>冒泡</p>
	 * @time 2017年2月25日 上午12:35:22
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType void
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	@Test
	public void testBubbleSort() {
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  
	    int temp=0;  
	    for(int i=0;i<a.length-1;i++){  
	        for(int j=0;j<a.length-1-i;j++){  
		        if(a[j]>a[j+1]){  
		            temp=a[j];  
		            a[j]=a[j+1];  
		            a[j+1]=temp;  
		        }  
	        }  
	    }  
	    for(int i=0;i<a.length;i++)  
	        System.out.println(a[i]);     
		}
}

