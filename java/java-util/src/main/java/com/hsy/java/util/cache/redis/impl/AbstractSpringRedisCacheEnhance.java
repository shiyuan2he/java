package com.hsy.java.util.cache.redis.impl;

import com.hsy.java.enums.CacheEnum;
import com.hsy.java.exception.cache.CacheException;
import com.hsy.java.util.serializer.SerializerHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

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
@SuppressWarnings("Duplicates")
public abstract class AbstractSpringRedisCacheEnhance extends AbstractSpringRedisCacheBase{

    private final Logger logger = LoggerFactory.getLogger(this.getClass()) ;

    private ValueOperations<String,String> stringValueOperations;
    private ValueOperations<String,Object> valueOperations;
    private ListOperations<String,Object> listOperations;
    private HashOperations hashOperations;

    @PostConstruct
    public void getValueOperation(){
        stringValueOperations = getStringRedisTemplate().opsForValue();
        valueOperations = getRedisTemplate().opsForValue();
        listOperations = getRedisTemplate().opsForList();
        hashOperations = getRedisTemplate().opsForHash();
    }
    /**
     * @description <p>保存字符串类型的值</p>
     * @param key 键
     * @param value 值
     * @return boolean 保存是否成功
     * @author heshiyuan 
     * @date 2018/7/23 21:59 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public boolean set(String key, String value){
        if(StringUtils.isBlank(key)){
            logger.error("key is null");
            return false;
        }
        try{
            stringValueOperations.set(TIMEEVER_PREFIX + key, value);
            consoleLog(TIMEEVER_PREFIX + key, 0, null);
            return true ;
        }catch(Exception e){
            logger.error("设值缓存成功！失败信息：{}", e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }
    /**
     * @description <p>采用默认 过期单位指定过期时间的值</p>
     * @param key 键
     * @param value 值
     * @param timeOut 过期时间
     * @return boolean 是否设值成功
     * @author heshiyuan
     * @date 2018/7/23 22:18 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public boolean set(String key, String value, long timeOut){
        if(StringUtils.isBlank(key)){
            logger.error("key is null");
            return false;
        }
        try{
            stringValueOperations.set(TIMEOUT_PREFIX + key, value, timeOut);
            consoleLog(TIMEOUT_PREFIX + key, timeOut, null);
            return true ;
        }catch(Exception e){
            logger.error("设值缓存成功！失败信息：{}", e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }
    /**
     * @description <p>给key设值值、过期时间</p>
     * @param key 键
     * @param value 值
     * @param timeOut 过期时间
     * @param timeUnit 过期单位
     * @return boolean 设值是否成功
     * @author heshiyuan
     * @date 2018/7/23 22:48
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public boolean set(String key, String value, long timeOut, TimeUnit timeUnit){
        if(StringUtils.isBlank(key)){
            logger.error("key is null");
            return false;
        }
        try{
            stringValueOperations.set(TIMEOUT_PREFIX + key, value, timeOut, timeUnit);
            consoleLog(TIMEOUT_PREFIX + key, timeOut, timeUnit);
            return true ;
        }catch(Exception e){
            logger.error("设值缓存成功！失败信息：{}", e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }
    public boolean get(String key){
        if(StringUtils.isBlank(key)){
            logger.error("key is null");
            return false;
        }
        try{
            stringValueOperations.get(key);
            return true ;
        }catch(Exception e){
            logger.error("设值缓存成功！失败信息：{}", e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public <T> boolean putCache(String key, T obj){
        if(StringUtils.isBlank(key)){
            logger.error("key is null");
            return false ;
        }
        try{
            valueOperations.set(key,obj);
            return true ;
        }catch(Exception e){
            _logger.info("{}", e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public <T> boolean putCacheWithExpireTime(String key, T obj, long expireTime){
        if(StringUtils.isBlank(key)){
            logger.error("key is null");
            return false ;
        }
        try{
            valueOperations.set(key,obj,expireTime);
            return true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public <T> boolean putCacheWithExpireTimeAndTimeUnit(String key, T obj, long expireTime, TimeUnit timeUnit){
        if(StringUtils.isBlank(key)){
            logger.error("key is null");
            return false ;
        }
        try{
            valueOperations.set(key,obj,expireTime,timeUnit);
            return true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public <T> boolean putListCache(String key, List<T> objList) {
        if(StringUtils.isBlank(key)){
            logger.error("key is null");
            return false ;
        }
        try{
            return listPushResult(listOperations.leftPush(key,objList)) ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public <T> boolean putListCacheWithExpireTime(String key, List<T> objList, long expireTime) {
        if(StringUtils.isBlank(key)){
            logger.error("key is null");
            return false ;
        }
        try{
            return listPushResult(listOperations.leftPush(key,objList,expireTime)) ;

        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    private boolean listPushResult(Long count){
        if(count > 0){
            logger.error("list leftPush success;set {} count",count);
            return true ;
        }else{
            logger.error("list leftPush error");
            return false ;
        }
    }

    public <T> T getCache(String key) {
        return (T) valueOperations.get(key);
    }

    public <T> List<T> getListCache(String key) {
        return (List<T>) listOperations.leftPop(key);
    }

    private void consoleLog(String key, long timeOut, TimeUnit timeUnit){
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
            logger.info("设值缓存成功！key：{};过期时间：{}毫秒；", key, timeOut);
        }else{
            logger.info("设值缓存成功！key：{};", key);
        }
    }
}
