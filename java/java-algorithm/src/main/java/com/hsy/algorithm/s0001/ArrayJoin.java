package com.hsy.algorithm.s0001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.algorithm.s0001
 * @date 2018/8/25 11:15
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ArrayJoin {
    private final static Logger logger = LoggerFactory.getLogger(ArrayJoin.class);
    
    /**
     * @description <p>两个已经排好序的不同长度数组合并，并排序</p>
     * @param arrayA 数组A
     * @param arrayB 数组B
     * @return int[] 合并后并且排序的数组
     * @author heshiyuan 
     * @date 2018/8/25 11:27 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    @SuppressWarnings("Duplicates")
    public static int[] join(int[] arrayA, int[] arrayB, String sortType){

        long start = System.currentTimeMillis();
        logger.info(Arrays.toString(arrayA));
        logger.info(Arrays.toString(arrayB));
        int[] arrayC = null;
        if(arrayA.length<=0 && arrayB.length>0){
            long end = System.currentTimeMillis();
            arrayC = new int[arrayB.length];
            Arrays.sort(arrayB);
            logger.info("耗时：{}", (end-start));
            return arrayB;
        }else if(arrayB.length<=0 && arrayA.length>0){
            long end = System.currentTimeMillis();
            arrayC = new int[arrayA.length];
            Arrays.sort(arrayA);
            logger.info("耗时：{}", (end-start));
            return arrayA;
        }else if(arrayB.length<=0 && arrayA.length<=0){
            return null;
        }
        arrayC = new int[arrayA.length + arrayB.length];
        System.arraycopy(arrayA, 0, arrayC, 0, arrayA.length);
        System.arraycopy(arrayB, 0, arrayC, arrayA.length, arrayB.length);
        Arrays.sort(arrayC);
        long end = System.currentTimeMillis();
        logger.info("耗时：{} ms", (end-start));
        return arrayC;
    }
}
