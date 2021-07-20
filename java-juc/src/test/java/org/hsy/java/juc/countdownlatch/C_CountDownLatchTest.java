package org.hsy.java.juc.countdownlatch;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author heshiyuan
 * @date 2021/6/7 19:01
 */
public class C_CountDownLatchTest {
    C_CountDownLatch countDownLatch = new C_CountDownLatch();
    @Test
    public void countDownLatchTest() throws InterruptedException {
        countDownLatch.usingCountDownLatch();
        TimeUnit.SECONDS.sleep(10);
    }

    public static Integer haveSendMsgCount = 0 ;
    AtomicInteger atomicInteger = new AtomicInteger(0) ;
    @Test
    public void testCountDownLatch() throws Exception {
        final CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        System.out.println("子线程"+Thread.currentThread().getName()+"开始执行");
                        latch.await();
                        Thread.sleep(3000);
                        System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            if(i == 2){
                System.out.println("开闸");
            }
            latch.countDown();
        }
        Thread.sleep(6000);
        System.out.println("执行完毕...");
    }

}