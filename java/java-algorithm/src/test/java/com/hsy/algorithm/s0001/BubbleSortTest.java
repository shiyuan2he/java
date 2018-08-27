package com.hsy.algorithm.s0001;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.algorithm.s0001
 * @date 2018/8/27 16:43
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class BubbleSortTest {
    private static final Logger logger = LoggerFactory.getLogger(BubbleSortTest.class);
    @Test
    public void bubbleSort() {
//        BubbleSort.bubbleSort(new int[]{3, 2, 1});
        logger.info("最终结果：{}", BubbleSort.bubbleSort(new int[]{2, 1, 10, 4}));
    }
}