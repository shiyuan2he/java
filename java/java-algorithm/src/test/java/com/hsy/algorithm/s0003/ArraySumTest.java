package com.hsy.algorithm.s0003;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;
@Slf4j
public class ArraySumTest {

    @Test
    public void getSum() {
        log.debug(ArraySum.getSum(new int[]{1,2,3,4,5,6,7,8,9,10} , 15).toString());
    }
}