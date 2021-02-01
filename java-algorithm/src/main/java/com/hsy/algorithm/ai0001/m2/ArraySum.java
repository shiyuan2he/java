package com.hsy.algorithm.ai0001.m2;

import java.util.HashMap;
import java.util.Map;

public class ArraySum {

    public static Map<Integer, Integer> getSum(int[] array, int m){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i] < array[j] && array[i] + array[j] == m){
                    map.put(array[i], array[j]);
                }
            }
        }
        return map;
    }
}
