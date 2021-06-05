package org.hsy.java.base.utils;
import org.hsy.java.base.utils.ConcurrentMock;
import org.junit.Test;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.java.base.temp
 * @date 2018/4/12 15:40
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ConcurrentMockTest extends ConcurrentMock {
    public static ThreadLocal<Integer> testThreadLocal = new ThreadLocal<>();

    @Test
    public void testMain() throws InterruptedException {
        execute();
    }

    @Override
    public int getConcurrentNo() {
        return 100;
    }

    @Override
    public void doMethod() {

    }

    @Override
    public int getSleepTime() {
        return 10000;
    }
}
