package org.hsy.java.base.clazz;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @description <p></p>
 * @path paac-base/com.hsy.codebase.utils.javase.clazz.ClassHelper.java
 * @time 2016年8月29日 下午9:28:53
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class ClassHelper {
	/**
	 * @description <p>根据类名获取这个类的属性</p>
	 * @param className
	 * @return
	 * @returnType List<String>
	 * 方法名:getFiledName
	 * 类名:ClassHelper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年8月29日 下午9:35:05
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static List<String> getFiledName(String className) {
		List<String> list = new ArrayList<String>();
		Field[] fields;
		try {
			fields = Class.forName(className).getDeclaredFields();// getDeclaredFields();
			// 遍历所有属性
			for (Field field : fields) {
				if (StringUtils.equals("serialVersionUID", field.getName())) {
					continue;
				}
				if (StringUtils.equals("interface java.util.Set", field.getType().toString())) {
					continue;
				}
				// 获取属性的名字(
				list.add(field.getName());
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
}

