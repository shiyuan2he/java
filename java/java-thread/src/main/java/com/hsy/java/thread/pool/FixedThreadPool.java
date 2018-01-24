package com.hsy.java.thread.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author heshiyuan
 * @description <p>
 *     a.闯将一个固定长度的线程池，每当提交一个任务是就创建一个线程
 *       直到达到线程池的最大线程，这时线程池的规模将不再发生变化，如果
 *       某个线程由于发生了未预期的Exception而结束，那么线程池会补充一个新线程
 *     b.可重用固定线程数的线程池
 *       以共享的无界队列方式来运行这些线程。在任意点，
 *       在大多数 nThreads 线程会处于处理任务的活动状态。
 *       如果在所有线程处于活动状态时提交附加任务，则在有可用线程之前，
 *       附加任务将在队列中等待。如果在关闭前的执行期间由于失败而导致任何线程终止，
 *       那么一个新线程将代替它执行后续的任务（如果需要）。在某个线程被显式地关闭之前，
 *       池中的线程将一直存在。
 *      </p>
 * @date 23/08/2017 5:01 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class FixedThreadPool {
    private static final Logger _logger = LoggerFactory.getLogger(FixedThreadPool.class);
    volatile private static FixedThreadPool instance ;

    volatile private ExecutorService fixedThreadPool;
    private final int poolSize = 50 ;

    private FixedThreadPool() {
        ExecutorService result = fixedThreadPool ;
        if(null == result) {
            synchronized (ExecutorService.class) {
                result = fixedThreadPool;
                if (null == result) {
                    _logger.info("正在初始化一个({})线程数的线程池：", poolSize);
                    this.fixedThreadPool = Executors.newFixedThreadPool(poolSize, new ThreadFactory() {

                        SecurityManager s = System.getSecurityManager();
                        // 添加线程组
                        private final ThreadGroup group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();

                        private final AtomicInteger poolNumber = new AtomicInteger(1);
                        private final AtomicInteger threadNumber = new AtomicInteger(1);
                        private final String namePrefix = "fixedThreadPool-" + poolNumber.getAndIncrement() + "-thread-";

                        public Thread newThread(Runnable runnable) {
                            _logger.info("正在new一个线程，线程(ID:{})：", namePrefix + threadNumber.intValue());
                            // 线程池新线程
                            Thread thread = new Thread(group, runnable,namePrefix + threadNumber.getAndIncrement(), 0);
                            if (thread.isDaemon()) thread.setDaemon(false);
                            if (thread.getPriority() != Thread.NORM_PRIORITY) thread.setPriority(Thread.NORM_PRIORITY);
                            return thread ;
                        }
                    });
                }
            }
        }
    }

    private FixedThreadPool(int threadPoolNum) {
        ExecutorService result = fixedThreadPool ;
        if(null == result) {
            synchronized (ExecutorService.class) {
                result = fixedThreadPool;
                if (null == result) {
                    _logger.info("正在初始化一个({})线程数的线程池：", threadPoolNum);
                    this.fixedThreadPool = Executors.newFixedThreadPool(threadPoolNum, new ThreadFactory() {

                        SecurityManager s = System.getSecurityManager();
                        // 添加线程组
                        private final ThreadGroup group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();

                        private final AtomicInteger poolNumber = new AtomicInteger(1);
                        private final AtomicInteger threadNumber = new AtomicInteger(1);
                        private final String namePrefix = "fixedThreadPool-" + poolNumber.getAndIncrement() + "-thread-";

                        public Thread newThread(Runnable runnable) {
                            _logger.info("正在new一个线程，线程(ID:{})：", namePrefix + threadNumber.intValue());
                            // 线程池新线程
                            Thread thread = new Thread(group, runnable,namePrefix + threadNumber.getAndIncrement(), 0);
                            if (thread.isDaemon()) thread.setDaemon(false);
                            if (thread.getPriority() != Thread.NORM_PRIORITY) thread.setPriority(Thread.NORM_PRIORITY);
                            return thread ;
                        }
                    });
                }
            }
        }
    }

    /**
     * 双锁保证线程池对象单例
     * @return
     */
    public static FixedThreadPool getInstince(){
        FixedThreadPool result = instance ;
        // 如果是null就锁类并实例化
        if(null == result){
            /**
             * 锁类并再次判断实例是否为空，否则new
             */
            synchronized (FixedThreadPool.class){
                result = instance ;
                if(null == result){
                    _logger.info("正在new一个FixedThreadPool对象");
                    result = instance = new FixedThreadPool();
                }
            }
        }
        return result ;
    }
    public static FixedThreadPool getInstince(int poolSize){
        FixedThreadPool result = instance ;
        // 如果是null就锁类并实例化
        if(null == result){
            /**
             * 锁类并再次判断实例是否为空，否则new
             */
            synchronized (FixedThreadPool.class){
                result = instance ;
                if(null == result){
                    _logger.info("正在new一个FixedThreadPool对象，参数poolSize({})");
                    result = instance = new FixedThreadPool(poolSize);
                }
            }
        }
        return result ;
    }

    public ExecutorService getFixedThreadPool() {
        return fixedThreadPool;
    }
}
