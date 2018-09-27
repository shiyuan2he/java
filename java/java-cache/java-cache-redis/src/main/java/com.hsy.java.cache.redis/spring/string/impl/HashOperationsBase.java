package com.hsy.java.cache.redis.spring.string.impl;

import com.hsy.java.cache.redis.spring.string.IHashOperationsBase;
import com.hsy.java.cache.redis.spring.string.base.SpringStringBase;
import com.hsy.java.enums.CacheEnum;
import com.hsy.java.exception.cache.CacheException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.HashOperations;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
@Slf4j
public abstract class HashOperationsBase extends SpringStringBase implements IHashOperationsBase {
    private HashOperations hashOperations = getStringRedisTemplate().opsForHash();

    @Override
    public Long delete(String key, boolean isTimeOut, Object... hashKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Long returnValue = hashOperations.delete(key, hashKey);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Boolean hasKey(String key, Object hashKey, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Boolean returnValue = hashOperations.hasKey(key, hashKey);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public String get(String key, Object hashKey, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            String returnValue = (String) hashOperations.get(key, hashKey);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public List<String> multiGet(String key, Collection<String> hashKeys, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            List<String> returnValue = hashOperations.multiGet(key, hashKeys);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long increment(String key, String hashKey, long delta, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Long returnValue = hashOperations.increment(key, hashKey, delta);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Double increment(String key, String hashKey, double delta, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Double returnValue = hashOperations.increment(key, hashKey, delta);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> keys(String key, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Set<String> returnValue = hashOperations.keys(key);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long size(String key, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Long returnValue = hashOperations.size(key);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public void putAll(String key, Map<String, String> hashKeyMapValue, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            hashOperations.putAll(key, hashKeyMapValue);
            log.info("操作成功！key={};", key);
            return;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public void put(String key, String hashKey, String hashValue, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            hashOperations.put(key, hashKey, hashValue);
            log.info("操作成功！key={};", key);
            return;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Boolean putIfAbsent(String key, String hashKey, String hashValue, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return false;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            boolean returnValue = hashOperations.putIfAbsent(key, hashKey, hashValue);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public List<String> values(String key, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            List<String> returnValue = hashOperations.values(key);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Map<String, String> entries(String key, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Map<String, String> returnValue = hashOperations.entries(key);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
}
