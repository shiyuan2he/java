package org.hsy.java.juc.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author heshiyuan
 * @date 2021/6/7 16:31
 */
public class C_ReentrantLock {
    // 默认非公平锁
    Lock lock = new ReentrantLock();

    public int m1(){
        lock.lock();
        try{
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("m1 + " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return 1;
    }

    public int m2(){
        lock.lock();
        try{
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("m2 + " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return 1;
    }

    public int m3(){
        boolean flag = false;
        try{
            flag = lock.tryLock(3, TimeUnit.SECONDS);
            if(flag){
                for (int i = 0; i < 10; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("m3 + " + i);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(flag){
                lock.unlock();
            }
        }
        return 1;
    }
}
