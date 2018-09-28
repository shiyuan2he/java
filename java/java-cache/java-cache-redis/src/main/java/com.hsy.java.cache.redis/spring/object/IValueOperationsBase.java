package com.hsy.java.cache.redis.spring.object;

import org.springframework.data.redis.core.RedisOperations;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface IValueOperationsBase {
    void set(String key, Object value);

    void set(String key, Object value, long timeOut, TimeUnit timeUnit);

//    void set(String key, Object var2, long var3);

    Boolean setIfAbsent(String key, Object value);

    void multiSet(Map<String, Object> keyValue);

    Boolean multiSetIfAbsent(Map<String, Object> keyValue);

    Object get(Object key);

    Object getAndSet(String key, Object value);

    List<Object> multiGet(Collection<String> keys);

    Long increment(String key, long delta);

    Double increment(String key, double delta);

    Integer append(String key, String value);

    String get(String key, long start, long end);

    Long size(String key);

//    Boolean setBit(String var1, long var2, boolean var4);

//    Boolean getBit(String var1, long var2);

//    RedisOperations<String, Object> getOperations();
}
