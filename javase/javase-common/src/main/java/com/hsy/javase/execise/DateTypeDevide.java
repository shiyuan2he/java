package com.hsy.javase.execise;

import java.util.Scanner;

/**
 * @description <p>给出一个数能够判断出这个数的适用数据类型</p>
 * @author heshiyuan @date 2017年3月11日 下午1:32:43
 * @path: javase-common/com.javase.execise/DateTypeDevide.java
 * @price ￥：5元
 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
 * @email heshiyuan@chtwm.com
 * @callnumber 15910868535
 */
public class DateTypeDevide {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        String next = null ;
        for(int i=0;i<t;i++){
            try{
            	next = sc.next() ;
            	long value = Long.parseLong(next) ;
                System.out.println(value+" can be fitted in:");
            	if(value>=-Math.pow(2,7) && value<= (Math.pow(2,7)-1)){
            		System.out.println("* byte");
            	}
            	if(value>=-Math.pow(2,15) && value<= (Math.pow(2,15)-1)){
            		System.out.println("* short");
            	}
            	if(value>=-Math.pow(2,31) && value<= (Math.pow(2,31)-1)){
            		System.out.println("* int");
            	}
            	if(value>=-Math.pow(2,63) && value<= (Math.pow(2,63)-1)){
            		System.out.println("* long");
            	}
            }catch(Exception e){
                System.out.println(next+" can't be fitted anywhere.");
            }
        }
        sc.close();
        /**
         * 测试数据
            22
            
         	0
			1
			-1
			18446744073709551616
			-18446744073709551616
			18446744073709551615
			-18446744073709551616
			32768
			-32768
			32767
			-32767
			2147483648
			2147483647
			-2147483648
			-2147483647
			128
			127
			-128
			-127
			123123123333333333333333333333333313123123
			234444444444444444444444444444444444444
			-1222222
         */
	}
}

