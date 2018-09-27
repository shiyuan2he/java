package com.hsy.java.cache.redis.spring.string.impl;

import com.hsy.java.cache.redis.spring.string.IZSetOperationsBase;
import com.hsy.java.cache.redis.spring.string.base.SpringStringBase;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Collection;
import java.util.Set;

public abstract class ZSetOperationsBase extends SpringStringBase implements IZSetOperationsBase {
    private ZSetOperations<String, String> zSetOperations = getStringRedisTemplate().opsForZSet();

    @Override
    public Boolean add(String key, String value, double score, boolean isTimeOut) {
        return null;
    }

    @Override
    public Long remove(String key, boolean isTimeOut, Object... value) {
        return null;
    }

    @Override
    public Double incrementScore(String key, String value, double delta, boolean isTimeOut) {
        return null;
    }

    @Override
    public Long rank(String key, Object value, boolean isTimeOut) {
        return null;
    }

    @Override
    public Long reverseRank(String key, Object value, boolean isTimeOut) {
        return null;
    }

    @Override
    public Set<String> range(String key, long start, long end, boolean isTimeOut) {
        return null;
    }

    @Override
    public Set<ZSetOperations.TypedTuple<String>> rangeWithScores(String key, long start, long end, boolean isTimeOut) {
        return null;
    }

    @Override
    public Set<String> rangeByScore(String key, double start, double end, boolean isTimeOut) {
        return null;
    }

    @Override
    public Set<String> rangeByScore(String key, double min, double max, long offset, long count, boolean isTimeOut) {
        return null;
    }

    @Override
    public Set<String> reverseRange(String key, long start, long end, boolean isTimeOut) {
        return null;
    }

    @Override
    public Set<ZSetOperations.TypedTuple<String>> reverseRangeWithScores(String key, long start, long end, boolean isTimeOut) {
        return null;
    }

    @Override
    public Set<String> reverseRangeByScore(String key, double min, double max, boolean isTimeOut) {
        return null;
    }

    @Override
    public Set<ZSetOperations.TypedTuple<String>> reverseRangeByScoreWithScores(String key, double min, double max, boolean isTimeOut) {
        return null;
    }

    @Override
    public Set<String> reverseRangeByScore(String key, double min, double max, long offset, long count, boolean isTimeOut) {
        return null;
    }

    @Override
    public Long count(String key, double min, double max, boolean isTimeOut) {
        return null;
    }

    @Override
    public Long size(String key, boolean isTimeOut) {
        return null;
    }

    @Override
    public Long zCard(String key, boolean isTimeOut) {
        return null;
    }

    @Override
    public Double score(String key, Object value, boolean isTimeOut) {
        return null;
    }

    @Override
    public Long removeRange(String key, long start, long end, boolean isTimeOut) {
        return null;
    }

    @Override
    public Long removeRangeByScore(String key, double min, double max, boolean isTimeOut) {
        return null;
    }

    @Override
    public Long unionAndStore(String key, String otherKey, String destinationKey, boolean isTimeOut) {
        return null;
    }

    @Override
    public Long unionAndStore(String key, Collection<String> otherKeys, String destinationKey, boolean isTimeOut) {
        return null;
    }

    @Override
    public Long intersectAndStore(String key, String otherKey, String destinationKey, boolean isTimeOut) {
        return null;
    }

    @Override
    public Long intersectAndStore(String key, Collection<String> otherKey, String destinationKey, boolean isTimeOut) {
        return null;
    }
}
