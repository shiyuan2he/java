package org.hsy.java.thread.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author heshiyuan
 * @description <p>
 *     创建一个可缓存的线程池，如果线程池的当前规模超过了处理需求时，那么将回收空闲的线程
 *     而当需求增加时，则可以添加新的线程，线程池的规模不存在任何限制
 *     如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * </p>
 * @path java/org.hsy.java.thread.pool
 * @date 11/10/2017 4:18 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class CachedThreadPool {
    private static final Logger _logger = LoggerFactory.getLogger(CachedThreadPool.class) ;
    volatile private static CachedThreadPool instance = null;
    volatile private ExecutorService cachedThreadPool ;

    private CachedThreadPool(){
        ExecutorService result = cachedThreadPool;
        if(null == result){
            synchronized (ExecutorService.class){
                result = cachedThreadPool ;
                if(null == result){
                    _logger.info("正在初始化CachedThreadPool的线程池：");
                    // 1个线程的固定数量线程池
                    this.cachedThreadPool = Executors.newCachedThreadPool();
                }
            }
        }
    }

    /**
     * CachedThreadPool池子单例
     * @return
     */
    public static CachedThreadPool getInstance(){
        CachedThreadPool result = instance;
        if(null == result){
            synchronized (CachedThreadPool.class){
                result = instance ;
                if(null == result){
                    result = instance = new CachedThreadPool() ;
                }
            }
        }
        return result ;
    }
    /**
     * @description <p>获取不定长可缓存重复执行的线程池</p>
     * @return 可缓存的线程池
     * @author heshiyuan
     * @date 2018/1/29 15:44
     */
    public ExecutorService getCachedThreadPool() {
        return cachedThreadPool;
    }
}
