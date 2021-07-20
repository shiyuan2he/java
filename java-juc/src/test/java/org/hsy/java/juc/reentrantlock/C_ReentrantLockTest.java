package org.hsy.java.juc.reentrantlock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @date 2021/6/7 16:37
 */
public class C_ReentrantLockTest {
    C_ReentrantLock lock = new C_ReentrantLock();

    /**
     * 同一把锁，有竞争
     * @throws InterruptedException
     */
    @Test
    public void m1() throws InterruptedException {
        new Thread(lock::m1).start();
        new Thread(lock::m1).start();
        TimeUnit.MINUTES.sleep(2);
    }

    /**
     * 仍是同一个实例，同一把锁
     * @throws InterruptedException
     */
    @Test
    public void m2() throws InterruptedException {
        new Thread(lock::m1).start();
        new Thread(lock::m2).start();
        TimeUnit.MINUTES.sleep(2);
    }

    /**
     * 没有竞争关系
     * @throws InterruptedException
     */
    @Test
    public void m3() throws InterruptedException {
        C_ReentrantLock lock2 = new C_ReentrantLock();
        new Thread(lock::m1).start();
        new Thread(lock2::m2).start();
        TimeUnit.MINUTES.sleep(1);
    }

    @Test
    public void test3() throws InterruptedException {
        new Thread(lock::m1).start();
        TimeUnit.SECONDS.sleep(10);
        new Thread(lock::m3).start();
        TimeUnit.MINUTES.sleep(1);
    }
}