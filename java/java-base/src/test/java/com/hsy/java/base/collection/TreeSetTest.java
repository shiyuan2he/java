package com.hsy.java.base.collection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

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
public class TreeSetTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void testTreeSet1(){
        Set<Integer> sets = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            sets.add(new Random().nextInt(10));
        }
        logger.info("{}",sets.toString());
    }
    @Test
    public void testTreeSet2(){
        Set<User> sets = new TreeSet<>(Comparator.comparing(User::getId).reversed());
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(new Random().nextInt(10));
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
