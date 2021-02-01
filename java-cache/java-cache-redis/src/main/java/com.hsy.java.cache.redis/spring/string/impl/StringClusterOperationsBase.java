package com.hsy.java.cache.redis.spring.string.impl;
import com.hsy.java.cache.redis.spring.string.IClusterOperationsBase;
import com.hsy.java.cache.redis.spring.string.base.SpringStringBase;
import org.springframework.data.redis.core.ClusterOperations;

public abstract class StringClusterOperationsBase extends SpringStringBase implements IClusterOperationsBase {
    private ClusterOperations<String, String> clusterOperations = getStringRedisTemplate().opsForCluster();
}
