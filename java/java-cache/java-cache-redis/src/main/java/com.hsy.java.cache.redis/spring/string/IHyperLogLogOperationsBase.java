package com.hsy.java.cache.redis.spring.string;

import com.askingdata.y.cache.redis.spring.ISpringRedisInterface;

public interface IHyperLogLogOperationsBase extends ISpringRedisInterface {
    Long add(String var1, String... var2);

    Long size(String... var1);

    Long union(String var1, String... var2);

    void delete(String var1);
}
