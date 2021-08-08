package org.hsy.java.juc.c_synchronized;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @date 2021/7/23 11:10
 */
public class ZhuanZhuanTest {
    ZhuanZhuan zz = new ZhuanZhuan();
    @Test
    public void getNumber() throws InterruptedException {
        new Thread(() -> {
            try {
                zz.getNumber();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zz.addNumber();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(10_000);
    }
}