package org.hsy.java.cache.redis.spring.string.impl;
import org.hsy.java.cache.redis.spring.string.IGeoOperationsBase;
import org.hsy.java.cache.redis.spring.string.base.SpringStringBase;
import org.springframework.data.redis.core.GeoOperations;

public abstract class StringGeoOperationsBase extends SpringStringBase implements IGeoOperationsBase {
    private GeoOperations geoOperations = getStringRedisTemplate().opsForGeo();
}
