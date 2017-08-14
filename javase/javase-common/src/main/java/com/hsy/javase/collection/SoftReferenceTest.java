package com.hsy.javase.collection;

import java.lang.ref.*;

/**
 * 
 * @description <p>
 *              请输入属性描述
 *              </p>
 * @time 2016年3月17日 下午10:44:03
 * @author shiyuan2he shiyuan4work@sina.com
 */
class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "Person[name=" + name + ", age=" + age + "]";
	}
}

public class SoftReferenceTest {
	public static void main(String[] args) throws Exception {
		SoftReference<Person>[] people = new SoftReference[100000];
		for (int i = 0; i < people.length; i++) {
			people[i] = new SoftReference<Person>(new Person("名字" + i, (i + 1) * 4 % 100));
		}
		System.out.println(people[2].get());
		System.out.println(people[4].get());
		// 通知系统进行垃圾回收
		System.gc();
		System.runFinalization();
		// 垃圾回收机制运行之后，SoftReference数组里的元素保持不变
		System.out.println(people[2].get());
		System.out.println(people[4].get());
	}
}
