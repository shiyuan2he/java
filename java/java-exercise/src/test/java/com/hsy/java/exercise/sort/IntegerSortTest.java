package com.hsy.java.exercise.sort;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.exercise.sort
 * @date 2018/8/17 17:53
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class IntegerSortTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void arrayJoinAndSort(){
//        int[] arrayA = new int[]{1, 10, 46};
//        int[] arrayB = new int[]{2, 40, 45, 100};

        int[] arrayA = new int[]{1, 3, 4};
        int[] arrayB = new int[]{2, 40, 45, 100};
        logger.info("{}", Arrays.toString(twoJoinOne3(arrayA, arrayB)));

    }
    /**
     * @description <p>合并两个数组</p>
     * @author heshiyuan
     * @date 2018/8/17 18:07
     */
    private int[] twoJoinOne(int[] arrayA, int[] arrayB) {
        int[] arrayC = new int[arrayA.length + arrayB.length];
        System.arraycopy(arrayA, 0, arrayC, 0, arrayA.length);
        System.arraycopy(arrayB, 0, arrayC, arrayA.length, arrayB.length);
        Arrays.sort(arrayC);
        return arrayC;
    }

    private int[] twoJoinOne3(int[] arrayA, int[] arrayB) {
        // 定义合并后的数组
        int[] arrayC = new int[arrayA.length + arrayB.length];

        int k = 0;
        for(int i=0; i<arrayA.length; i++){
            for(int j=0; j<arrayB.length; j++){
                if(arrayA[i] > arrayB[j] && arrayB[j]>arrayC[k-1]){
                    arrayC[k] = arrayB[j];
                    k++;
                }
                if(arrayA[i] < arrayB[j]){
                    arrayC[k] = arrayA[i];
                    k++;
                    if(i == arrayA.length-1){
                        for(int m=arrayA.length;m<arrayB.length-arrayA.length;m++){
                            arrayC[k] = arrayB[m];
                            k++;
                        }
                    }
                    break;
                }
            }
        }
        return arrayC;
    }
    private int[] twoJoinOne2(int[] arrayA, int[] arrayB) {
        // 定义合并后的数组
        int[] arrayC = new int[arrayA.length + arrayB.length];
        int k = 0;
        for(int i=0; i<arrayA.length; i++){
            for(int j=0; j<arrayB.length; j++){
                if(arrayA[i] > arrayB[j]){
                    arrayC[k] = arrayB[j];
                    k++;
                }
                if(arrayA[i] < arrayB[j]){
                    arrayC[k] = arrayA[i];
                    k++;
                }
            }
        }
        return arrayC;
    }
}