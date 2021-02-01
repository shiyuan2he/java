package com.hsy.algorithm.ai0001.m1;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.util.Arrays;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.algorithm.ai0001.s0002
 * @date 2018/8/25 11:46
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Slf4j
public class ArrayJoinTest{

    @Test
    public void doMethod(){
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8, 10};
//        log.debug(Arrays.toString(ArrayJoin.mergeArray(a, b)));
        log.debug(Arrays.toString(ArrayJoin.mergeArrayByFor(a, b)));
    }
}