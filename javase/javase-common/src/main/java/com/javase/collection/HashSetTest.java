package com.hsy.codebase.utils.javase.collection;

import java.util.*;

/**
 * 
 * @description 
 *     <p>比较重写hashCode方法前后，new Name()之间的区别</p>
 * @time 2016年3月17日 下午6:29:23
 */
class Name {
	private String first;
	private String last;

	public Name(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o.getClass() == Name.class) {
			Name n = (Name) o;
			return n.first.equals(first) && n.last.equals(last);
		}
		return false;
	}

	// 根据first计算Name对象的hashCode()返回值
	public int hashCode() {
		return first.hashCode();
	}

	public String toString() {
		return "Name[first=" + first + ", last=" + last + "]";
	}
}

public class HashSetTest {
	public static void main(String[] args) {
		/*********************  重写hashCode()方法前  **************************/
		Set<Name> s = new HashSet<Name>();
		s.add(new Name("abc", "123"));
		System.out.println(s.contains(new Name("abc", "123")));

		/*********************  重写hashCode()方法后  **************************/
		HashSet<Name> set = new HashSet<Name>();
		set.add(new Name("abc", "123"));
		set.add(new Name("abc", "456"));
		System.out.println(set);
	}
}
