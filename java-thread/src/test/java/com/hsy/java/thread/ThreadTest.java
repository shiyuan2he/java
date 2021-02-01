package com.hsy.java.thread;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @author heshiyuan
 * @date 2020/11/27 14:31
 */
public class ThreadTest {
    @Test
    public void testNewThread(){
        IntStream.range(1, 1000)
                .forEach(index -> new Runnable(){
                            @Override
                            public void run() {
                                while(true){
                                    System.out.println("dead loop");
                                }
                            }
                        }
                );
    }
    @Test
    public void testNewThread2(){
        for(int i = 0; i < 3000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        System.out.println("dead loop");
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testNewThread3(){
        while(true){
            System.out.println("dead loop " + (1000 + 2000));
        }
    }
}
