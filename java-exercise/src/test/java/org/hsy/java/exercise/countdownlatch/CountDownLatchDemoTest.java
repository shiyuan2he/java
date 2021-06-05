package org.hsy.java.exercise.countdownlatch;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.exercise.countdownlatch
 * @date 2018/1/24 13:34
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class CountDownLatchDemoTest {
    private static final Logger _logger = LoggerFactory.getLogger(CountDownLatchDemoTest.class) ;
    public static Integer haveSendMsgCount = 0 ;
    AtomicInteger atomicInteger = new AtomicInteger(0) ;
    @Test
    public void testCountDownLatch() throws Exception {
        final CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(){
                public void run() {
                    try {
                        System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                        latch.await();
                        Thread.sleep(3000);
                        System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            if(i == 2){
                _logger.info("开闸");
            }
            latch.countDown();
        }
        Thread.sleep(6000);
        System.out.println("等待2个子线程执行完毕...");
    }

    @Test
    public void testSendMsg() throws Exception {

        // 并发数
        int concurrencyNumber = 10 ;
        final CountDownLatch latch = new CountDownLatch(1);
        final CountDownLatch latch2 = new CountDownLatch(concurrencyNumber);
        for (int i = 0; i < concurrencyNumber; i++) {
            new Thread(){
                public void run() {
                    try {
                        _logger.info("线程{}到达闸门",Thread.currentThread().getName());
                        latch2.countDown();
                        latch.await();
                        _logger.info("线程{}正在发短信",Thread.currentThread().getName());
                        //threadSafeSynch();
                        threadSafeAtomic();
                        notThreadSafeCount() ;
                        _logger.info("短信发送完毕");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                private void notThreadSafeCount() {
                    _logger.info("当前已发送短信{}条",haveSendMsgCount);
                    if(haveSendMsgCount < 3){
                        _logger.info("小于3条可以发短信，线程{}允许发短信-----------------------------------------",Thread.currentThread().getName());
                        haveSendMsgCount ++ ;
                    }
                }

                private void threadSafeAtomic() {
                    _logger.info("当前已发送短信{}条",atomicInteger.intValue());
                    if(atomicInteger.getAndIncrement() < 3){
                        if(haveSendMsgCount < 3){
                            _logger.info("小于3条可以发短信，线程{}允许发短信-----------------------------------------",Thread.currentThread().getName());
                        }
                    }
                }

                private void threadSafeSynch() {
                    _logger.info("当前已发送短信{}条",haveSendMsgCount);
                    synchronized (haveSendMsgCount){
                        if(haveSendMsgCount < 3){
                            _logger.info("小于3条可以发短信，线程{}允许发短信-----------------------------------------",Thread.currentThread().getName());
                            haveSendMsgCount ++ ;
                        }
                    }
                }
            }.start();

        }
        latch2.await();
        _logger.info("开闸，群发短信");
        latch.countDown();
        Thread.sleep(5000);
        _logger.info("所有线程执行完毕...");
    }

}