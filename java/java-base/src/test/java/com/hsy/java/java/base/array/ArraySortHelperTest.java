package com.hsy.java.java.base.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path javase/com.javase.array
 * @date 2017/6/18 下午1:24
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ArraySortHelperTest {

    @Test
    public void testArraySort(){
        Integer[] sortedArray = {1,9,20,1000,2,99,23,4,3000} ;
        for(int i=0;i<10;i++){
            ArraySortHelper.bubbleSort(sortedArray);
        }
    }

    @Test
    public void test(){
        Long[] array1 = new Long[]{1l,2l} ;
        Long[] array2 = new Long[]{2l,3l,4l} ;
        List<Long> list1 = Arrays.asList(array1) ;
        List<Long> list2 = Arrays.asList(array2) ;

        list1.removeAll(list2);//此时temp中存在的是list1中去除相同那部分的数据
    }
}