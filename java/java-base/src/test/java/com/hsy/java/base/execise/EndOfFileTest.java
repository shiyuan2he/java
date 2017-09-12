package com.hsy.java.base.execise;

import java.util.Scanner;

import org.junit.Test;

/**
 * @description <p>类文件描述</p>
 * @author heshiyuan @date 2017年3月11日 下午2:06:40
 * @path: javase-common/com.javase.execise/EndOfFileTest.java
 * @price ￥：5元
 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
 * @email heshiyuan@chtwm.com
 * @callnumber 15910868535
 */
public class EndOfFileTest {
	 public static int B = 0 ;
	    public static int H = 0 ;
	    public static boolean flag = false ;
	    
	    static{
	        Scanner scanner = new Scanner(System.in) ;
	        B = scanner.nextInt() ;
	        H = scanner.nextInt() ;
	        if(-100<=B && B <= 100 && -100<=H && H <= 100){
	            if(B >0 && H>0){
	                flag = true ;
	            }else{
	                System.out.println(new Exception("Breadth and height must be positive").getMessage()) ;
	            }
	        }
	        scanner.close();
	    }
	@Test
	public void test() {
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
	}

}

