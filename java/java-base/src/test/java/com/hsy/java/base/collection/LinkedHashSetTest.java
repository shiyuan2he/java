package com.hsy.java.base.collection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.java.base.collection
 * @date 2018/7/5 13:35
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class LinkedHashSetTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void testLinkedHashSet1(){
        Set<Integer> sets = new LinkedHashSet<>(20);
        for (int i = 0; i < 10; i++) {
            int count = new Random().nextInt(10);
            sets.add(count);
            logger.info("{}",count);
        }
        logger.info("{}",sets.toString());
    }
    @Test
    public void testTreeSet2(){
        Set<User> sets = new LinkedHashSet<>();
        for (int i = 0; i < 10; i++) {
            int count = new Random().nextInt(10);
            logger.info("{}",count);
            User user = new User();
            user.setId(count);
            sets.add(user);
        }
        logger.info("{}",sets.toString());
    }
    class User{
        private Integer id;
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
