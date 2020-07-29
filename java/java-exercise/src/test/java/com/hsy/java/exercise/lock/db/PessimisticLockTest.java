package com.hsy.java.exercise.lock.db;

import com.hsy.java.base.utils.ConcurrentMock;
import org.junit.Test;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.exercise.lock.db
 * @date 2018/8/3 9:29
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class PessimisticLockTest extends ConcurrentMock {

    @Test
    public void lockService() throws InterruptedException {
        execute();
    }

    @Override
    public int getConcurrentNo() {
        return 100;
    }

    @Override
    public void doMethod() throws InterruptedException {
        PessimisticLock pessimisticLock = new PessimisticLock();
        pessimisticLock.lockService();
    }

    @Override
    public int getSleepTime() {
        return 10 * 1000;
    }
}