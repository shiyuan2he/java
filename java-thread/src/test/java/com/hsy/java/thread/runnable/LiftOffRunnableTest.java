package com.hsy.java.thread.runnable;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.thread.runnable
 * @date 2018/7/19 15:00
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class LiftOffRunnableTest {

    @Test
    public void run() {
        LiftOffRunnable liftOffRunnable = new LiftOffRunnable();
        liftOffRunnable.run();
    }

    @Test
    public void runThread(){
        int count = 5 ;
        while (count --> 0){
            new Thread(new LiftOffRunnable()).start();
        }
    }
}