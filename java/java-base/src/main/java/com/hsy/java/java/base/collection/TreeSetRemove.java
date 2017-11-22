package com.hsy.java.java.base.collection;

import java.util.*;

/**
 * 
 * @description <p>
 *              请输入属性描述
 *              </p>
 * @time 2016年3月17日 下午9:00:50
 */
public class TreeSetRemove {
	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<String>();
		set.add("111");
		set.add("222");
		set.add("333");
		System.out.println(set);
		for (Iterator<String> it = set.iterator(); it.hasNext();) {
			String ele = it.next();
			if (ele.equals("333")) {
				set.remove(ele);
			}
		}
	}
}
