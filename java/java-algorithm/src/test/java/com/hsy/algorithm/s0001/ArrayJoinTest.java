package com.hsy.algorithm.s0001;

import com.hsy.java.base.utils.ConcurrentMock;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.algorithm.s0001
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
//        logger.info(Arrays.toString(ArrayJoin.join(new int[]{1, 4, 2, 0}, new int[]{3, 10, 43}, null)));
        logger.info(Arrays.toString(ArrayJoin.join(new int[]{1, 4, 2, 0}, null, null)));
        logger.info("----------------");
    }

    @Override
    public int getSleepTime() {
        return 1000 * 10;
    }
}