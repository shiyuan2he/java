package com.hsy.java.exercise.lock.db;

import com.hsy.java.exercise.lock.dao.TLockDaoImpl;
import com.hsy.java.exercise.lock.dao.TStockDaoImpl;
import com.hsy.java.exercise.lock.redis.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * @author heshiyuan
 * @description <p>悲观锁</p>
 * @path java/com.hsy.java.exercise.lock
 * @date 2018/7/31 23:01
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class PessimisticLock {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private TLockDaoImpl lockDao = new TLockDaoImpl();
    TStockDaoImpl stockDao = new TStockDaoImpl();

    public void lockService(){
        String lock = "dbLock" ;
        if(lockDao.insert(lock,"数据库实现分布式锁")>0){
            logger.info("获取到数据库锁");
            if (stockDao.getCount(1l) > 0) {
                // 减库存
                stockDao.reduce();
            }
            lockDao.delete(lock);
        }else{
            logger.info("没有拿到锁，请求返回");
        }
    }
}
