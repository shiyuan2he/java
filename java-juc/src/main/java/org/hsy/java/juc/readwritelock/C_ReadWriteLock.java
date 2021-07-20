package org.hsy.java.juc.readwritelock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author heshiyuan
 * @date 2021/6/9 16:30
 */
public class C_ReadWriteLock {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock){
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("read over");
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock){
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("write over");
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
//        Runnable readR = () -> read(reentrantLock);
//        Runnable writeR = () -> write(reentrantLock);

        Runnable readR = () -> read(readLock);
        Runnable writeR = () -> write(writeLock);

        for (int i = 0; i < 20; i++) {
            new Thread(readR).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(writeR).start();
        }
    }
}
