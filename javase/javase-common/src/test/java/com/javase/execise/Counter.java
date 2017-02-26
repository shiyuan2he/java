package com.javase.execise;

import static org.junit.Assert.*;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.junit.Test;

/**
 * @description <p>请在此处输入类的描述</p>
 * @path javase-common/com.javase.execise
 * @time 2017年2月25日 下午2:50:58
 * @github 
 *     http://github.com/shiyuan2he
 * @author shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class Counter {

	public volatile static int count = 0;
    @Test
    public void testCount() {
        //同时启动1000个线程，去进行i++计算，看看实际结果
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                	 //这里延迟1毫秒，使得结果明显
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {}
                    count++;
                }
            }).start();
        }
        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("预期结果：1000；运行结果:Counter.count=" + Counter.count);
    }

}

