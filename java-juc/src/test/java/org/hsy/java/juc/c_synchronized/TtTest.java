package org.hsy.java.juc.c_synchronized;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 验证sychronized的锁范围
 * @author heshiyuan
 * @date 2021/6/5 14:44
 */
public class TtTest {
    Tt t = new Tt();
    @Test
    public void m1() throws InterruptedException {
        new Thread(t::m3).start();
        new Thread(t::m2).start();
//        new Thread(t::m1).start();
        new Thread(t::m4).start();
        new Thread(t::m5).start();
        TimeUnit.MINUTES.sleep(2);
    }

    @Test
    public void m2() throws InterruptedException {
        new Thread(t::m6).start();
        new Thread(t::m6).start();
        new Thread(t::m6).start();
        Tt tt = new Tt();
        new Thread(tt::m6).start();
        TimeUnit.MINUTES.sleep(1);
    }

    @Test
    public void m3() throws InterruptedException {
        new Thread(t::m1).start();
        new Thread(t::m4).start();
        TimeUnit.MINUTES.sleep(1);
    }
}