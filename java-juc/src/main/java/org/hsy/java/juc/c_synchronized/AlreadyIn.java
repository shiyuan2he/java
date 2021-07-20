package org.hsy.java.juc.c_synchronized;

/**
 * @author heshiyuan
 * @date 2021/6/5 14:51
 */
public class AlreadyIn {


    public synchronized int m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        m3("already in...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end");
        return 1;
    }
    public synchronized int m3(String idr) {
        System.out.println(Thread.currentThread().getName() + idr +  " m3 start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m3 end");
        return 1;
    }
}
