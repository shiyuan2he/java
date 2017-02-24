package com.javase.execise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @description <p>请在此处输入类的描述</p>
 * @path javase-common/com.javase.execise
 * @time 2017年2月20日 下午10:13:23
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class Recursion {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(getNumbers(30));
	}
	private static int getNumbers(int length){
		if(length <= 2){
			return 1 ;
		}else{
			return getNumbers(length-2)+getNumbers(length-1) ;
		}
	}
	
	public void forTransfer() throws Exception {
		FileInputStream in = new FileInputStream(new File("a.txt")) ;
		FileOutputStream out = new FileOutputStream(new File("b.txt"));
		byte[] buffer = new byte[1024];
		while (true) {
			int ins = in.read(buffer);
			if (ins == -1) {
				in.close();
				out.flush();
				out.close();
			} else
				out.write(buffer, 0, ins);
		}
	}
}

