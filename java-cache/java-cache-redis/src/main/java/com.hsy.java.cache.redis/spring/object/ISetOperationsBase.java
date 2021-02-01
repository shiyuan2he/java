package com.hsy.java.cache.redis.spring.object;

import com.hsy.java.cache.redis.spring.ISpringRedisInterface;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ISetOperationsBase extends ISpringRedisInterface {
    Long add(String key, Object... value);

    Long remove(String key, Object... value);

    Object pop(String key);

    Boolean move(String key, Object value, String destinationKey);

    Long size(String key);

    Boolean isMember(String key, Object value);

    Set<Object> intersect(String key, String otherKey);

    Set<Object> intersect(String key, Collection<String> otherKeys);

    Long intersectAndStore(String key, String otherKey, String destinationKey);

    Long intersectAndStore(String key, Collection<String> otherKeys, String destinationKey);

    Set<Object> union(String key, String otherKey);

    Set<Object> union(String key, Collection<String> otherKeys);

    Long unionAndStore(String key, String otherKey, String destinationKey);

    Long unionAndStore(String key, Collection<String> otherKeys, String destinationKey);

    Set<Object> difference(String key, String otherKey);

    Set<Object> difference(String key, Collection<String> otherKeys);

    Long differenceAndStore(String key, String otherKey, String destinationKey);

    Long differenceAndStore(String key, Collection<String> otherKeys, String destinationKey);

    Set<Object> members(String key);

    Object randomMember(String key);

    Set<Object> distinctRandomMembers(String key, long count);

    List<Object> randomMembers(String key, long count);

//    Cursor<Object> scan(String var1, ScanOptions var2);

//    RedisOperations<String, Object> getOperations();
}
