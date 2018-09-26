package com.hsy.java.cache.redis.spring.string.impl;

import com.hsy.java.cache.redis.spring.string.ISetOperationsBase;
import com.hsy.java.cache.redis.spring.string.base.SpringStringBase;
import org.springframework.data.redis.core.SetOperations;

public class SetOperationsBase extends SpringStringBase implements ISetOperationsBase {
    private SetOperations<String, String> setOperations = getStringRedisTemplate().opsForSet();
}
