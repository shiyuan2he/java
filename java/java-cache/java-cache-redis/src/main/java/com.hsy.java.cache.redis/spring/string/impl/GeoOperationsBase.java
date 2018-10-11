package com.hsy.java.cache.redis.spring.string.impl;
import com.hsy.java.cache.redis.spring.string.IGeoOperationsBase;
import com.hsy.java.cache.redis.spring.string.base.SpringStringBase;
import org.springframework.data.redis.core.GeoOperations;

public abstract class GeoOperationsBase extends SpringStringBase implements IGeoOperationsBase {
    private GeoOperations geoOperations = getStringRedisTemplate().opsForGeo();
}
