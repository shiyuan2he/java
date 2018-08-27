package com.hsy.algorithm.s0001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author heshiyuan
 * @description <p>冒泡排序</p>
 * @path java/com.hsy.algorithm.s0002
 * @date 2018/8/27 16:32
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class BubbleSort {
    private static final Logger logger = LoggerFactory.getLogger(BubbleSort.class);
    public static int[] bubbleSort(int[] arrayA){
        if(null == arrayA || arrayA.length <= 0) return null;

        logger.info("原始数组：{}" ,Arrays.toString(arrayA));
        for (int i = 0; i < arrayA.length-1; i++) {
            for (int j = i; j < arrayA.length -1; j++) {
                if (arrayA[i] > arrayA[j+1]) {//升序，找小的，并且自己不和自己比较
                    int temp = arrayA[j+1];
                    arrayA[j+1] = arrayA[i];
                    arrayA[i] = temp;
                    logger.info("比较{}跟{}，{}>{},交换位置, 数组：{}", arrayA[j+1], arrayA[i], arrayA[j+1], arrayA[i], Arrays.toString(arrayA));
                }else{
                    logger.info("比较{}跟{}，{}<{},不交换位置", arrayA[j+1], arrayA[i], arrayA[j+1], arrayA[i]);
                }
            }
//            logger.info("第{}轮查找出来第{}小的数{}", (i+1), (i+1) ,arrayA[i]);
        }

        return arrayA;
    }
}
