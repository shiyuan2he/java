package com.hsy.java.exercise.lock.zookeeper;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.exercise.lock.zookeeper
 * @date 2018/8/2 9:53
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class DistributedLockTest {
    static int n = 500;

    public static void secskill() {
        System.out.println(--n);
    }
    @Test
    public void testZookeeperLock() {
        Runnable runnable = new Runnable() {
            public void run() {
                DistributedLock lock = null;
                try {
                    lock = new DistributedLock("172.16.191.102:2181", "test1");
                    lock.lock();
                    secskill();
                    System.out.println(Thread.currentThread().getName() + "正在运行");
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}