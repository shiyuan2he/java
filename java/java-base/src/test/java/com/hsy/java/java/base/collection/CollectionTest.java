package com.hsy.java.java.base.collection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.java.base.collection
 * @date 2018/7/5 16:59
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class CollectionTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    public static Collection fill(Collection<String> collection){
        collection.add("cat");
        collection.add("dog");
        collection.add("girl");
        collection.add("boy");
        collection.add("dog");
        return collection;
    }
    public static Map<String, String> fill(Map<String, String> map){
        map.put("cat", "cat");
        map.put("dog", "dog");
        map.put("girl", "girl");
        map.put("boy", "boy");
        map.put("dog", "dog");
        return map;
    }

    @Test
    public void testCollection(){
        logger.info("{}", fill(new ArrayList<>()));// arrayList 随机访问元素快，删除，增加较慢
        logger.info("{}", fill(new LinkedList<>()));//增删较快，顺序访问较快，随机访问较慢
        logger.info("{}", fill(new HashSet<>()));
        logger.info("{}", fill(new TreeSet<>()));
        logger.info("{}", fill(new LinkedHashSet<>()));
        logger.info("{}", fill(new HashMap<>()));
        logger.info("{}", fill(new TreeMap<>()));
        logger.info("{}", fill(new LinkedHashMap<>()));
    }

    @Test
    public void testIteror(){
        List list = (List) fill(new ArrayList<>());
        logger.info("{}", list.toString());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            logger.info("{}", iterator.next());
            iterator.remove();
            logger.info("{}", list.toString());
        }
    }
}
