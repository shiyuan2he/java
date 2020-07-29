package com.hsy.java.exercise.lock.db;

import com.hsy.java.base.utils.ConcurrentMock;
import org.junit.Test;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.exercise.lock.db
 * @date 2018/8/2 16:31
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class OptimisticLockTest extends ConcurrentMock {
    private OptimisticLock optimisticLock = new OptimisticLock();
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
        optimisticLock.lockService();
    }

    @Override
    public int getSleepTime() {
        return 100 * 1000;
    }
}