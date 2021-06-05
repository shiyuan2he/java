package org.hsy.java.base.collection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.java.base.collection
 * @date 2018/7/5 13:35
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class LinkedHashMapTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void testLinkedHashMap1(){
        Map<String, Integer> maps = new LinkedHashMap<>();
        for (int i = 0; i < 10; i++) {
            int count = new Random().nextInt(10);
            maps.put(""+i,count);
            logger.info("{}",count);
        }
        logger.info("{}",maps.toString());
    }
}
