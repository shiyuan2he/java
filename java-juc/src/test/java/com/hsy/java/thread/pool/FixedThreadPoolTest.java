package org.hsy.java.thread.pool;

import org.hsy.java.thread.pool.FixedThreadPool;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.thread.pool
 * @date 2018/7/17 17:21
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class FixedThreadPoolTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void testFixedThreadPool(){
       /* String threadName = UUID.randomUUID().toString().replace("-", "");
        Thread.currentThread().setName(threadName);*/
        for (int i = 0; i < 10; i++) {
            FixedThreadPool.getInstince(3).getFixedThreadPool().submit(new Runnable() {
                @Override
                public void run() {
                    logger.info("{}线程内部", Thread.currentThread().getName());
                }
            });
        }
        logger.info("{}线程外部", Thread.currentThread().getName());
    }
}