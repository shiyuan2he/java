package com.hsy.algorithm.utils;

import java.util.Random;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.algorithm.utils
 * @date 2018/8/27 20:47
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class SortUtils {

    /**
     * @description <p>元素交换</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 2018/8/27 20:49 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    public static void swap(int[] array, int i, int j){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static int[] generateRandomNumber(int length){
        int[] randomArray = new int[length];
        for(int i=0;i<length;i++){
            randomArray[i] = new Random().nextInt(length);
        }
        return randomArray;
    }
    /**
     * @description <p>生成length以内升序数组</p>
     * @param length 传递进来的数组长度
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 2018/8/27 22:30
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    public static int[] generateNumberByASC(int length){
        int[] randomArray = new int[length];
        for(int i=0;i<length;i++){
            randomArray[i] = i+1;
        }
        return randomArray;
    }

    /**
     * @description <p>生成length以内降序数组</p>
     * @param length 传递进来的数组长度
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 2018/8/27 22:30
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    public static int[] generateNumberByDesc(int length){
        int[] randomArray = new int[length];
        int value = 1;
        for(int i=length;i>0;i--){
            randomArray[i-1] = value;
            value ++;
        }
        return randomArray;
    }
    public static void swap(int i, int j){
        i = i + j;
        i = i -j ;
        j = i - j;
    }
}
