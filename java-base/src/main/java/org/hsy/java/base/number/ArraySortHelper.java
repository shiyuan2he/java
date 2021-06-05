package org.hsy.java.base.number;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.base.array
 * @date 13/09/2017 2:31 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ?5    ????hewei1109
 */
public class ArraySortHelper {
    private static final Logger _logger = LoggerFactory.getLogger(ArraySortHelper.class) ;
    /**
     * @description <p></p>
     * @param sortedArray ???????????
     * @author heshiyuan
     * @date 13/09/2017 2:35 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static void bubbleSortToSmall(Integer[] sortedArray){
        long start = System.currentTimeMillis() ;
        _logger.info("????????????{}", Arrays.asList(sortedArray).toString()) ;
        for(int i=0;i<sortedArray.length;i++){
            for(int j=i+1;j<sortedArray.length;j++){
                // ?????????????????С??????λ??
                if(sortedArray[i] < sortedArray[j]){
                    int temp = sortedArray[i] ;
                    sortedArray[i] = sortedArray[j] ;
                    sortedArray[j] = temp ;
                }
            }
        }
        _logger.info("????????????{}",Arrays.asList(sortedArray).toString()) ;
        long end = System.currentTimeMillis() ;
        _logger.info("?????????{}ms",(end-start)) ;
    }

    /**
     * @description <p>
     *     ???????????
     *     ??临??? n*(n-1)/2
     * </p>
     * @param
     * @return
     * @author heshiyuan
     * @date 2018/1/8 13:52
     */
    public static void bubbleSortToBig(Integer[] sortedArray){
        long start = System.currentTimeMillis() ;
        _logger.info("????????????{}", Arrays.asList(sortedArray).toString()) ;
        for(int i=0;i<sortedArray.length;i++){
            for(int j=i+1;j<sortedArray.length;j++){
                // ?????????????????С??????λ??
                if(sortedArray[i] > sortedArray[j]){
                    sortedArray[i] = sortedArray[i] +  sortedArray[j] ;
                    sortedArray[j] = sortedArray[i] - sortedArray[j] ;
                    sortedArray[i] = sortedArray[i] - sortedArray[j] ;
                }
            }
        }
        _logger.info("????????????{}",Arrays.asList(sortedArray).toString()) ;
        long end = System.currentTimeMillis() ;
        _logger.info("?????????{}ms",(end-start)) ;
    }
}
