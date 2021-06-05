package org.hsy.java.cache.redis.spring.string.impl;
import org.hsy.java.cache.redis.spring.string.IListOperationsBase;
import org.hsy.java.cache.redis.spring.string.base.SpringStringBase;
import org.hsy.java.enums.CacheEnum;
import org.hsy.java.exception.cache.CacheException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.ListOperations;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("Duplicates")
@Slf4j
public abstract class StringListOperationsBase extends SpringStringBase implements IListOperationsBase {
    private ListOperations<String, String> listOperations = getStringRedisTemplate().opsForList();

    @Override
    public List<String> range(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }

            List<String> returnValue = listOperations.range(key, start, end);
            log.info("操作成功！key={},start={},end={};", key, start, end);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={},start={},end={}失败！失败信息：{}", key, start, end, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public void trim(String key, long start, long end) {
        // TODO: 2018/9/27
    }

    @Override
    public Long size(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }

            Long returnValue = listOperations.size(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long leftPush(String key, String value) {
        return this.leftPushAll(key, value);
    }

    @Override
    public Long leftPushAll(String key, String... value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }

            Long returnValue = listOperations.leftPushAll(key, value);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long leftPushAll(String key, Collection<String> value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }

            Long returnValue = listOperations.leftPushAll(key, value);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long leftPushIfPresent(String var1, String var2) {
        return null;
    }

    @Override
    public Long leftPush(String var1, String var2, String var3) {
        return null;
    }

    @Override
    public Long rightPush(String key, String value) {
        return this.rightPushAll(key, value);
    }

    @Override
    public Long rightPushAll(String key, String... value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }

            Long returnValue = listOperations.rightPushAll(key, value);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long rightPushAll(String key, Collection<String> value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }

            Long returnValue = listOperations.rightPushAll(key, value);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long rightPushIfPresent(String var1, String var2) {
        return null;
    }

    @Override
    public Long rightPush(String var1, String var2, String var3) {
        return null;
    }

    @Override
    public void set(String key, long index, String value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return;
        }

        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }

            listOperations.set(key, index, value);
            log.info("操作成功！key={},index={}", key, index);
            return;
        } catch (Exception e) {
            log.error("操作失败！key={},index={},失败信息：{}", key, index, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long remove(String key, long index, Object value) {
        return null;
    }

    @Override
    public String index(String key, long index) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }

            String returnValue = listOperations.index(key, index);
            log.info("操作成功！key={},index={}", key, index);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},index={},失败信息：{}", key, index, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public String leftPop(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }

            String returnValue = listOperations.leftPop(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public String leftPop(String var1, long var2, TimeUnit var4) {
        return null;
    }

    @Override
    public String rightPop(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }

            String returnValue = listOperations.rightPop(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public String rightPop(String var1, long var2, TimeUnit var4) {
        return null;
    }

    @Override
    public String rightPopAndLeftPush(String sourceKey, String destinationKey) {
        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }
            String returnValue = listOperations.rightPopAndLeftPush(sourceKey, destinationKey);
            log.info("操作成功！sourceKey={}, destinationKey={}", sourceKey, destinationKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！sourceKey={}, destinationKey={},失败信息：{}", sourceKey, destinationKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public String rightPopAndLeftPush(String var1, String var2, long var3, TimeUnit var5) {
        return null;
    }
}
