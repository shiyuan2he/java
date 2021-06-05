package org.hsy.java.cache.redis.spring.string.impl;
import org.hsy.java.cache.redis.spring.string.IZSetOperationsBase;
import org.hsy.java.cache.redis.spring.string.base.SpringStringBase;
import org.hsy.java.enums.CacheEnum;
import org.hsy.java.exception.cache.CacheException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Collection;
import java.util.Set;

@Slf4j
public abstract class StringZSetOperationsBase extends SpringStringBase implements IZSetOperationsBase {
    private ZSetOperations<String, String> zSetOperations = getStringRedisTemplate().opsForZSet();

    @Override
    public Boolean add(String key, String value, double score) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return false;
        }
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
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
    public Long remove(String key, Object... value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Long returnValue = zSetOperations.remove(key, value);
            log.info("操作成功！key={};", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Double incrementScore(String key, String value, double delta) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Double returnValue = zSetOperations.incrementScore(key, value, delta);
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
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
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
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
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
    public Set<String> range(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Set<String> returnValue = zSetOperations.range(key, start, end);
            log.info("操作成功！key={},start={},end={};", key, start, end);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<ZSetOperations.TypedTuple<String>> rangeWithScores(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Set<ZSetOperations.TypedTuple<String>> returnValue = zSetOperations.rangeWithScores(key, start, end);
            log.info("操作成功！key={},start={},end={};", key, start, end);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> rangeByScore(String key, double start, double end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Set<String> returnValue = zSetOperations.rangeByScore(key, start, end);
            log.info("操作成功！key={},start={},end={};", key, start, end);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> rangeByScore(String key, double min, double max, long offset, long count) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Set<String> returnValue = zSetOperations.rangeByScore(key, min, max, offset, count);
            log.info("操作成功！key={},min={},max={},offset={},count={};", key, min, max, offset, count);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},min={},max={},offset={},count={};失败信息：{}", key, min, max, offset, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> reverseRange(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Set<String> returnValue = zSetOperations.reverseRange(key, start, end);
            log.info("操作成功！key={},start={},end={}", key,  start, end);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},start={},end={};失败信息：{}", key,  start, end, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<ZSetOperations.TypedTuple<String>> reverseRangeWithScores(String key, long start, long end) {
        return null;
    }

    @Override
    public Set<String> reverseRangeByScore(String key, double min, double max) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Set<String> returnValue = zSetOperations.reverseRangeByScore(key, min, max);
            log.info("操作成功！key={},min={},max={}", key, min, max);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},start={},end={};失败信息：{}", key, min, max, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<ZSetOperations.TypedTuple<String>> reverseRangeByScoreWithScores(String key, double min, double max) {
        return null;
    }

    @Override
    public Set<String> reverseRangeByScore(String key, double min, double max, long offset, long count) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Set<String> returnValue = zSetOperations.reverseRangeByScore(key, min, max, offset, count);
            log.info("操作成功！key={},min={},max={},offset={},count={}", key, min, max, offset, count);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},start={},end={},offset={},count={};失败信息：{}", key, min, max, offset, count, e);
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
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Long returnValue = zSetOperations.count(key, min, max);
            log.info("操作成功！key={},min={},max={}", key, min, max);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},start={},end={};失败信息：{}", key, min, max, e);
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
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Long returnValue = zSetOperations.size(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long zCard(String key) {
        return null;
    }

    @Override
    public Double score(String key, Object value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Double returnValue = zSetOperations.score(key, value);
            log.info("操作成功！key={}", key);
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
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Long returnValue = zSetOperations.removeRange(key, start, end);
            log.info("操作成功！key={},start={},end={}", key, start, end);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},start={},end={};失败信息：{}", key, start, end, e);
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
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Long returnValue = zSetOperations.removeRangeByScore(key, min, max);
            log.info("操作成功！key={},min={},max={}", key, min, max);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},min={},max={};失败信息：{}", key, min, max, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long unionAndStore(String key, String otherKey, String destinationKey) {
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Long returnValue = zSetOperations.unionAndStore(key, otherKey, destinationKey);
            log.info("操作成功！key={},otherKey={},destinationKey={}", key, otherKey, destinationKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKey={},destinationKey={};失败信息：{}", key, otherKey, destinationKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long unionAndStore(String key, Collection<String> otherKeys, String destinationKey) {
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Long returnValue = zSetOperations.unionAndStore(key, otherKeys, destinationKey);
            log.info("操作成功！key={},otherKeys={},destinationKey={}", key, otherKeys, destinationKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKeys={},destinationKey={};失败信息：{}", key, otherKeys, destinationKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long intersectAndStore(String key, String otherKey, String destinationKey) {
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Long returnValue = zSetOperations.intersectAndStore(key, otherKey, destinationKey);
            log.info("操作成功！key={},otherKey={},destinationKey={}", key, otherKey, destinationKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKey={},destinationKey={};失败信息：{}", key, otherKey, destinationKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long intersectAndStore(String key, Collection<String> otherKeys, String destinationKey) {
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            Long returnValue = zSetOperations.intersectAndStore(key, otherKeys, destinationKey);
            log.info("操作成功！key={},otherKeys={},destinationKey={}", key, otherKeys, destinationKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKeys={},destinationKey={};失败信息：{}", key, otherKeys, destinationKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
}
