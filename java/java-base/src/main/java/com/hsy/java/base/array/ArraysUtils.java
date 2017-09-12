package com.hsy.java.base.array;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

/**
 * 
 * @description 
 *     <p>Arrays增强型工具类</p>
 * @time 2016年4月9日 上午12:25:24
 */
public class ArraysUtils {
	/**
	 * 
	 * @author shiyuan2he shiyuan4work@sina.com
	 * @github https://github.com/shiyuan2he
	 * @description
	 *     <p>Arrays老方法</p>
	 * @time 2016年4月10日 下午9:49:55
	 * @return_type void
	 * @param
	 */
	private void arrayOld(){
		int[] score = {30,90,100,40,60,50,70,10,20,80} ;
		/*Arrays.sort(score); //	[10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
		Arrays.binarySearch(score, 20) ; // 1
		Arrays.binarySearch(score, 3,7,20) ; // -4*/		
		Arrays.sort(score,2,9); //
		Arrays.fill(score, 66); //	[66, 66, 66, 66, 66, 66, 66, 66, 66, 66]
		Arrays.fill(score, 2,9,55); //	[66, 66, 55, 55, 55, 55, 55, 55, 55, 66]
		Arrays.toString(score) ; // 	[66, 66, 55, 55, 55, 55, 55, 55, 55, 66]
		Arrays.equals(score, Arrays.copyOf(score, score.length)) ; //true
		Arrays.copyOfRange(score, score.length -5, score.length -2) ; // [55, 55, 55]
	}
	/**
	 * 
	 * @author shiyuan2he shiyuan4work@sina.com
	 * @github https://github.com/shiyuan2he
	 * @description
	 *     <p>Java8对Array新增的并行处理</p>
	 * @time 2016年4月10日 下午9:54:28
	 * @return_type void
	 * @param
	 */
	private void arrayParallel(){
		int[] score = new int[]{30,90,100,40,60,50,70,10,20,80} ;
		Arrays.parallelSort(score);
		System.out.println(score.toString());
		int[] score2 = new int[]{30,90,100,40,60,50,70,10,20,80} ;
		Arrays.parallelPrefix(score2, new IntBinaryOperator() {
			/**
			 * left表市数组中前一个索引出的元素，当前索引为1时，left=1
			 * right表市当前索引处的元素
			 */
			public int applyAsInt(int left, int right) {
				return left + right;
			}
		});
		Arrays.parallelSetAll(score2, new IntUnaryOperator() {
			/**
			 * operand 表示正在计算的元素索引
			 */
			public int applyAsInt(int operand) {
				return operand + 6;
			}
		});
		System.out.println(score2.toString());
	}
	/**
	 * 
	 * @author shiyuan2he shiyuan4work@sina.com
	 * @github https://github.com/shiyuan2he
	 * @description
	 *     <p>测试Arrays工具类</p>
	 * @time 2016年4月9日 上午12:35:20
	 * @return_type void
	 * @param
	 */
	public static void main(String[] args) {
		new ArraysUtils().arrayParallel();
	}
}
