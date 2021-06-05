package org.hsy.java.exercise.sort;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.exercise.sort
 * @date 2018/8/17 17:53
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class IntegerSortTest {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Test
    public void shuffleArray(){
        int[] array = new int[10];
        for(int i=1;i<=10;i++){
            array[i-1] = i;
        }
        logger.info("原数组：{}", Arrays.toString(array));
        shuffleArray1(array);
    }

    @Test
    public void arrayJoinAndSort(){
        int[] arrayA = new int[]{1, 3, 5};
        int[] arrayB = new int[]{2, 3, 3, 4, 6};
        logger.info("{}", Arrays.toString(twoJoinOne3(arrayA, arrayB)));
    }
    private void shuffleArray1(int[] array){
        List list = Arrays.asList(array);
        for(int i=0;i<10;i++){
            Collections.shuffle(list);
            list.parallelStream().forEach(aa -> logger.info("{}",aa));
        }
    }
    private void shuffleArray2(int[] array){
        Integer[] sortArray = new Integer[100];
        for(int i=1;i<=100;i++){
            sortArray[i-1] = i;
        }
        logger.info("原始数组{}", Arrays.toString(sortArray));

        List list = new LinkedList();
        list.add(Arrays.asList(sortArray));

        for(int i=99;i>=0;i++){
            int index = new Random().nextInt(i);
            logger.info("{}", index);
            sortArray[i] = (int) list.get(index);
        }
        logger.info("乱序后的数组{}", Arrays.toString(sortArray));
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
                if(arrayA[i] == arrayB[j]){
                    arrayC[k] = arrayB[j];
                    k++;
                    continue;
                }
                if(arrayA[i] > arrayB[j] && arrayB[j]>arrayC[k-1]){
                    arrayC[k] = arrayB[j];
                    k++;
                }
                if(arrayA[i] < arrayB[j]){
                    arrayC[k] = arrayA[i];
                    k++;
                    if(i == arrayA.length-1){
                        for(int m=0;m<arrayB.length;m++){
                            if(arrayB[m] >= arrayA[arrayA.length-1]){
                                arrayC[k] = arrayB[m];
                                k++;
                            }
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
    private int[] twoJoinOne3(){
        int[] a = {1,3,5,7};
        int[] b = {0,4,8};
        int[] c = new int[a.length + b.length];
        int index = 0;
        int count = 0;
        int times = 0;
        for (int i = 0; i < b.length; i++) {

            for(int j = count; j < a.length; j++) {
                if(b[i] < a[j]) {
                    c[index++] = b[i];
                    times++;
                    break;
                } else {
                    count++;
                    c[index++] = a[j];
                }
            }

        }
        //判断如果短数组中还有未被利用的数据，则加入新数组的最后面
        while(times < b.length) {
            c[index++] = b[times++];
        }

        for(int i = 0; i< c.length; i++) {
            System.out.println(c[i]);
        }
        return null;
    }
}