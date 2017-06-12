package com.javase.array;
/**
 * 
 * @description 
 *     <p>将阿拉伯数字转换成中文RMB表示方式</p>
 * @time 2016年4月10日 下午10:31:07
 * @author shiyuan2he shiyuan4work@sina.com
 */
public class Num2RMB {
	/**
	 * 
	 * @author shiyuan2he shiyuan4work@sina.com
	 * @github https://github.com/shiyuan2he
	 * @see javase-base com.hsy.codebase.utils.javase.array Num2RMB.java
	 * @description 
	 *     <p>把一个浮点数分解成整数部分和浮点部分</p>
	 * @time 2016年4月10日 下午10:58:49
	 * @return_type String[]
	 * @param
	 */
	private String[] divide(double num){
		long zheng = (long) num ;
		long xiao = Math.round((num - zheng) * 100);
		return new String[]{String.valueOf(zheng),String.valueOf(xiao)} ;
	}
	public static void main(String[] args) {
		new Num2RMB().divide(19.8);
	}
}
