package com.hsy.java.cache.redis.spring.object.impl;
import com.askingdata.y.cache.redis.spring.object.IZSetOperationsBase;
import com.askingdata.y.cache.redis.spring.object.base.SpringObjectBase;
import com.askingdata.y.enums.CacheEnum;
import com.askingdata.y.exception.CacheException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Collection;
import java.util.Set;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.cache.redis.spring.object.impl
 * @date 08/10/2018 6:10 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Slf4j
public abstract class ZSetOperationsBase extends SpringObjectBase implements IZSetOperationsBase {
    private ZSetOperations<String, Object> zSetOperations = getRedisTemplate().opsForZSet();


    @Override
    public Boolean add(String key, Object value, double score) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Boolean returnValue = zSetOperations.add(key, value, score);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long remove(String key, Object... objects) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Long returnValue = zSetOperations.remove(key, objects);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Double incrementScore(String key, Object value, double score) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Double returnValue = zSetOperations.incrementScore(key, value, score);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long rank(String key, Object value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Long returnValue = zSetOperations.rank(key, value);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long reverseRank(String key, Object value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Long returnValue = zSetOperations.reverseRank(key, value);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<Object> range(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Set<Object> returnValue = zSetOperations.range(key, start, end);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<Object> rangeByScore(String key, double min, double max) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Set<Object> returnValue = zSetOperations.rangeByScore(key, min, max);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<Object> rangeByScore(String key, double min, double max, long offset, long count) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Set<Object> returnValue = zSetOperations.rangeByScore(key, min, max, offset, count);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<Object> reverseRange(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Set<Object> returnValue = zSetOperations.reverseRange(key, start, end);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<Object> reverseRangeByScore(String key, double min, double max) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Set<Object> returnValue = zSetOperations.reverseRangeByScore(key, min, max);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<Object> reverseRangeByScore(String key, double min, double max, long offset, long count) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Set<Object> returnValue = zSetOperations.reverseRangeByScore(key, min, max, offset, count);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long count(String key, double min, double max) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Long returnValue = zSetOperations.count(key, min, max);
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
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Long returnValue = zSetOperations.size(key);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long zCard(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Long returnValue = zSetOperations.zCard(key);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Double score(String key, Object value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Double returnValue = zSetOperations.score(key, value);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long removeRange(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Long returnValue = zSetOperations.removeRange(key, start, end);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long removeRangeByScore(String key, double min, double max) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Long returnValue = zSetOperations.removeRangeByScore(key, min, max);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long unionAndStore(String key, String key1, String key2) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Long returnValue = zSetOperations.unionAndStore(key, key1, key2);
            log.info("操作成功！key={},key1={},key2={};", key, key1, key2);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},key1={},key2={};失败信息：{}", key, key1, key2, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long unionAndStore(String key, Collection<String> collection, String key1) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Long returnValue = zSetOperations.unionAndStore(key, collection, key1);
            log.info("操作成功！key={},key1={};", key, key1);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},key1={};失败信息：{}", key, key1, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long intersectAndStore(String key, String key1, String key2) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Long returnValue = zSetOperations.intersectAndStore(key, key1, key2);
            log.info("操作成功！key={},key1={},key2={};", key, key1, key2);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},key1={},key2={};失败信息：{}", key, key1, key2, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long intersectAndStore(String key, Collection<String> collection, String key1) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }

            Long returnValue = zSetOperations.intersectAndStore(key, collection, key1);
            log.info("操作成功！key={},key1={};", key, key1);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},key1={};失败信息：{}", key, key1, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
}
