package com.hsy.java.cache.redis.spring.string.impl;

import com.hsy.java.cache.redis.spring.string.IHashOperationsBase;
import com.hsy.java.cache.redis.spring.string.base.SpringStringBase;
import org.springframework.data.redis.core.HashOperations;

public abstract class HashOperationsBase extends SpringStringBase implements IHashOperationsBase {
    private HashOperations hashOperations = getStringRedisTemplate().opsForHash();
}
