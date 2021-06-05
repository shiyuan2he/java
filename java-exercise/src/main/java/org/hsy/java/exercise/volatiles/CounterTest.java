package org.hsy.java.exercise.volatiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.exercise.volatiles
 * @date 2018/1/23 14:52
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class CounterTest {
    private static final Logger _logger = LoggerFactory.getLogger(CounterTest.class) ;
    public static volatile int countValue = 0 ;
    public static int count = 0;
    public static Counter counter = new Counter() ;
    public static AtomicInteger atomicInteger = new AtomicInteger(0) ;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                count ++ ;
            }).start();
            new Thread(() -> {
                counter.increment();
            }).start();
            new Thread(() -> {
                atomicInteger.incrementAndGet();
            }).start();
            new Thread(() -> {
                countValue ++ ;
            }).start();
        }

        Thread.sleep(15000);

        _logger.info("count==>{}",count);
        _logger.info("counter==>{}",counter.getCount());
        _logger.info("atomicInteger==>{}",atomicInteger.intValue());
        _logger.info("countValue==>{}",countValue);
    }
}
