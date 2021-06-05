package org.hsy.java.thread.sleep;

/**
 * @author heshiyuan
 * @date 2021/6/5 14:10
 */
public class SleepEg {
    public int testSleep(){
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A -----" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread b = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
            System.out.println("B -----" + i);
                try {
                    Thread.sleep(1000);
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
