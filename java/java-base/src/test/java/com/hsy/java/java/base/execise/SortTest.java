package com.hsy.java.java.base.execise;

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
	 *		<p>常规冒泡排序－－升序</p>
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
		int[] a={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  
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
	    for(int i=0;i<a.length;i++){
	    	System.out.print(a[i] + " ");
	    }
	}
	/**
	 * 
	 * @description 
	 *		<p>冒泡排序并且输出每一次排序的结果－－升序</p>
	 * @time 2017年2月25日 上午9:21:30
	 * @github 
	 * 		http://github.com/shiyuan2he
	 * @author shiyuan2he
	 * @email shiyuan4work@sina.com
	 * @returnType void
	 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
	 */
	@Test
	public void testBubbleSort2() {
		int score[] = { 67, 69, 75, 87, 89, 90, 99, 100 };
		for (int i = 0; i < score.length - 1; i++) { // 最多做n-1趟排序
			for (int j = 0; j < score.length - i - 1; j++) { // 对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
				if (score[j] > score[j + 1]) { // 把小的值交换到后面
					int temp = score[j];
					score[j] = score[j + 1];
					score[j + 1] = temp;
				}
			}
			System.out.print("第" + (i + 1) + "次排序结果：");
			for (int a = 0; a < score.length; a++) {
				System.out.print(score[a] + " ");
			}
		}
		System.out.print(" 最终排序结果：");
		for (int a = 0; a < score.length; a++) {
			System.out.print(score[a] + " ");
		}
	}
}

