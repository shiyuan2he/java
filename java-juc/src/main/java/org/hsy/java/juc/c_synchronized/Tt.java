package org.hsy.java.juc.c_synchronized;

/**
 * @author heshiyuan
 * @date 2021/6/5 14:43
 */
public class Tt {

    public synchronized int m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end");
        return 1;
    }

    public int m2() {
        System.out.println(Thread.currentThread().getName() + " m2 ");
        return 1;
    }

    public synchronized int m3() {
        System.out.println(Thread.currentThread().getName() + " m3 start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m3 end");
        return 1;
    }

    public int m4() {
        synchronized (Tt.class){
            System.out.println(Thread.currentThread().getName() + " m4 start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " m4 end");
        }
        return 1;
    }
    public int m5() {
        synchronized (Tt.class){
            System.out.println(Thread.currentThread().getName() + " m5 start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " m5 end");
        }
        return 1;
    }
    private Object lock = new Object();
    public int m6() {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName() + " m6 start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " m6 end");
        }
        return 1;
    }
}
