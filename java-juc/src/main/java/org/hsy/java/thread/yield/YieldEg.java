package org.hsy.java.thread.yield;

/**
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
            }
        });

        Thread b = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("B -----" + i);
                if(i % 10 == 0){
                    Thread.yield();
                }
            }
        });
        t.start();
        b.start();
        return 1;
    }
}
