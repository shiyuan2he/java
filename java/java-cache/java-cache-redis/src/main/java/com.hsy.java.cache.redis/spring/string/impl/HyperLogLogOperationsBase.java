package com.hsy.java.cache.redis.spring.string.impl;

import com.hsy.java.cache.redis.spring.string.IHyperLogLogOperationsBase;
import com.hsy.java.cache.redis.spring.string.base.SpringStringBase;
import org.springframework.data.redis.core.HyperLogLogOperations;

public class HyperLogLogOperationsBase extends SpringStringBase implements IHyperLogLogOperationsBase {
    private HyperLogLogOperations<String, String> hyperLogLogOperations = getStringRedisTemplate().opsForHyperLogLog();
}
