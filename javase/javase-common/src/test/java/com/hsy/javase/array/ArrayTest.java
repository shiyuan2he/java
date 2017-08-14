package com.hsy.javase.array;

import org.junit.Test;

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
public class ArrayTest {

    @Test
    public void testArraySort(){
        int[] array = {1,4,67,98,30} ;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i] < array[j]){
                    int temp = array[i] ;
                    array[i] = array[j] ;
                    array[j] = temp ;
                }
            }
        }
        System.out.println(array) ;
    }
}
