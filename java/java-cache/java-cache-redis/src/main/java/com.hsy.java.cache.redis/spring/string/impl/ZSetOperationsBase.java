package com.hsy.java.cache.redis.spring.string.impl;

import com.hsy.java.cache.redis.spring.string.IZSetOperationsBase;
import com.hsy.java.cache.redis.spring.string.base.SpringStringBase;
import org.springframework.data.redis.core.ZSetOperations;

public class ZSetOperationsBase extends SpringStringBase implements IZSetOperationsBase {
    private ZSetOperations<String, String> zSetOperations = getStringRedisTemplate().opsForZSet();
}
