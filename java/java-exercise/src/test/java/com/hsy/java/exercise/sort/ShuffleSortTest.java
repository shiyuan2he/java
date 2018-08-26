package com.hsy.java.exercise.sort;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.exercise.sort
 * @date 2018/8/24 20:48
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ShuffleSortTest {
    int ARRAY_SIZE = 10;

    @Test
    public void testShuffleSort1(){
        List list = new ArrayList();
        for(int i=0;i<ARRAY_SIZE;i++){
            list.add(i);
        }
        System.out.println("原始数组：" + Arrays.toString(list.toArray()));
        for(int i=0;i<ARRAY_SIZE;i++){
            Collections.shuffle(list);
            System.out.println("乱序后的数组：" + Arrays.toString(list.toArray()));
        }
    }

    @Test
    public void testShuffleSort2(){
        Set set = new HashSet();
        for(int i=0;i<ARRAY_SIZE;i++){
            set.add(i);
        }
        for(int i=0;i<ARRAY_SIZE;i++){
            System.out.println("乱序后的数组：" + Arrays.toString(set.toArray()));
        }
    }
}