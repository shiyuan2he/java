package org.hsy.java.thread.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author heshiyuan
 * @description <p>
 *     创建一个固定长度的线程池，而且以延迟或定时的方式来执行任务，类似于Timer
 *     支持定时及周期性任务执行
 * </p>
 * @path java/org.hsy.java.thread.pool
 * @date 11/10/2017 4:28 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ScheduledThreadPool {
    private static final Logger _logger = LoggerFactory.getLogger(ScheduledThreadPool.class) ;
    volatile private static ScheduledThreadPool instance = null;
    volatile private ScheduledExecutorService scheduledThreadPool ;
    private final int poolSize = 50 ;

    private ScheduledThreadPool(){
        ScheduledExecutorService result = scheduledThreadPool;
        if(null == result){
            synchronized (ScheduledExecutorService.class){
                result = scheduledThreadPool ;
                if(null == result){
                    _logger.info("正在初始化一个({})线程数的线程池：", poolSize);
                    // 1个线程的固定数量线程池
                    this.scheduledThreadPool = Executors.newScheduledThreadPool(poolSize);
                }
            }
        }
    }
    private ScheduledThreadPool(int poolSize){
        ScheduledExecutorService result = scheduledThreadPool;
        if(null == result){
            synchronized (ScheduledExecutorService.class){
                result = scheduledThreadPool ;
                if(null == result){
                    _logger.info("正在初始化ScheduledThreadPool的线程池：", poolSize);
                    // 1个线程的固定数量线程池
                    this.scheduledThreadPool = Executors.newScheduledThreadPool(poolSize);
                }
            }
        }
    }

    /**
     * ScheduledThreadPool池子单例
     * @return
     */
    public static ScheduledThreadPool getInstance(){
        ScheduledThreadPool result = instance;
        if(null == result){
            synchronized (ScheduledThreadPool.class){
                result = instance ;
                if(null == result){
                    result = instance = new ScheduledThreadPool() ;
                }
            }
        }
        return result ;
    }
    public static ScheduledThreadPool getInstance(int poolSize){
        ScheduledThreadPool result = instance;
        if(null == result){
            synchronized (ScheduledThreadPool.class){
                result = instance ;
                if(null == result){
                    result = instance = new ScheduledThreadPool(poolSize) ;
                }
            }
        }
        return result ;
    }
    /**
     * @description <p>获取线程池</p>
     * @return 可调度的线程池
     * @author heshiyuan
     * @date 2018/1/29 15:39
     */
    public ExecutorService getScheduledThreadPool() {
        return scheduledThreadPool;
    }
}
