package com.hsy.algorithm.ai0001.m2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ArraySumTest {

    @Test
    public void getSum() {
        log.debug(ArraySum.getSum(new int[]{1,2,3,4,5,6,7,8,9,10} , 15).toString());
    }
}