package org.hsy.java.juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author heshiyuan
 * @date 2021/6/7 20:04
 */
public class C_CyclicBarrier {
    private CyclicBarrier barrier = new CyclicBarrier(20, () -> System.out.println("20满了"));

    public void cyclicBarrier(){
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
