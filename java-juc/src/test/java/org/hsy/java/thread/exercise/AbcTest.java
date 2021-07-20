package org.hsy.java.thread.exercise;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author heshiyuan
 * @date 2021/6/5 11:40
 */
public class AbcTest {
    /**
     * 三个线程，轮流输出 a,b,c
     */
    @Test
    public void printAbc1() throws InterruptedException {
        while (true){
            TimeUnit.SECONDS.sleep(1L);
            Thread b = new Thread(() -> {
                System.out.println("b");
            });
            Thread c = new Thread(() -> {
                System.out.println("c");
            });
            Thread a = new Thread(() -> {
                System.out.println("a");
            });
            a.start();
            a.join();
            TimeUnit.SECONDS.sleep(1L);
            b.start();
            b.join();
            TimeUnit.SECONDS.sleep(1L);
            c.start();
            c.join();
            System.out.println("------------");
            TimeUnit.SECONDS.sleep(1L);
        }
    }
    private Object lock = new Object();
    private AtomicInteger index = new AtomicInteger(0);
    private AtomicInteger count = new AtomicInteger(1);
    private AtomicInteger count2 = new AtomicInteger(1);
    private AtomicInteger count3 = new AtomicInteger(1);
    @Test
    public void printAbc2() throws InterruptedException {
        Thread a = new Thread(() -> {
            while(true){
                synchronized (lock) {
                    if (index.get() % 3 == 0) {
                        System.out.print(count.get());
                        index.incrementAndGet();
                        count.incrementAndGet();
                        lock.notifyAll();
                        if(count.get() > 26){
                            break;
                        }
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread b = new Thread(() -> {
            while(true){
                synchronized (lock) {
                    if (index.get() % 3 == 1) {
                        index.incrementAndGet();
                        System.out.print((char) (count2.get() + 96));
                        count2.incrementAndGet();
                        lock.notifyAll();
                        if(count2.get() > 26){
                            break;
                        }
                    } else {
                        try {
                            lock.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread c = new Thread(() -> {
            while(true){
                synchronized (lock) {
                    if (index.get() % 3 == 2) {
                        index.incrementAndGet();
                        System.out.println((char) (count3.get() + 64));
                        count3.incrementAndGet();
                        lock.notifyAll();
                        if(count3.get() > 26){
                            break;
                        }
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        a.start();
        b.start();
        c.start();
        Thread.sleep(1000 * 90);
    }

    private ReentrantLock reentrantLock = new ReentrantLock();
    @Test
    public void printAbc3() throws InterruptedException {
        Thread a = new Thread(() -> {
            while (true) {
                if (index.get() % 3 == 0) {
                    reentrantLock.lock();
                    System.out.print(count.get());
                    index.incrementAndGet();
                    count.incrementAndGet();
                    reentrantLock.unlock();
                    if (count.get() > 26) {
                        break;
                    }
                }
            }
        }
        );

        Thread b = new Thread(() -> {
            while (true) {
                if (index.get() % 3 == 1) {
                    reentrantLock.lock();
                    System.out.print((char) (count2.get() + 96));
                    index.incrementAndGet();
                    count2.incrementAndGet();
                    reentrantLock.unlock();
                    if (count2.get() > 26) {
                        break;
                    }
                }
            }
        });
        Thread c = new Thread(() -> {
            while(true){
                synchronized (lock) {
                    if (index.get() % 3 == 2) {
                        reentrantLock.lock();
                        System.out.println((char) (count3.get() + 64));
                        index.incrementAndGet();
                        count3.incrementAndGet();
                        reentrantLock.unlock();
                        if (count3.get() > 26) {
                            break;
                        }
                    }
                }
            }
        });

        a.start();
        b.start();
        c.start();
        Thread.sleep(1000 * 90);
    }
}