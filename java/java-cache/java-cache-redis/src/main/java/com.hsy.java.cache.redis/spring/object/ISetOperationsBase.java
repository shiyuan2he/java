package com.hsy.java.cache.redis.spring.object;

import com.hsy.java.cache.redis.spring.ISpringRedisInterface;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.ScanOptions;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ISetOperationsBase extends ISpringRedisInterface{
    Long add(String var1, Object... var2);

    Long remove(String var1, Object... var2);

    Object pop(String var1);

    Boolean move(String var1, Object var2, String var3);

    Long size(String var1);

    Boolean isMember(String var1, Object var2);

    Set<Object> intersect(String var1, String var2);

    Set<Object> intersect(String var1, Collection<String> var2);

    Long intersectAndStore(String var1, String var2, String var3);

    Long intersectAndStore(String var1, Collection<String> var2, String var3);

    Set<Object> union(String var1, String var2);

    Set<Object> union(String var1, Collection<String> var2);

    Long unionAndStore(String var1, String var2, String var3);

    Long unionAndStore(String var1, Collection<String> var2, String var3);

    Set<Object> difference(String var1, String var2);

    Set<Object> difference(String var1, Collection<String> var2);

    Long differenceAndStore(String var1, String var2, String var3);

    Long differenceAndStore(String var1, Collection<String> var2, String var3);

    Set<Object> members(String var1);

    Object randomMember(String var1);

    Set<Object> distinctRandomMembers(String var1, long var2);

    List<Object> randomMembers(String var1, long var2);

    Cursor<Object> scan(String var1, ScanOptions var2);

    RedisOperations<String, Object> getOperations();
}
