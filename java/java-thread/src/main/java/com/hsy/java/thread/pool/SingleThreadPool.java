package com.hsy.java.thread.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author heshiyuan
 * @description <p>
 *     创建单个工作者来执行任务，如果这个线程异常结束，会创建另一个线程来代替
 *     能确保依照任务在队列中的顺序来串行执行
 * </p>
 * @path java/com.hsy.java.thread.pool
 * @date 11/10/2017 4:26 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class SingleThreadPool {
    private static final Logger _logger = LoggerFactory.getLogger(SingleThreadPool.class) ;
    volatile private static SingleThreadPool instance = null;
    volatile private ExecutorService singleThreadPool ;

    private SingleThreadPool(){
        ExecutorService result = singleThreadPool;
        if(null == result){
            synchronized (ExecutorService.class){
                result = singleThreadPool ;
                if(null == result){
                    //this.singleThreadPool = Executors.newSingleThreadExecutor() ;
                    // 1个线程的固定数量线程池
                    this.singleThreadPool = FixedThreadPool.getInstince(1).getFixedThreadPool() ;
                }
            }
        }
    }

    /**
     * SingleThreadPool池子单例
     * @return
     */
    public static SingleThreadPool getInstance(){
        SingleThreadPool result = instance;
        if(null == result){
            synchronized (SingleThreadPool.class){
                result = instance ;
                if(null == result){
                    result = instance = new SingleThreadPool() ;
                }
            }
        }
        return result ;
    }
    /**
     * @description <p>获取线程池</p>
     * @return 单线程的线程池
     * @author heshiyuan
     * @date 2018/1/29 15:13
     */
    public ExecutorService getSingleThreadPool() {
        return singleThreadPool;
    }
}
