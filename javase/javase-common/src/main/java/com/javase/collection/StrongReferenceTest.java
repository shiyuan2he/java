package com.javase.collection;

import java.lang.ref.*;

/**
 * 
 * @description <p>
 *              请输入属性描述
 *              </p>
 * @time 2016年3月17日 下午10:46:19
 * @author shiyuan2he shiyuan4work@sina.com
 */
public class StrongReferenceTest {
	public static void main(String[] args) throws Exception {
		Person[] people = new Person[100000];
		for (int i = 0; i < people.length; i++) {
			people[i] = new Person("名字" + i, (i + 1) * 4 % 100);
		}
		System.out.println(people[2]);
		System.out.println(people[4]);
		// 通知系统进行垃圾回收
		System.gc();
		System.runFinalization();
		// StrongReference数组里不受任何影响
		System.out.println(people[2]);
		System.out.println(people[4]);
	}
}
