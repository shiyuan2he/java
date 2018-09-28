package com.hsy.java.cache.redis.spring.object.impl;

import com.hsy.java.cache.redis.spring.object.ISetOperationsBase;
import com.hsy.java.cache.redis.spring.object.base.SpringObjectBase;
import org.springframework.data.redis.core.SetOperations;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class SetOperationsBase extends SpringObjectBase implements ISetOperationsBase {
    private SetOperations<String, Object> setOperations = getRedisTemplate().opsForSet();

    @Override
    public Long add(String key, Object... value) {
        return null;
    }

    @Override
    public Long remove(String key, Object... value) {
        return null;
    }

    @Override
    public Object pop(String key) {
        return null;
    }

    @Override
    public Boolean move(String key, Object value, String destinationKey) {
        return null;
    }

    @Override
    public Long size(String key) {
        return null;
    }

    @Override
    public Boolean isMember(String key, Object value) {
        return null;
    }

    @Override
    public Set<Object> intersect(String key, String otherKey) {
        return null;
    }

    @Override
    public Set<Object> intersect(String key, Collection<String> otherKeys) {
        return null;
    }

    @Override
    public Long intersectAndStore(String key, String otherKey, String destinationKey) {
        return null;
    }

    @Override
    public Long intersectAndStore(String key, Collection<String> otherKeys, String destinationKey) {
        return null;
    }

    @Override
    public Set<Object> union(String key, String otherKey) {
        return null;
    }

    @Override
    public Set<Object> union(String key, Collection<String> otherKeys) {
        return null;
    }

    @Override
    public Long unionAndStore(String key, String otherKey, String destiantionKey) {
        return null;
    }

    @Override
    public Long unionAndStore(String key, Collection<String> otherKey, String destinationKey) {
        return null;
    }

    @Override
    public Set<Object> difference(String key, String otherKey) {
        return null;
    }

    @Override
    public Set<Object> difference(String key, Collection<String> otherKeys) {
        return null;
    }

    @Override
    public Long differenceAndStore(String key, String otherKey, String destinationKey) {
        return null;
    }

    @Override
    public Long differenceAndStore(String key, Collection<String> otherKeys, String destinationKey) {
        return null;
    }

    @Override
    public Set<Object> members(String key) {
        return null;
    }

    @Override
    public Object randomMember(String key) {
        return null;
    }

    @Override
    public Set<Object> distinctRandomMembers(String key, long count) {
        return null;
    }

    @Override
    public List<Object> randomMembers(String key, long count) {
        return null;
    }
}
