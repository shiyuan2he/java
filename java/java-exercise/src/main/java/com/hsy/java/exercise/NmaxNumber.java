package com.hsy.java.exercise;

import com.hsy.java.java.base.array.ArraySortHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;

/**
 * @author heshiyuan
 * @description <p>给定一个长度位m的数组，找出第n大（n<=m）</p>
 * @path java/com.hsy.java.exercise
 * @date 2017/11/17 09:39
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@SuppressWarnings("unused")
public class NmaxNumber {
    private static final Logger _logger = LoggerFactory.getLogger(NmaxNumber.class) ;
    private static int arrayLength = 30000;
    private static int arrayMax = 20000;
    private static Integer[] originArray = new Integer[arrayLength] ;
    static{
        originArray = generateArrayByLength(arrayLength) ;
    }
    private static Integer[] generateArrayByLength(int length){
        Integer[] tempArray = new Integer[length] ;
        for(int i=0;i<length;i++){
            Random random = new Random();
            tempArray[i] = random.nextInt() * 100000000 ;
        }
        return tempArray ;
    }
    public static void getNmaxNumberBySort(){
        _logger.info("getNmaxNumberBySort数组{}", Arrays.asList(originArray).toString()) ;
        Integer[] tempArray = originArray.clone() ;
        long start = System.currentTimeMillis() ;
        ArraySortHelper.bubbleSort(tempArray);
        int nMaxNumber = tempArray[arrayMax-1];
        _logger.info("第{}大的元素是{}",arrayMax,nMaxNumber);
        long end = System.currentTimeMillis() ;
        _logger.info("排序取值耗时{}ms",(end-start)) ;
    }

    public static void getNmaxNumberByArray(){
        Integer[] tempArrays = originArray.clone() ;
        _logger.info("getNmaxNumberByArray数组{}", Arrays.asList(tempArrays).toString()) ;
        long start = System.currentTimeMillis() ;
        Integer[] tempArray = new Integer[arrayMax] ;
        for(int i=0;i<arrayMax;i++){
            tempArray[i] = tempArrays[i] ;
        }
        ArraySortHelper.bubbleSort(tempArray);
        for(int i=arrayMax;i<arrayLength;i++){
            if(originArray[i] > tempArray[arrayMax-1]){
                tempArray[arrayMax-1] = originArray[i] ;
            }
        }
        int nMaxNumber = tempArrays[arrayMax-1];
        _logger.info("第{}大的元素是{}",arrayMax,nMaxNumber);
        long end = System.currentTimeMillis() ;
        _logger.info("数组取值耗时{}ms",(end-start)) ;
    }

    public static void main(String[] args){
        getNmaxNumberBySort();
        _logger.info("--------------") ;
        getNmaxNumberByArray() ;
    }
}
