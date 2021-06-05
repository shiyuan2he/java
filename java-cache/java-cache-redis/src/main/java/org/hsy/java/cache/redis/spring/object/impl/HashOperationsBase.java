package org.hsy.java.cache.redis.spring.object.impl;
import org.hsy.java.cache.redis.spring.object.IHashOperationsBase;
import org.hsy.java.cache.redis.spring.object.base.SpringObjectBase;
import org.hsy.java.enums.CacheEnum;
import org.hsy.java.exception.cache.CacheException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.HashOperations;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.cache.redis.spring.object.impl
 * @date 08/10/2018 4:49 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Slf4j
public abstract class HashOperationsBase extends SpringObjectBase implements IHashOperationsBase {
    private HashOperations<String, Object, Object> hashOperations = getRedisTemplate().opsForHash();


    @Override
    public Long delete(String key, Object... objects) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
       
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }
          
            Long returnValue = hashOperations.delete(key, objects);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Boolean hasKey(String key, Object hashKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
       
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }

            Boolean returnValue = hashOperations.hasKey(key, hashKey);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Object get(String key, Object hashKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
       
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }

            Object returnValue = hashOperations.get(key, hashKey);
            log.info("操作成功！key={},hashKey={};", key, hashKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},hashKey={};失败信息：{}", key, hashKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public List<Object> multiGet(String key, Collection<Object> collection) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
       
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }

            List<Object> returnValue = hashOperations.multiGet(key, collection);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long increment(String key, Object hashKey, long delta) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
       
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }

            Long returnValue = hashOperations.increment(key, hashKey, delta);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Double increment(String key, Object hashKey, double delta) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }

            Double returnValue = hashOperations.increment(key, hashKey, delta);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<Object> keys(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
       
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }

            Set<Object> returnValue = hashOperations.keys(key);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long size(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
       
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }

            Long returnValue = hashOperations.size(key);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public void putAll(String key, Map<Object, Object> map) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return;
        }
       
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }

            hashOperations.putAll(key, map);
            log.info("操作成功！key={};", key);
            return ;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public void put(String key, Object hashKey, Object hashValue) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return;
        }
       
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }

            hashOperations.put(key, hashKey, hashValue);
            log.info("操作成功！key={},hashKey={};", key, hashKey);
            return ;
        } catch (Exception e) {
            log.error("操作失败！key={}, hashKey={};失败信息：{}", key, hashKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Boolean putIfAbsent(String key, Object hashKey, Object hashValue) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
       
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }

            Boolean returnValue = hashOperations.putIfAbsent(key, hashKey, hashValue);
            log.info("操作成功！key={},hashKey={};", key, hashKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={}, hashKey={};失败信息：{}", key, hashKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public List<Object> values(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
       
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }

            List<Object> returnValue = hashOperations.values(key);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Map<Object, Object> entries(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
       
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }

            Map<Object, Object> returnValue = hashOperations.entries(key);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
}
