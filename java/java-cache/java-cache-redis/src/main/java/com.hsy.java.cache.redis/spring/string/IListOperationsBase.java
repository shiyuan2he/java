package com.hsy.java.cache.redis.spring.string;
import com.hsy.java.cache.redis.spring.ISpringRedisInterface;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface IListOperationsBase extends ISpringRedisInterface {

    List<String> range(String key, long start, long end);

    void trim(String var1, long var2, long var4);

    Long size(String var1);

    Long leftPush(String var1, String var2);

    Long leftPushAll(String var1, String ... var2);

    Long leftPushAll(String var1, Collection<String> var2);

    Long leftPushIfPresent(String var1, String var2);

    Long leftPush(String var1, String var2, String var3);

    Long rightPush(String var1, String var2);

    Long rightPushAll(String var1, String ... var2);

    Long rightPushAll(String var1, Collection<String> var2);

    Long rightPushIfPresent(String var1, String var2);

    Long rightPush(String var1, String var2, String var3);

    void set(String var1, long var2, String var4);

    Long remove(String var1, long var2, Object var4);

    String index(String var1, long var2);

    String leftPop(String var1);

    String leftPop(String var1, long var2, TimeUnit var4);

    String rightPop(String var1);

    String rightPop(String var1, long var2, TimeUnit var4);

    String rightPopAndLeftPush(String var1, String var2);

    String rightPopAndLeftPush(String var1, String var2, long var3, TimeUnit var5);
}
