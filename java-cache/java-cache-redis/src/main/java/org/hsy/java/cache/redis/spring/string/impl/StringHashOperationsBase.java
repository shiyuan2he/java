package org.hsy.java.cache.redis.spring.string.impl;
import org.hsy.java.cache.redis.spring.string.IHashOperationsBase;
import org.hsy.java.cache.redis.spring.string.base.SpringStringBase;
import org.hsy.java.enums.CacheEnum;
import org.hsy.java.exception.cache.CacheException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.HashOperations;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public abstract class StringHashOperationsBase extends SpringStringBase implements IHashOperationsBase {
    private HashOperations<String, String, String> hashOperations = getStringRedisTemplate().opsForHash();

    @Override
    public Long delete(String key, String... hashKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            Long returnValue = hashOperations.delete(key, hashKey);
            log.info("delete操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("delete操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Boolean hasKey(String key, String hashKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            Boolean returnValue = hashOperations.hasKey(key, hashKey);
            log.info("hasKey操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("hasKey操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public String get(String key, String hashKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            String returnValue = (String) hashOperations.get(key, hashKey);
            log.info("get操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("get操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public List<String> multiGet(String key, Collection<String> hashKeys) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }

            List<String> returnValue = hashOperations.multiGet(key, hashKeys);
            log.info("multiGet操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("multiGet操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long increment(String key, String hashKey, long delta) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }

            Long returnValue = hashOperations.increment(key, hashKey, delta);
            log.info("increment操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("increment操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Double increment(String key, String hashKey, double delta) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }

            Double returnValue = hashOperations.increment(key, hashKey, delta);
            log.info("increment操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("increment操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> keys(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }

            Set<String> returnValue = hashOperations.keys(key);
            log.info("keys操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("keys操作失败！key={};失败信息：{}", key, e);
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
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }

            Long returnValue = hashOperations.size(key);
            log.info("size操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("size操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public void putAll(String key, Map<String, String> hashKeyMapValue) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return;
        }

        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }

            hashOperations.putAll(key, hashKeyMapValue);
            log.info("putAll操作成功！key={};", key);
            return;
        } catch (Exception e) {
            log.error("putAll操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public void put(String key, String hashKey, String hashValue) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return;
        }

        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }

            hashOperations.put(key, hashKey, hashValue);
            log.info("put操作成功！key={};", key);
            return;
        } catch (Exception e) {
            log.error("put操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Boolean putIfAbsent(String key, String hashKey, String hashValue) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return false;
        }

        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }

            boolean returnValue = hashOperations.putIfAbsent(key, hashKey, hashValue);
            log.info("putIfAbsent操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("putIfAbsent操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public List<String> values(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }

            List<String> returnValue = hashOperations.values(key);
            log.info("values操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("values操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Map<String, String> entries(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }

            Map<String, String> returnValue = hashOperations.entries(key);
            log.info("entries操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("entries操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
}
