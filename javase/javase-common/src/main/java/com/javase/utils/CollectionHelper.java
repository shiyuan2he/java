package com.javase.utils;

import com.javase.bean.BeanHelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @description <p>类文件描述</p>
 * @author heshiyuan @date 2017年3月16日 下午7:32:44
 * @path: javase-common/com.javase.util/CollectionHelper.java
 * @price ￥：5元
 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
 * @email heshiyuan@chtwm.com
 * @callnumber 15910868535
 */
public class CollectionHelper {
	/**
	 * @description <p>利用双重for循环进行list去重</p>
	 * @param list
	 * @return
	 * @returnType List<Object>
	 * @author heshiyuan @date 2017年3月16日 下午7:37:53
	 * @path javase-common/com.javase.util/CollectionHelper.java
	 * @date 2017年3月16日 下午7:37:53
	 * @price ￥：三毛三
	 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
	 * @email heshiyuan@chtwm.com
	 * @callnumber 15910868535
	 */
	public static void removeDuplicateByFor(List<Object> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (BeanHelper.equals(list.get(j), list.get(i))) {
					list.remove(j);
				}
			}
		}
		System.out.println(list);
	}
	/**
	 * @description <p>利用set集合进行list去重</p>
	 * @param list
	 * @returnType void
	 * @author heshiyuan @date 2017年3月16日 下午7:40:02
	 * @path javase-common/com.javase.util/CollectionHelper.java
	 * @date 2017年3月16日 下午7:40:02
	 * @price ￥：三毛三
	 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
	 * @email heshiyuan@chtwm.com
	 * @callnumber 15910868535
	 */
	public static void removeDuplicateBySet(List<Object> list)   { 
	    Set<Object> h = new HashSet<Object>(list); 
	    list.clear(); 
	    list.addAll(h); 
	    System.out.println(list);
	}
	/**
	 * @description <p>方法描述</p>
	 * @param list
	 * @returnType void
	 * @author heshiyuan @date 2017年3月16日 下午7:42:02
	 * @path javase-common/com.javase.util/CollectionHelper.java
	 * @date 2017年3月16日 下午7:42:02
	 * @price ￥：三毛三
	 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
	 * @email heshiyuan@chtwm.com
	 * @callnumber 15910868535
	 */
	public static void removeDuplicateWithOrder(List<Object> list) {
		Set<Object> set = new HashSet<Object>();
		List<Object> newList = new ArrayList<Object>();
		for (Iterator<Object> iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (set.add(element))
				newList.add(element);
		}
		list.clear();
		list.addAll(newList);
		System.out.println(" remove duplicate " + list);
	} 
}

