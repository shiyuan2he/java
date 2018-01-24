package com.hsy.java.exercise.volatiles;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.exercise.volatiles
 * @date 2018/1/23 14:35
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class CounterTest {
    private static final Logger _logger = LoggerFactory.getLogger(CounterTest.class) ;
    volatile int countValue = 0 ;
    int count = 0;

    @Test
    public void testVolatile() throws InterruptedException {

        Counter counter = new Counter() ;
        AtomicInteger atomicInteger = new AtomicInteger(0) ;

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                for(int j=0;j<10;j++){
                    count ++ ;
                    counter.increment();
                    atomicInteger.incrementAndGet();
                    countValue ++ ;
                }
            }).start();
        }

        Thread.sleep(15000);

        _logger.info("count==>",count);
        _logger.info("counter==>",counter.getCount());
        _logger.info("atomicInteger==>",atomicInteger.intValue());
        _logger.info("countValue==>",countValue);
    }
}