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
        Integer aaa = RandomHelper.generateRandomByLength(4);

        Common.testThreadLocal.set(aaa);
        if(!aaa.equals(Common.testThreadLocal.get())){
            System.out.println(aaa + "  " +Common.testThreadLocal.get());
        }else{
            System.out.println("一致");
        }
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
