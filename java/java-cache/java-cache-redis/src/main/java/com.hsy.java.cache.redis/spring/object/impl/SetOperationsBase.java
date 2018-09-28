package com.hsy.java.cache.redis.spring.object.impl;

import com.hsy.java.cache.redis.spring.object.ISetOperationsBase;
import com.hsy.java.cache.redis.spring.object.base.SpringObjectBase;
import org.springframework.data.redis.core.SetOperations;

public class SetOperationsBase extends SpringObjectBase implements ISetOperationsBase {
    private SetOperations<String, Object> setOperations = getRedisTemplate().opsForSet();
}
