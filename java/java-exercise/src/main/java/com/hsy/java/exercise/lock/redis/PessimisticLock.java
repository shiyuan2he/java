package com.hsy.java.exercise.lock.redis;

import com.hsy.java.exercise.lock.dao.TStockDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.exercise.lock
 * @date 2018/7/31 23:01
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class PessimisticLock{
    private Logger logger = LoggerFactory.getLogger(getClass());
    TStockDaoImpl stockDao = new TStockDaoImpl();
    public void doLock(){
        Jedis redis = RedisUtils.getInstance().getJedis();

        String key = "lock" ;
        while (true){
            long count = redis.setnx(key, "this is lock");
            if (count > 0) {// 设置成功
                logger.info("拿到锁");
                if (stockDao.getCount(1l) > 0) {
                    // 减库存
                    stockDao.reduce();
                    redis.del(key);
                }else{
                    logger.info("库存不足");
                    break;
                }
            } else {
                logger.info("没有拿到锁");
            }
        }
    }
}
