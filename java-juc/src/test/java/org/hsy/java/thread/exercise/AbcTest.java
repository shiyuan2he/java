package org.hsy.java.thread.exercise;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author heshiyuan
 * @date 2021/6/5 11:40
 */
public class AbcTest {
    /**
     * 三个线程，轮流输出 a,b,c
     */
    @Test
    public void printAbc() throws InterruptedException {
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
}