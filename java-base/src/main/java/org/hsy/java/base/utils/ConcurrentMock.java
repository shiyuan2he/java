package org.hsy.java.base.utils;
import org.hsy.java.thread.pool.FixedThreadPool;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.java.base.utils
 * @date 2018/1/29 15:55
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Slf4j
public abstract class ConcurrentMock {
    /**
     * @description <p>并发模拟</p>
     * @author heshiyuan
     * @date 2018/1/29 15:58
     */
     public void execute() throws InterruptedException {
        // 并发数
        int concurrencyNumber = getConcurrentNo() ;
        final CountDownLatch latch = new CountDownLatch(1);
        final CountDownLatch latch2 = new CountDownLatch(10);
        for (int i = 0; i < concurrencyNumber; i++) {
            FixedThreadPool.getInstince(10).getFixedThreadPool().submit(()->{
                try {
                    log.info("线程{}到达闸门",Thread.currentThread().getName());
                    latch2.countDown();
                    latch.await();
                    doMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        latch2.await();
        log.info("开闸，线程抢占开始");
        latch.countDown();
        if(0 != getSleepTime()){
            Thread.sleep(getSleepTime());
        }else{
            Thread.sleep(10000);
        }
        log.info("所有线程执行完毕...");
    }

    /**
     * @description <p>获取并发数</p>
     * @return 并发数量
     * @author heshiyuan
     * @date 2018/1/29 15:56
     */
    public abstract int getConcurrentNo() ;
    /**
     * @description <p>被执行的方法体</p>
     * @author heshiyuan
     * @date 2018/1/29 16:04
     */
    public abstract void doMethod() throws InterruptedException;
    /**
     * @description <p>获取主线程休眠时间</p>
     * @return 主线程休眠时间
     * @author heshiyuan
     * @date 2018/1/29 16:06
     */
    public abstract int getSleepTime() ;
}
