package org.hsy.java.base.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * @description <p>类文件描述</p>
 * @author heshiyuan @date 2017年3月10日 下午1:45:49
 * @path: javase-common/com.javase.util/ConvertHelper.java
 * @price ￥：5元
 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
 * @email heshiyuan@chtwm.com
 * @callnumber 15910868535
 */
public class ConvertHelper {
	private ConvertHelper(){}

    /**
     * @description <p>Map<String, String> map入参支持</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/10/2018 14:23
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    public static <T> T map2BeanWrapper(Map<String, String> map, Class<T> clazz) {
        Map<String, Object> returnMap = new HashMap<>();
        map.forEach((key, value) -> returnMap.put(key, value));
        return map2Bean(returnMap, clazz);
    }
    /**
     * @description <p>Map<Object, Object> map入参支持</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/10/2018 14:24
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    public static <T> T map2BeanWrapperEnhance(Map<Object, Object> map, Class<T> clazz) {
        Map<String, Object> returnMap = new HashMap<>();
        map.forEach((key, value) -> returnMap.put((String) key, value));
        return map2Bean(returnMap, clazz);
    }
    /**
     * @description <p>Map转换层Bean，使用泛型免去了类型转换的麻烦。 </p>
     * @param
     * @return 转成的bean
     * @author heshiyuan
     * @date 18/10/2018 14:10
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    public static <T> T map2Bean(Map<String, Object> map, Class<T> clazz) {
        T bean = null;
        try {
            bean = clazz.newInstance();
            BeanUtils.populate(bean, map);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
    public static Map<String,Object> beanToMap(Object... object){
		Map<String,Object> returnMap = new HashMap<>() ;
		try {
			for(Object obj : object){
				Class<? extends Object> class1 = obj.getClass() ;
				Method[] method = class1.getMethods() ;
				Pattern pattern = Pattern.compile("^get*") ;
				Matcher matcher = null ;
				for (Method method2 : method) {
					matcher = pattern.matcher(method2.getName()) ;
					if(matcher.find()){
						String key = method2.getName().replace("get", "") ;
						//将首字母大写变消息
						key = (key.charAt(0)+"").toLowerCase().concat(key.substring(1));
						if("class".equals(key)){
							continue ;
						}
						Object value = method2.invoke(obj) ;
						if(null == value){
							continue ;
						}
						returnMap.put(camel2LowerWithUnderscores(key), value) ;
					}
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return returnMap ;
	}
	/**
	 * 小写命名规则中，单词与单词之间的间隔
	 */
	private static final char ATTRIBUTE_NAME_SEPARATOR = '_';
	/**
	 * @description <p>骆驼命名转换小写下划线命名</p>
	 * @param input
	 * @return
	 * @returnType String
	 * @author heshiyuan @date 2017年3月11日 下午3:42:48
	 * @path javase-common/com.javase.util/ConvertHelper.java
	 * @date 2017年3月11日 下午3:42:48
	 * @price ￥：三毛三
	 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
	 * @email heshiyuan@chtwm.com
	 * @callnumber 15910868535
	 */
	public static String camel2LowerWithUnderscores(String input) {
		if (input == null)
			return input; // garbage in, garbage out
		int length = input.length();
		StringBuilder result = new StringBuilder(length * 2);
		int resultLength = 0;
		boolean wasPrevTranslated = false;
		for (int i = 0; i < length; i++) {
			char c = input.charAt(i);
			if (i > 0 || c != ATTRIBUTE_NAME_SEPARATOR) // skip first starting underscore
			{
				if (Character.isUpperCase(c)) {
					if (!wasPrevTranslated && resultLength > 0 && result.charAt(resultLength - 1) != ATTRIBUTE_NAME_SEPARATOR) {
						result.append(ATTRIBUTE_NAME_SEPARATOR);
						resultLength++;
					}
					c = Character.toLowerCase(c);
					wasPrevTranslated = true;
				} else {
					wasPrevTranslated = false;
				}
				result.append(c);
				resultLength++;
			}
		}
		return resultLength > 0 ? result.toString() : input;
	}
	/**
	 * @description <p>利用commons-beanutils工具类转换</p>
	 * @param params
	 * @return
	 * @returnType Map<String,Object>
	 * @author heshiyuan @date 2017年3月11日 下午3:59:31
	 * @path javase-common/com.javase.util/ConvertHelper.java
	 * @date 2017年3月11日 下午3:59:31
	 * @price ￥：三毛三
	 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
	 * @email heshiyuan@chtwm.com
	 * @callnumber 15910868535
	 */
	public static Map<String,Object> beanToMapByCommonsBeanUtils(Object... params){
	    try {
            Map<String,Object> param = new HashMap<String,Object>();
            Map<String, Object> describe=null;
            for(Object obj:params){
                describe = PropertyUtils.describe(obj);
                param.putAll(describe);
            }
            return param;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);	
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
	}
    public static <T> void setDefault(Object data) {
        try {
            if(data instanceof List){
                ((List) data).stream().forEach(entity -> setDefaultValue(entity));
            }else{
                setDefaultValue(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @description <p>将值为null的字段改为""空字符串</p>
     * @param
     * @return
     * @author heshiyuan
     * @date 2018/5/22 13:26
     */
    private static void setDefaultValue(Object target) {
        if (target != null) {
            try {
                BeanInfo beanInfo = Introspector.getBeanInfo(target.getClass(), Object.class);
                PropertyDescriptor[] propertyDescripions = beanInfo.getPropertyDescriptors();

                for (PropertyDescriptor propertyDescripion : propertyDescripions) {
                    Object value = propertyDescripion.getReadMethod().invoke(target);
                    if (value == null) {
                        propertyDescripion.getWriteMethod().invoke(target,"");
                    }
                }
            } catch (IntrospectionException e) {

            } catch (IllegalArgumentException e) {

            } catch (IllegalAccessException e) {

            } catch (InvocationTargetException e) {

            }
        }
    }
}

