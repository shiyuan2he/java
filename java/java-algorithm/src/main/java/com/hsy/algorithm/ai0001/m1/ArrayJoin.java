package com.hsy.algorithm.ai0001.m1;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.algorithm.ai0001.s0002
 * @date 2018/8/25 11:15
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Slf4j
public class ArrayJoin {
    /**
     * @description <p>两个已经排好序的不同长度数组合并，并排序</p>
     * @param arrayA 数组A
     * @param arrayB 数组B
     * @return int[] 合并后并且排序的数组
     * @author heshiyuan 
     * @date 2018/8/25 11:27 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    @SuppressWarnings("Duplicates")
    public static int[] join(int[] arrayA, int[] arrayB){
        long start = System.currentTimeMillis();
        log.info(Arrays.toString(arrayA));
        log.info(Arrays.toString(arrayB));
        int[] arrayC = null;
        if((arrayA==null&&arrayB!=null) || (arrayA.length<=0&&arrayB.length>0)){
            long end = System.currentTimeMillis();
            arrayC = new int[arrayB.length];
            Arrays.sort(arrayB);
            log.info("耗时：{} ms", (end-start));
            return arrayB;
        }else if((arrayA!=null&&arrayB==null) || (arrayB.length<=0 && arrayA.length>0)){
            long end = System.currentTimeMillis();
            arrayC = new int[arrayA.length];
            Arrays.sort(arrayA);
            log.info("耗时：{} ms", (end-start));
            return arrayA;
        }else if((arrayA==null&&arrayB==null) || (arrayB.length<=0 && arrayA.length<=0)){
            return null;
        }
        arrayC = new int[arrayA.length + arrayB.length];
        System.arraycopy(arrayA, 0, arrayC, 0, arrayA.length);
        System.arraycopy(arrayB, 0, arrayC, arrayA.length, arrayB.length);
        Arrays.sort(arrayC);
        long end = System.currentTimeMillis();
        log.info("耗时：{} ms", (end-start));
        return arrayC;
    }

    public static int[] mergeArrayByFor(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        int k = 0, i = 0, j = 0, count = 0;
        for (; i < a.length; i++) {
            for (; j < b.length; j++) {
                count ++;
                if(a[i] < b[j]){
                    c[k] = a[i];
                    k ++;
                    break;
                }else{
                    if(b[j] > c[k-1]){
                        c[k] = b[j];
                        k ++;
                    }
                }
            }
        }
        while (i < a.length) {
            count ++;
            c[k] = a[i];
            k++;
            i++;
        }
        while (j < b.length){
            count ++;
            c[k] = b[j] ;
            k++;
            j++;
        }
        log.debug("{}", count);
        return c;

    }


    /**
     * @description <p></p>
     * @param a 数组A
     * @param b 数组B
     * @return int[] 合并后并且排序的数组
     * @author heshiyuan
     * @date 2018/8/27 11:33
     */
    public static int[] mergeArray(int[] a, int[] b){
        int count = 0;
        int i, j, k, n, m;

        i = j = k = 0;
        n = a.length;m = b.length;
        int[] c = new int[n + m];
        while (i < n && j < m) {
            count ++;
            if (a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];
        }

        while (i < n){
            count ++;
            c[k++] = a[i++];
        }

        while (j < m){
            count ++;
            c[k++] = b[j++];
        }
        log.debug("{}", count);
        return c;
    }

    void mergearray(int[] a, int first, int mid, int last, int[] temp) {
        int i = first, j = mid + 1;
        int m = mid,   n = last;
        int k = 0;

        while (i <= m && j <= n)
        {
            if (a[i] <= a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while (i <= m)
            temp[k++] = a[i++];

        while (j <= n)
            temp[k++] = a[j++];

        for (i = 0; i < k; i++)
            a[first + i] = temp[i];
    }

    void mergesort(int[] a, int first, int last, int[] temp) {
        if (first < last)
        {
            int mid = (first + last) / 2;
            mergesort(a, first, mid, temp);    //左边有序
            mergesort(a, mid + 1, last, temp); //右边有序
            mergearray(a, first, mid, last, temp); //再将二个有序数列合并
        }
    }

    boolean MergeSort(int[] a, int n){
        int[] p = new int[n];
        if (p == null)
            return false;
        mergesort(a, 0, n - 1, p);
        return true;
    }
}
