package com.hsy.java.cache.redis.spring.object.impl;

import com.hsy.java.cache.redis.spring.object.IValueOperationsBase;
import com.hsy.java.cache.redis.spring.object.base.SpringObjectBase;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class ValueOperationsBase extends SpringObjectBase implements IValueOperationsBase{
    private ValueOperations<String, Object> valueOperations = getRedisTemplate().opsForValue();

    @Override
    public void set(String key, Object value) {

    }

    @Override
    public void set(String key, Object value, long timeOut, TimeUnit timeUnit) {

    }

    @Override
    public Boolean setIfAbsent(String key, Object value) {
        return null;
    }

    @Override
    public void multiSet(Map<String, Object> keyValue) {

    }

    @Override
    public Boolean multiSetIfAbsent(Map<String, Object> keyValue) {
        return null;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object getAndSet(String key, Object value) {
        return null;
    }

    @Override
    public List<Object> multiGet(Collection<String> keys) {
        return null;
    }

    @Override
    public Long increment(String key, long delta) {
        return null;
    }

    @Override
    public Double increment(String key, double delta) {
        return null;
    }

    @Override
    public Integer append(String key, String value) {
        return null;
    }

    @Override
    public String get(String key, long start, long end) {
        return null;
    }

    @Override
    public Long size(String key) {
        return null;
    }
}
