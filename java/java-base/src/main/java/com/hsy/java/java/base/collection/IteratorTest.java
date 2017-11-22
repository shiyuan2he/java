package com.hsy.java.java.base.collection;

import java.util.*;

/**
 * 
 * @description <p>
 *              集合迭代器
 *              </p>
 * @time 2016年3月17日 下午8:54:09
 */
enum Gender {
	MALE, FEMALE;
}

public class IteratorTest {
	public static void main(String[] args) {
		// 创建一个HashSet集合
		HashSet<String> hashSet = new HashSet<String>();
		// 获取HashSet集合的Iterator
		System.out.println("HashSet的Iterator:" + hashSet.iterator());
		// 创建一个LinkedHashSet集合
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		// 获取LinkedHashSet集合的Iterator
		System.out.println("LinkedHashSet的Iterator:" + linkedHashSet.iterator());
		// 创建一个TreeSet集合
		TreeSet<String> treeSet = new TreeSet<String>();
		// 获取TreeSet集合的Iterator
		System.out.println("TreeSet的Iterator:" + treeSet.iterator());
		// 创建一个EnumSet集合
		EnumSet<Gender> enumSet = EnumSet.allOf(Gender.class);
		// 获取EnumSet集合的Iterator
		System.out.println("EnumSet的Iterator:" + enumSet.iterator());
		// 创建一个ArrayList集合
		ArrayList<String> arrayList = new ArrayList<String>();
		// 获取ArrayList集合的Iterator
		System.out.println("ArrayList的Iterator:" + arrayList.iterator());
		// 创建一个Vector集合
		Vector<String> vector = new Vector<String>();
		// 获取Vector集合的Iterator
		System.out.println("Vector的Iterator:" + vector.iterator());
		// 创建一个LinkedList集合
		LinkedList<String> linkedList = new LinkedList<String>();
		// 获取LinkedList集合的Iterator
		System.out.println("LinkedList的Iterator:" + linkedList.iterator());
		// 创建一个ArrayDeque集合
		ArrayDeque<String> arrayDeque = new ArrayDeque<String>();
		// 获取ArrayDeque集合的Iterator
		System.out.println("ArrayDeque的Iterator:" + arrayDeque.iterator());
	}
}
