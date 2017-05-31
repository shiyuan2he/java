package com.hsy.codebase.utils.javase.collection;

import java.lang.ref.*;

/**
 * 
 * @description <p>
 *              请输入属性描述
 *              </p>
 * @time 2016年3月17日 下午10:52:21
 * @author shiyuan2he shiyuan4work@sina.com
 */
public class WeakReferenceTest {
	public static void main(String[] args) throws Exception {
		// 创建一个字符串对象
		String str = new String("疯狂Java讲义");
		// 创建一个弱引用，让此弱引用引用到"疯狂Java讲义"字符串
		WeakReference<String> wr = new WeakReference<String>(str); // ①
		// 切断str引用和"疯狂Java讲义"字符串之间的引用
		str = null; // ②
		// 取出弱引用所引用的对象
		System.out.println(wr.get()); // ③
		// 强制垃圾回收
		System.gc();
		System.runFinalization();
		// 再次取出弱引用所引用的对象
		System.out.println(wr.get()); // ④
	}
}
