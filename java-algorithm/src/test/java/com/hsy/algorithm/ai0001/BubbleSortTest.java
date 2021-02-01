package com.hsy.algorithm.ai0001;

import com.hsy.algorithm.utils.SortUtils;
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
        logger.info("最终结果：{}", BubbleSort.bubbleSort(SortUtils.generateRandomNumber(100)));
        logger.info("最终结果：{}", BubbleSort.bubbleSort(SortUtils.generateNumberByDesc(100)));
        logger.info("最终结果：{}", BubbleSort.bubbleSort(SortUtils.generateNumberByASC(100)));
    }
    @Test
    public void twoWayBubbleSort() {
        logger.info("最终结果：{}", BubbleSort.twoWayBubbleSort(SortUtils.generateNumberByASC(100)));
        logger.info("最终结果：{}", BubbleSort.twoWayBubbleSort(SortUtils.generateNumberByDesc(100)));
        logger.info("最终结果：{}", BubbleSort.twoWayBubbleSort(SortUtils.generateRandomNumber(100)));
    }
}