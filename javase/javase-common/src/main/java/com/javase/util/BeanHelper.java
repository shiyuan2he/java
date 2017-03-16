package com.javase.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @description <p>请在此处输入类的描述</p>
 * @path javase-base/com.hsy.codebase.utils.javase.bean
 * @time 2016年7月27日 下午8:32:42
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class BeanHelper{
	/**
	 * 
	 * @description <p>判断JavaBean对象是否为null</p>
	 * @param o
	 * @return
	 * @returnType boolean
	 * 方法名:isNull
	 * 类名:BeanHelper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月28日 下午2:09:18
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static boolean isNull(Object o){
		return o.equals(null);
	}
	/**
	 * 
	 * @description <p>判断JavaBean对象是否不为null</p>
	 * @param o
	 * @return
	 * @returnType boolean
	 * 方法名:isNotNull
	 * 类名:BeanHelper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年10月28日 下午2:10:27
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static boolean isNotNull(Object o){
		return !isNull(o) ;
	}
	/**
	 * 
	 * @description <p>比较两个javabean属性不同</p>
	 * @param obj1
	 * @param Obj2
	 * @return
	 * @throws Exception
	 * @returnType Map<String,String>
	 * 方法名:compare
	 * 类名:BeanHelper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年5月30日 下午3:16:50
	 * @price ￥:5元
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static <T> Map<String, String> compare(T obj1, T Obj2) throws Exception {
        Map<String, String> result = new HashMap<String, String>();

        Field[] fs = obj1.getClass().getDeclaredFields();
        for (Field f : fs) {
            f.setAccessible(true);
            Object v1 = f.get(obj1);
            Object v2 = f.get(Obj2);
            if (equals(v1, v2) == Boolean.FALSE) {
                result.put(f.getName(), (String) v1);
            }
        }
        return result;
    }
	/**
	 * 
	 * @description <p>判断两对象是否相等</p>
	 * @param obj1
	 * @param obj2
	 * @return
	 * @returnType boolean
	 * 方法名:equals
	 * 类名:BeanHelper
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年5月30日 下午3:17:58
	 * @price ￥:5元
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
    public static boolean equals(Object obj1, Object obj2) {
        if (obj1 == obj2) {
            return true;
        } else if (obj1 == null || obj2 == null) {
            return false;
        }
        return obj1.equals(obj2);
    }
    /**
	 * 
	 * @description <p>根据传递进来的bean类，及类的属性名返回属性名对应的get方法的值</p>
	 * @param obj
	 * @param fieldName
	 * @return
	 * @returnType Object
	 * 方法名:getValueByFieldName
	 * 类名:RiskQueServiceImpl
	 * @author heshiyuan
	 * @throws Exception 
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年6月16日 上午11:26:58
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static Object getValueByFieldName(Object obj,String fieldName) throws Exception{
		Object returnObj = new Object() ;
		@SuppressWarnings("rawtypes")
		Class clazz = obj.getClass();
		java.beans.PropertyDescriptor pd = new java.beans.PropertyDescriptor(fieldName, clazz) ;
		java.lang.reflect.Method getMethod = pd.getReadMethod() ;
		if(null != pd){
			returnObj = getMethod.invoke(obj) ;
		}
		return returnObj ;
	}
}

