package org.hsy.java.cache.redis.spring.string.impl;
import org.hsy.java.cache.redis.spring.string.IHyperLogLogOperationsBase;
import org.hsy.java.cache.redis.spring.string.base.SpringStringBase;
import org.springframework.data.redis.core.HyperLogLogOperations;

public abstract class StringHyperLogLogOperationsBase extends SpringStringBase implements IHyperLogLogOperationsBase {
    private HyperLogLogOperations<String, String> hyperLogLogOperations = getStringRedisTemplate().opsForHyperLogLog();
}
