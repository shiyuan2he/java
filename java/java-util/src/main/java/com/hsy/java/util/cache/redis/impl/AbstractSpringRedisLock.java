package com.hsy.java.util.cache.redis.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.util.cache.redis.impl
 * @date 2018/8/1 10:39
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public abstract class AbstractSpringRedisLock {
    private Logger logger = LoggerFactory.getLogger(getClass());
    // 泛型
    public abstract RedisTemplate<String, Object> getRedisTemplate();
    /**
     * @description <p>尝试获取redis锁</p>
     * @param key 键
     * @param expireTime 过期时间
     * @return 是否成功获取redis锁
     * @author heshiyuan
     * @date 2018/8/1 11:05
     */
    public boolean tryLock(String key, long expireTime){
        RedisConnection connection = getRedisTemplate().getConnectionFactory().getConnection();
//        connection.multi();
        if (connection.setNX(key.getBytes(), "this is lock".getBytes())){
            connection.expire(key.getBytes(), expireTime);
//            connection.exec();
            return true;
        }else{
            return false;
        }
    }
    /**
     * @description <p>释放redis锁</p>
     * @param key 键
     * @return 释放锁
     * @author heshiyuan
     * @date 2018/8/1 11:11
     */
    public boolean releaseLock(String key){
        try {
            RedisConnection connection = getRedisTemplate().getConnectionFactory().getConnection();
            connection.del(key.getBytes());
            return true;
        }catch (Exception e){
            logger.error("{}", e);
            return false;
        }
    }
}
