package com.hsy.javase.collection;

import java.lang.ref.*;

/**
 * 
 * @description <p>
 *              请输入属性描述
 *              </p>
 * @time 2016年3月17日 下午11:02:35
 * @author shiyuan2he shiyuan4work@sina.com
 */
public class PhantomReferenceTest {
	public static void main(String[] args) throws Exception {
		// 创建一个字符串对象
		String str = new String("疯狂Java讲义");
		// 创建一个引用队列
		ReferenceQueue<String> rq = new ReferenceQueue<String>();
		// 创建一个虚引用，让此虚引用引用到"疯狂Java讲义"字符串
		PhantomReference<String> pr = new PhantomReference<String>(str, rq);
		// 切断str引用和"Struts2权威指南"字符串之间的引用
		str = null;
		// 试图取出虚引用所引用的对象，
		// 程序并不能通过虚引用访问被引用的对象，所以此处输出null
		System.out.println(pr.get()); // ①
		// 强制垃圾回收
		System.gc();
		System.runFinalization();
		// 取出引用队列中最先进入队列中引用与pr进行比较
		System.out.println(rq.poll() == pr); // ②
	}
}
