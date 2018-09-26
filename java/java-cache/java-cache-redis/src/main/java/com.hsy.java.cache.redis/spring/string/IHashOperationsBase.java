package com.hsy.java.cache.redis.spring.string;

import com.hsy.java.cache.redis.spring.ISpringRedisInterface;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.ScanOptions;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IHashOperationsBase extends ISpringRedisInterface {
    Long delete(String var1, Object... var2);

    Boolean hasKey(String var1, Object var2);

    String  get(String var1, Object var2);

    List<String > multiGet(String var1, Collection<String > var2);

    Long increment(String var1, String  var2, long var3);

    Double increment(String var1, String  var2, double var3);

    Set<String > keys(String var1);

    Long size(String var1);

    void putAll(String var1, Map<? extends String , ? extends String > var2);

    void put(String var1, String  var2, String  var3);

    Boolean putIfAbsent(String var1, String  var2, String  var3);

    List<String > values(String var1);

    Map<String , String > entries(String var1);

    Cursor<Map.Entry<String , String >> scan(String var1, ScanOptions var2);

    RedisOperations<String, String> getOperations();
}
