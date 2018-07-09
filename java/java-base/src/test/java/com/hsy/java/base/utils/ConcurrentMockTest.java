package com.hsy.java.base.utils;

import com.hsy.java.base.temp.Common;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.java.base.temp
 * @date 2018/4/12 15:40
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ConcurrentMockTest extends ConcurrentMock {

    @Test
    public void testMain() throws InterruptedException {
        execute();
    }

    public void testThreadLocal(int i) {
        //Common.testThreadLocal = new ThreadLocal<>();
        int aaa = RandomHelper.generateRandomByLength(2);
        Object[] objects = new Object[10];
        objects[0] = i + aaa;
        objects[1] = i + aaa;
        objects[2] = i + aaa;
        objects[3] = i + aaa;
        objects[4] = i + aaa;

        Common.testThreadLocal = new ThreadLocal<Object[]>() {
            @Override
            protected Object[] initialValue() {
                return objects;
            }
        };
        //Common.testThreadLocal.set(objects);

        Object[] objects2 = Common.testThreadLocal.get();
        objects2[5] = i + aaa +1;
        objects2[6] = i + aaa +1;
        objects2[7] = i + aaa +1;
        objects2[8] = i + aaa +1;
        objects2[9] = i + aaa +1;
        Common.testThreadLocal.set(objects2);

        Object[] array = Common.testThreadLocal.get() ;
        System.out.println(Arrays.toString(array));
    }

    @Override
    public int getConcurrentNo() {
        return 100;
    }

    @Override
    public void doMethod() {
        for (int i = 0; i < 10; i++) {
            testThreadLocal(i);
        }
    }

    @Override
    public int getSleepTime() {
        return 10000;
    }
}
