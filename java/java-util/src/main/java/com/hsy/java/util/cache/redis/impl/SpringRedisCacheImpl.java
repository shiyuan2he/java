package com.hsy.java.util.cache.redis.impl;

import com.hsy.java.base.exception.CacheException;
import com.hsy.java.util.cache.redis.ISpringRedisCache;
import com.hsy.java.util.serializer.SerializerHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
@Component("springRedisCache")
public class SpringRedisCacheImpl implements ISpringRedisCache {
    private final Logger _logger = LoggerFactory.getLogger(this.getClass()) ;
    @Autowired
    private RedisTemplate<String, ?> springRedisTemplate;

    @Override
    public <T> boolean putCache(String key, T obj) throws CacheException {
        if(StringUtils.isBlank(key)){
            _logger.error("key is null");
            return false ;
        }
        final byte[] bkey = key.getBytes() ;
        final byte[] bvalue = SerializerHelper.serialize(obj) ;
        // java8 labbda表达式
        return springRedisTemplate.execute(
            (RedisConnection redisConnection) -> redisConnection.setNX(bkey,bvalue)
        ) ;
    }

    @Override
    public <T> boolean putCacheWithExpireTime(String key, T obj, long expireTime) throws CacheException{
        if(StringUtils.isBlank(key)){
            _logger.error("key is null");
            return false ;
        }
        final byte[] bkey = key.getBytes() ;
        final byte[] bvalue = SerializerHelper.serialize(obj) ;
        return this.springRedisTemplate.execute(
            (RedisConnection redisConnection) -> {
                redisConnection.setEx(bkey,expireTime,bvalue);
                return true;
            }
        ) ;
    }

    @Override
    public <T> boolean putListCache(String key, List<T> objList) throws CacheException {
        if(StringUtils.isBlank(key)){
            _logger.error("key is null");
            return false ;
        }
        final byte[] bkey = key.getBytes() ;
        final byte[] bvalue = SerializerHelper.serializeList(objList) ;
        // java8 labbda表达式
        return springRedisTemplate.execute(
            (RedisConnection redisConnection) -> redisConnection.setNX(bkey,bvalue)
        ) ;
    }

    @Override
    public <T> boolean putListCacheWithExpireTime(String key, List<T> objList, long expireTime) throws CacheException {
        if(StringUtils.isBlank(key)){
            _logger.error("key is null");
            return false ;
        }
        final byte[] bkey = key.getBytes() ;
        final byte[] bvalue = SerializerHelper.serializeList(objList) ;
        return this.springRedisTemplate.execute(
            (RedisConnection redisConnection) -> {
                redisConnection.setEx(bkey,expireTime,bvalue);
                return true;
            }
        ) ;
    }

    @Override
    public <T> T getCache(String key, Class<T> targetClass) throws CacheException {
        byte[] result = this.springRedisTemplate.execute(
            (RedisConnection redisConnection) -> redisConnection.get(key.getBytes())
        );
        if(null == result){
            return null ;
        }
        return SerializerHelper.deserialize(result,targetClass);
    }

    @Override
    public <T> List<T> getListCache(String key, Class<T> targetClass) throws CacheException {
        byte[] result = this.springRedisTemplate.execute(
                (RedisConnection redisConnection) -> redisConnection.get(key.getBytes())
        );
        if(null == result){
            return null ;
        }
        return SerializerHelper.deserializeList(result,targetClass);
    }

    @Override
    public void deleteCacheByKey(String key) throws CacheException {
        this.springRedisTemplate.delete(key);
    }
    @Override
    public void deleteCacheByKeys(String... keys) throws CacheException {
        if(!org.springframework.util.StringUtils.isEmpty(keys) && keys.length != 0) {
            if(keys.length == 1) {
                if(org.springframework.util.StringUtils.isEmpty(keys[0])) {
                    throw new IllegalArgumentException("指定删除的key不能为空");
                }
                this.springRedisTemplate.delete(keys[0]);
            } else {
                this.springRedisTemplate.delete(Arrays.asList(keys));
            }
        } else {
            throw new IllegalArgumentException("指定删除的key不能为空");
        }
    }

    @Override
    public void deleteCacheWithPattern(String pattern) throws CacheException {
        if(org.springframework.util.StringUtils.isEmpty(pattern)) {
            throw new IllegalArgumentException("指定删除的key不能为空");
        } else {
            Set<String> keys = this.springRedisTemplate.keys(pattern);
            this.springRedisTemplate.delete(keys);
        }
    }

    @Override
    public void clearCache() throws CacheException {
        deleteCacheWithPattern("*");
    }

    @Override
    public void deleteByPrefix(String prex) throws CacheException {
        if(org.springframework.util.StringUtils.isEmpty(prex)) {
            throw new IllegalArgumentException("指定删除的key前缀不能为空");
        } else {
            Set<String> keys = this.springRedisTemplate.keys(prex + "*");
            this.springRedisTemplate.delete(keys);
        }
    }
    @Override
    public void deleteBySuffix(String suffix) throws CacheException {
        if(org.springframework.util.StringUtils.isEmpty(suffix)) {
            throw new IllegalArgumentException("指定删除的key后缀不能为空");
        } else {
            Set<String> keys = this.springRedisTemplate.keys("*" + suffix);
            this.springRedisTemplate.delete(keys);
        }
    }
}
