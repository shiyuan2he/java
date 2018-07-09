package com.hsy.java.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description <p>集合工具类</p>
 * @author heshiyuan @date 2017年3月16日 下午7:32:44
 * @path: javase-common/com.javase.util/CollectionHelper.java
 * @price ￥：5元
 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
 * @email heshiyuan@chtwm.com
 * @callnumber 15910868535
 */
public class CollectionHelper {
	private final static Logger _logger = LoggerFactory.getLogger(CollectionHelper.class) ;
    /**
     * @description <p>处理的集合元素越多，去重速度更快，10万元素100毫秒，10个元素200毫秒</p>
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
	public static void duplicateRemoval(List<Integer> list) {
        _logger.info("CollectionHelper.duplicateRemoval工具类去重开始！");
        long startTime = System.currentTimeMillis() ;
        try{
            if(list == null) {
                _logger.info("将要去重的list集合是空，请检查参数再行调用！");
                long endTime = System.currentTimeMillis() ;
                _logger.info("调用去重工具类耗时{}毫秒！",(endTime - startTime));
                return ;
            }
            _logger.info("去重之前的集合是{}",list.toString());
            list = list.parallelStream().distinct().collect(Collectors.toList()) ;
            _logger.info("去重之后的集合是{}",list.toString());
        }catch(Exception e){
            _logger.error("调用去重工具类CollectionHelper.duplicateRemoval遇到异常，异常信息:{}",e.getMessage());
            throw e ;
        }finally{
            long endTime = System.currentTimeMillis() ;
            _logger.info("调用去重工具类耗时{}毫秒",(endTime - startTime));
            _logger.info("CollectionHelper.duplicateRemoval工具类去重结束！");
        }
    }
	/**
	 * @description <p>利用set集合进行list去重</p>
	 * @param list
	 * @returnType void
	 * @author heshiyuan
	 * @path javase-common/com.javase.util/CollectionHelper.java
	 * @date 2017年3月16日 下午7:40:02
	 * @price ￥：三毛三
	 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
	 * @email heshiyuan@chtwm.com
	 * @callnumber 15910868535
	 */
	public static void removeDuplicateBySet(List<Object> list)   { 
	    Set<Object> h = new HashSet<>(list);
	    list.clear(); 
	    list.addAll(h); 
	}
	/**
	 * @description <p>方法描述</p>
	 * @param list
	 * @returnType void
	 * @author heshiyuan
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

	/**
	 * 去除两个List里相同的部分
	 */
	public static void removeTheSameOfList(List<Long> listA,List<Long> listB){
		for (int i = 0; i < listA.size(); i++) {
			Long a = listA.get(i) ;
			for (int j = 0; j < listA.size(); j++) {
				Long b = listB.get(j) ;
				if(a == b){
					_logger.info("{}==>{};{}==>{}",listA.toString(),listA.get(i),listB.toString(),listB.get(j));

					listA.remove(a) ;
					listB.remove(b) ;
					i--;j--;
				}
			}
		}
	}
}

