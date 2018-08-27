package com.hsy.algorithm.s0002;

import com.hsy.java.base.utils.ConcurrentMock;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.algorithm.s0002
 * @date 2018/8/25 11:46
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ArrayJoinTest extends ConcurrentMock{
    private static final Logger logger = LoggerFactory.getLogger(ArrayJoinTest.class);
    @Test
    public void join() throws InterruptedException {
        execute();
    }

    @Override
    public int getConcurrentNo() {
        return 1;
    }

    @Override
    public void doMethod() throws InterruptedException {
        logger.info(Arrays.toString(ArrayJoin.joinOfJdk(new int[]{1, 3, 3, 5}, new int[]{2, 3, 3, 3, 3, 3, 10})));
//        logger.info(Arrays.toString(ArrayJoin.joinOfJdk(new int[]{2, 3, 3, 3, 3, 3, 10}, new int[]{1, 3, 3, 3, 5})));
//        logger.info(Arrays.toString(ArrayJoin.joinOfJdk(new int[]{}, new int[]{1, 3, 3, 3, 5})));
//        logger.info(Arrays.toString(ArrayJoin.joinOfJdk(new int[]{2, 3, 3, 3, 3, 3, 10}, new int[]{})));
//        logger.info(Arrays.toString(ArrayJoin.joinOfJdk(null, new int[]{1, 3, 3, 3, 5})));
//        logger.info(Arrays.toString(ArrayJoin.joinOfJdk(new int[]{2, 3, 3, 3, 3, 3, 10}, null)));
        logger.info("----------------");
    }

    @Override
    public int getSleepTime() {
        return 1000 * 5;
    }
}