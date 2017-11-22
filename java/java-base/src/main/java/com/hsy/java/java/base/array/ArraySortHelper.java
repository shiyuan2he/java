package com.hsy.java.java.base.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.base.array
 * @date 13/09/2017 2:31 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ArraySortHelper {
    private static final Logger _logger = LoggerFactory.getLogger(ArraySortHelper.class) ;
    /**
     * @description <p></p>
     * @param sortedArray 被排序的数组
     * @author heshiyuan
     * @date 13/09/2017 2:35 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static void bubbleSort(Integer[] sortedArray){
        long start = System.currentTimeMillis() ;
        _logger.info("排序之前的数组{}", Arrays.asList(sortedArray).toString()) ;
        for(int i=0;i<sortedArray.length;i++){
            for(int j=i+1;j<sortedArray.length;j++){
                if(sortedArray[i] < sortedArray[j]){
                    int temp = sortedArray[i] ;
                    sortedArray[i] = sortedArray[j] ;
                    sortedArray[j] = temp ;
                }
            }
        }
        _logger.info("排序之后的数组{}",Arrays.asList(sortedArray).toString()) ;
        long end = System.currentTimeMillis() ;
        _logger.info("冒泡排序耗时{}ms",(end-start)) ;
    }
}
