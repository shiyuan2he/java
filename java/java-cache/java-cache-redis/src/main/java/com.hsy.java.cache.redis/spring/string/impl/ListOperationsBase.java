package com.hsy.java.cache.redis.spring.string.impl;

import com.hsy.java.cache.redis.spring.string.IListOperationsBase;
import com.hsy.java.cache.redis.spring.string.base.SpringStringBase;
import com.hsy.java.cache.redis.spring.string.base.StringRedisTemplateBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ListOperations;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class ListOperationsBase extends SpringStringBase implements IListOperationsBase {
    private ListOperations<String, String> listOperations = getStringRedisTemplate().opsForList();

    @Override
    public void trim(String var1, long var2, long var4) {

    }

    @Override
    public Long size(String var1) {
        return null;
    }

    @Override
    public Long leftPushAll(String var1, String... var2) {
        return null;
    }

    @Override
    public Long leftPushAll(String var1, Collection<String> var2) {
        return null;
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
    public Long rightPushAll(String var1, String... var2) {
        return null;
    }

    @Override
    public Long rightPushAll(String var1, Collection<String> var2) {
        return null;
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
    public Long remove(String var1, long var2, Object var4) {
        return null;
    }

    @Override
    public String index(String var1, long var2) {
        return null;
    }

    @Override
    public String leftPop(String var1, long var2, TimeUnit var4) {
        return null;
    }

    @Override
    public String rightPop(String var1, long var2, TimeUnit var4) {
        return null;
    }

    @Override
    public String rightPopAndLeftPush(String var1, String var2) {
        return null;
    }

    @Override
    public String rightPopAndLeftPush(String var1, String var2, long var3, TimeUnit var5) {
        return null;
    }
}
