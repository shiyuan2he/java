package org.hsy.java.juc.c_synchronized;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author heshiyuan
 * @date 2021/6/9 17:24
 */
public class NotifyWaitLock {
    //添加volatile，使t2能够得到通知
    volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        Object lock = new Object();
        NotifyWaitLock lockObj = new NotifyWaitLock();
        new Thread(() -> {
            System.out.println("T1  start");
            synchronized (lock){
                if(lockObj.size() != 5){
                    try {
                        lock.wait();
                        System.out.println("5555555");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("T1  end");
        }).start();

        new Thread(() -> {
            System.out.println("T3  start");
            synchronized (lock){
                if(lockObj.size() != 5){
                    try {
                        lock.wait();
                        System.out.println("5555555");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("T3  end");
        }).start();

        new Thread(() -> {
            System.out.println("T2  start");
            synchronized (lock){
                for(int i=0; i<10; i++){
                    System.out.println("add " + i);
                    lockObj.add(i);
                    if(lockObj.size() == 5){
                        System.out.println("5555555");
                        // 唤醒所有等待的线程
                        lock.notifyAll();
                        // 只能唤醒一个等待线程
                        lock.notify();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("T2  end");
        }).start();
    }
}
