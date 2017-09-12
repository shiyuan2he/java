package com.hsy.java.base.collection;

import java.util.*;

/**
 * 
 * @description <p>
 *              请输入属性描述
 *              </p>
 * @time 2016年3月17日 下午8:58:51
 */
public class ArrayListRemove {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("111");
		list.add("222");
		list.add("333");
		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			String ele = it.next();
			System.out.println(ele);
			// 当迭代倒数第二个元素时
			if (ele.equals("222")) {
				// 直接删除集合中倒数第二个元素
				list.remove(ele);
			}
		}
	}
}
