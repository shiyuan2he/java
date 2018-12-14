package com.hsy.algorithm.s0001;

import com.hsy.algorithm.utils.SortUtils;
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
        long start = System.currentTimeMillis();
        logger.info("原始数组：{}" ,Arrays.toString(arrayA));
        for (int i = 0; i < arrayA.length-1; i++) {
            for (int j = 0; j < arrayA.length - 1 - i; j++) {
                if (arrayA[j] > arrayA[j+1]) {
//                    logger.info("比较{}跟{}，{}>{},交换位置", arrayA[j], arrayA[j+1], arrayA[j], arrayA[j+1]);
                    SortUtils.swap(arrayA, j, j+1);
//                    logger.info("交换后数组：{}", Arrays.toString(arrayA));
                }else{
//                    logger.info("比较{}跟{}，{}<{},不交换位置 , 数组：{}", arrayA[j], arrayA[j+1], arrayA[j], arrayA[j+1], Arrays.toString(arrayA));
                }
            }
//            logger.info("第{}轮查找出来第{}小的数{}", (i+1), (i+1) ,arrayA[i]);
        }
        long end = System.currentTimeMillis();
        logger.info("耗时：{} ms", (end - start));
        return arrayA;
    }
    public static int[] twoWayBubbleSort(int[] arrayA){
        if(null == arrayA || arrayA.length <= 0) return null;
        long start = System.currentTimeMillis();
        logger.info("原始数组：{}" ,Arrays.toString(arrayA));
        int left = 0, right = arrayA.length - 1; // 边界值
        while (left < right){
            for(int i=left;i<right;i++){
                if(arrayA[i] > arrayA[i+1]){
//                    logger.info("比较{}跟{}，{}>{},交换位置", arrayA[i], arrayA[i+1], arrayA[i], arrayA[i+1]);
                    SortUtils.swap(arrayA, i, i+1);
//                    logger.info("交换后数组：{}", Arrays.toString(arrayA));
                }
            }
            right --  ;
            for(int i=right;i>left;i--){
                if(arrayA[i-1] > arrayA[i]){
//                    logger.info("比较{}跟{}，{}>{},交换位置", arrayA[i-1], arrayA[i], arrayA[i-1], arrayA[i]);
                    SortUtils.swap(arrayA, i-1, i);
//                    logger.info("交换后数组：{}", Arrays.toString(arrayA));
                }
            }
            left ++ ;
        }
        long end = System.currentTimeMillis();
        logger.info("耗时：{} ms", (end - start));
        return arrayA;
    }
}
