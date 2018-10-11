package com.hsy.java.cache.redis.spring.object.impl;
import com.hsy.java.cache.redis.spring.object.IValueOperationsBase;
import com.hsy.java.cache.redis.spring.object.base.SpringObjectBase;
import com.hsy.java.enums.CacheEnum;
import com.hsy.java.exception.cache.CacheException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class ValueOperationsBase extends SpringObjectBase implements IValueOperationsBase {
    private ValueOperations<String, Object> valueOperations = getRedisTemplate().opsForValue();

    @Override
    public void set(String key, Object value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return ;
        }
        try {
            if (null == valueOperations) {
                log.info("正在初始化hashOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }

            valueOperations.set(key, value);
            log.info("操作成功！key={};", key);
            return ;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public void set(String key, Object value, long timeOut, TimeUnit timeUnit) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return ;
        }
        try {
            if (null == valueOperations) {
                log.info("正在初始化hashOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }

            valueOperations.set(key, value, timeOut, timeUnit);
            log.info("操作成功！key={};", key);
            return ;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Boolean setIfAbsent(String key, Object value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == valueOperations) {
                log.info("正在初始化hashOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }

            Boolean returnValue = valueOperations.setIfAbsent(key, value);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public void multiSet(Map<String, Object> keyValue) {
        try {
            if (null == valueOperations) {
                log.info("正在初始化hashOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }

            valueOperations.multiSet(keyValue);
            log.info("操作成功!");
            return ;
        } catch (Exception e) {
            log.error("操作失败！失败信息：{}", e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Boolean multiSetIfAbsent(Map<String, Object> keyValue) {
        try {
            if (null == valueOperations) {
                log.info("正在初始化hashOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }

            Boolean returnValue = valueOperations.multiSetIfAbsent(keyValue);
            log.info("操作成功!");
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！失败信息：{}", e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Object get(Object key) {
        try {
            if (null == valueOperations) {
                log.info("正在初始化hashOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }

            Object returnValue = valueOperations.get(key);
            log.info("操作成功! key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Object getAndSet(String key, Object value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == valueOperations) {
                log.info("正在初始化hashOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }

            Object returnValue = valueOperations.getAndSet(key, value);
            log.info("操作成功! key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public List<Object> multiGet(Collection<String> keys) {
        try {
            if (null == valueOperations) {
                log.info("正在初始化hashOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }

            List<Object> returnValue = valueOperations.multiGet(keys);
            log.info("操作成功! ");
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！失败信息：{}", e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long increment(String key, long delta) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == valueOperations) {
                log.info("正在初始化hashOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }

            Long returnValue = valueOperations.increment(key, delta);
            log.info("操作成功! key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Double increment(String key, double delta) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == valueOperations) {
                log.info("正在初始化hashOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }

            Double returnValue = valueOperations.increment(key, delta);
            log.info("操作成功! key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Integer append(String key, String value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == valueOperations) {
                log.info("正在初始化hashOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }

            Integer returnValue = valueOperations.append(key, value);
            log.info("操作成功! key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public String get(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == valueOperations) {
                log.info("正在初始化hashOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }

            String returnValue = valueOperations.get(key, start, end);
            log.info("操作成功! key={}", key);
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
            if (null == valueOperations) {
                log.info("正在初始化hashOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }

            Long returnValue = valueOperations.size(key);
            log.info("操作成功! key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
}
