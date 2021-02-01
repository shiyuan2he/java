package com.hsy.java.base.map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.base.map
 * @date 19/10/2018 19:06
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class MapDoTest {

    @Test
    public void testMapRemove(){
        Map<String, Object> map = new HashMap<>();
        map.put("0", 1);
        map.put("1", null);
        map.put("2", 1);
        map.put("3", "");
        map.put("4", 1);
        map.put("5", "");
        map.put("6", null);

        Map<String, Object> newMap = new HashMap<>();
        map.forEach((key, value) -> {
            if(null!=value && StringUtils.isNotBlank(String.valueOf(value))){
                newMap.put(key, value);
            }
        });
        System.out.println(newMap.toString());
    }
    @Test
    public void testMapRemove2(){
        Map<String, Object> map = new HashMap<>();
        map.put("0", 1);
        map.put("1", null);
        map.put("2", 1);
        map.put("3", "");
        map.put("4", 1);
        map.put("5", "");
        map.put("6", null);

        Set<Entry<String, Object>> set = map.entrySet();
        Iterator<Entry<String, Object>> it = set.iterator();
        while(it.hasNext()){
            Entry<String, Object> en = it.next();
            if(en.getValue() == null){ // 移除nul
                it.remove();
            }else if(en.getValue() instanceof String && StringUtils.isBlank(String.valueOf(en.getValue()))){// 移除""
                it.remove();
            }
        }
        System.out.println(map.toString());
    }
}