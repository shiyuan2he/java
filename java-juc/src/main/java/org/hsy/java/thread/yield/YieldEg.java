package org.hsy.java.thread.yield;

import java.util.concurrent.TimeUnit;

/**
 * yield() 让线程从 Running （执行状态）进入 Runnable 就绪状态
 * @author heshiyuan
 * @date 2021/6/5 14:00
 */
public class YieldEg {

    public int testYield(){
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A -----" + i);
                if(i % 10 == 0){
                    Thread.yield();
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread b = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("B -----" + i);
                if(i % 10 == 0){
                    Thread.yield();
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        b.start();
        return 1;
    }
}
