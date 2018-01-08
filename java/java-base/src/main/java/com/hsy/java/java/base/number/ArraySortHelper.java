package com.hsy.java.java.base.number;

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
 * @price ?5    ΢�ţ�hewei1109
 */
public class ArraySortHelper {
    private static final Logger _logger = LoggerFactory.getLogger(ArraySortHelper.class) ;
    /**
     * @description <p>ð�����򣬽���</p>
     * @param sortedArray �����������
     * @author heshiyuan
     * @date 13/09/2017 2:35 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static void bubbleSortToSmall(Integer[] sortedArray){
        long start = System.currentTimeMillis() ;
        _logger.info("����֮ǰ������{}", Arrays.asList(sortedArray).toString()) ;
        for(int i=0;i<sortedArray.length;i++){
            for(int j=i+1;j<sortedArray.length;j++){
                // ���ǰһ�����Ⱥ�һ����С������λ��
                if(sortedArray[i] < sortedArray[j]){
                    int temp = sortedArray[i] ;
                    sortedArray[i] = sortedArray[j] ;
                    sortedArray[j] = temp ;
                }
            }
        }
        _logger.info("����֮�������{}",Arrays.asList(sortedArray).toString()) ;
        long end = System.currentTimeMillis() ;
        _logger.info("ð�������ʱ{}ms",(end-start)) ;
    }

    /**
     * @description <p>
     *     ð����������
     *     �ռ临�Ӷ� n*(n-1)/2
     * </p>
     * @param
     * @return
     * @author heshiyuan
     * @date 2018/1/8 13:52
     */
    public static void bubbleSortToBig(Integer[] sortedArray){
        long start = System.currentTimeMillis() ;
        _logger.info("����֮ǰ������{}", Arrays.asList(sortedArray).toString()) ;
        for(int i=0;i<sortedArray.length;i++){
            for(int j=i+1;j<sortedArray.length;j++){
                // ���ǰһ�����Ⱥ�һ����С������λ��
                if(sortedArray[i] > sortedArray[j]){
                    sortedArray[i] = sortedArray[i] +  sortedArray[j] ;
                    sortedArray[j] = sortedArray[i] - sortedArray[j] ;
                    sortedArray[i] = sortedArray[i] - sortedArray[j] ;
                }
            }
        }
        _logger.info("����֮�������{}",Arrays.asList(sortedArray).toString()) ;
        long end = System.currentTimeMillis() ;
        _logger.info("ð�������ʱ{}ms",(end-start)) ;
    }
}
