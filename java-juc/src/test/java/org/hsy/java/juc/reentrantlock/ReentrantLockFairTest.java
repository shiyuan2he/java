package org.hsy.java.juc.reentrantlock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @date 2021/6/7 17:38
 */
public class ReentrantLockFairTest {
    ReentrantLockFair fair = new ReentrantLockFair();
    @Test
    public void lockFair() throws InterruptedException {
        new Thread(fair::lockFair).start();
        new Thread(fair::lockFair).start();
        TimeUnit.MINUTES.sleep(1);
    }
}