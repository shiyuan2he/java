package org.hsy.java.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author heshiyuan
 * @date 2021/6/7 19:00
 */
public class C_CountDownLatch {

    public void usingCountDownLatch() {
        CountDownLatch latch = new CountDownLatch(100);

        for(int i=0; i<100; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " 准备");
                try {
                    latch.await();
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + " 结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            latch.countDown();
            if(i==99){
                System.out.println("开闸");
            }
        }
    }
}
