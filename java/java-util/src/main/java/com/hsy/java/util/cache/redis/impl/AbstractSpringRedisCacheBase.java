package com.hsy.java.util.cache.redis.impl;

import com.hsy.java.enums.CacheEnum;
import com.hsy.java.exception.cache.CacheException;
import com.hsy.java.util.cache.ICacheBase;
import com.hsy.java.util.serializer.SerializerHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author heshiyuan
 * @description <p>spring-data-redis缓存工具类</p>
 * @path java/com.hsy.java.util.cache.redis
 * @date 25/09/2017 3:01 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public abstract class AbstractSpringRedisCacheBase implements ICacheBase {

    private final Logger logger = LoggerFactory.getLogger(this.getClass()) ;
    protected final static String TIMEOUT_PREFIX = "TO:";
    protected final static String TIMEEVER_PREFIX = "NO:";
    protected final static String LOCK_PREFIX = "LOCK:";
    // 字符型
    public abstract StringRedisTemplate getStringRedisTemplate();
    // 泛型
    public abstract RedisTemplate<String, Object> getRedisTemplate();

    public <T> boolean putCache(String key, T obj) {
        if(StringUtils.isBlank(key)){
            logger.error("key is null");
            return false ;
        }
        final byte[] bkey = key.getBytes() ;
        final byte[] bvalue = SerializerHelper.serialize(obj) ;
        // java8 labbda表达式
        return getRedisTemplate().execute(
            (RedisConnection redisConnection) -> redisConnection.setNX(bkey,bvalue)
        ) ;
    }

    public <T> boolean putCacheWithExpireTime(String key, T obj, long expireTime){
        if(StringUtils.isBlank(key)){
            logger.error("key is null");
            return false ;
        }
        final byte[] bkey = key.getBytes() ;
        final byte[] bvalue = SerializerHelper.serialize(obj) ;
        return this.getRedisTemplate().execute(
            (RedisConnection redisConnection) -> {
                redisConnection.setEx(bkey,expireTime,bvalue);
                return true;
            }
        ) ;
    }

    public <T> boolean putListCache(String key, List<T> objList) {
        if(StringUtils.isBlank(key)){
            logger.error("key is null");
            return false ;
        }
        final byte[] bkey = key.getBytes() ;
        final byte[] bvalue = SerializerHelper.serializeList(objList) ;
        // java8 labbda表达式
        return getRedisTemplate().execute(
            (RedisConnection redisConnection) -> redisConnection.setNX(bkey,bvalue)
        ) ;
    }

    public <T> boolean putListCacheWithExpireTime(String key, List<T> objList, long expireTime) {
        if(StringUtils.isBlank(key)){
            logger.error("key is null");
            return false ;
        }
        final byte[] bkey = key.getBytes() ;
        final byte[] bvalue = SerializerHelper.serializeList(objList) ;
        return this.getRedisTemplate().execute(
            (RedisConnection redisConnection) -> {
                redisConnection.setEx(bkey,expireTime,bvalue);
                return true;
            }
        ) ;
    }

    public <T> T getCache(String key, Class<T> targetClass) {
        byte[] result = this.getRedisTemplate().execute(
                (RedisConnection redisConnection) -> redisConnection.get(key.getBytes())
        );
        if(null == result){
            return null ;
        }
        return SerializerHelper.deserialize(result,targetClass);
    }

    public <T> List<T> getListCache(String key, Class<T> targetClass) {
        byte[] result = this.getRedisTemplate().execute(
                (RedisConnection redisConnection) -> redisConnection.get(key.getBytes())
        );
        if(null == result){
            return null ;
        }
        return SerializerHelper.deserializeList(result,targetClass);
    }
    
    protected void consoleLog(String key, long timeOut, TimeUnit timeUnit){
        if (0!=timeOut && null!=timeUnit){
            if(TimeUnit.DAYS == timeUnit){
                logger.info("设值缓存成功！key：{};过期时间：{}天；", key, timeOut);
            }else if(TimeUnit.HOURS == timeUnit){
                logger.info("设值缓存成功！key：{};过期时间：{}小时；", key, timeOut);
            }else if(TimeUnit.MINUTES == timeUnit){
                logger.info("设值缓存成功！key：{};过期时间：{}分钟；", key, timeOut);
            }else if(TimeUnit.SECONDS == timeUnit){
                logger.info("设值缓存成功！key：{};过期时间：{}秒；", key, timeOut);
            }else{
                logger.info("设值缓存成功！key：{};过期时间：{}毫秒；", key, timeOut);
            }
        }else if(0!=timeOut && null==timeUnit){
            logger.info("设值缓存成功！key：{};过期时间：{}秒；", key, timeOut);
        }else{
            logger.info("设值缓存成功！key：{};", key);
        }
    }
}
