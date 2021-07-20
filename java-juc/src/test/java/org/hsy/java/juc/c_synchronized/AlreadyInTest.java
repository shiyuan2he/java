package org.hsy.java.juc.c_synchronized;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @date 2021/6/5 14:52
 */
public class AlreadyInTest {
    AlreadyIn in = new AlreadyIn();

    /**
     * 相同的实例，存在锁竞争
     * @throws InterruptedException
     */
    @Test
    public void alreadyIn() throws InterruptedException {
        new Thread(() -> in.m3("out in")).start();
        new Thread(in::m1).start();
        new Thread(in::m1).start();
        new Thread(in::m1).start();
        TimeUnit.MINUTES.sleep(2);
    }

    /**
     * 不通的实例，无竞争关系
     * @throws InterruptedException
     */
    @Test
    public void alreadyIn2() throws InterruptedException {
        AlreadyIn in2 = new AlreadyIn();
        new Thread(in2::m1).start();
        AlreadyIn in3 = new AlreadyIn();
        new Thread(in3::m1).start();
        AlreadyIn in4 = new AlreadyIn();
        new Thread(in4::m1).start();
        TimeUnit.MINUTES.sleep(2);
    }
}