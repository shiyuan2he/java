package com.hsy.java.cache.redis.spring.string;

import com.askingdata.y.cache.redis.spring.ISpringRedisInterface;
import org.springframework.data.redis.connection.RedisClusterNode;

import java.util.Collection;
import java.util.Set;

public interface IClusterOperationsBase extends ISpringRedisInterface {
    Set<String> keys(RedisClusterNode var1, String var2);

    String ping(RedisClusterNode var1);

    String randomKey(RedisClusterNode var1);

    void addSlots(RedisClusterNode var1, int... var2);

    void addSlots(RedisClusterNode var1, RedisClusterNode.SlotRange var2);

    void bgReWriteAof(RedisClusterNode var1);

    void bgSave(RedisClusterNode var1);

    void meet(RedisClusterNode var1);

    void forget(RedisClusterNode var1);

    void flushDb(RedisClusterNode var1);

    Collection<RedisClusterNode> getSlaves(RedisClusterNode var1);

    void save(RedisClusterNode var1);

    void shutdown(RedisClusterNode var1);

    void reshard(RedisClusterNode var1, int var2, RedisClusterNode var3);
}
