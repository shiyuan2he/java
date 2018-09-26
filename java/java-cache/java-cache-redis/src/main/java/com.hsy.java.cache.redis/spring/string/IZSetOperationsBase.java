package com.hsy.java.cache.redis.spring.string;

import com.hsy.java.cache.redis.spring.ISpringRedisInterface;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Collection;
import java.util.Set;

public interface IZSetOperationsBase extends ISpringRedisInterface {
    Boolean add(String var1, String var2, double var3);

    Long add(String var1, Set<ZSetOperations.TypedTuple<String>> var2);

    Long remove(String var1, Object... var2);

    Double incrementScore(String var1, String var2, double var3);

    Long rank(String var1, Object var2);

    Long reverseRank(String var1, Object var2);

    Set<String> range(String var1, long var2, long var4);

    Set<ZSetOperations.TypedTuple<String>> rangeWithScores(String var1, long var2, long var4);

    Set<String> rangeByScore(String var1, double var2, double var4);

    Set<ZSetOperations.TypedTuple<String>> rangeByScoreWithScores(String var1, double var2, double var4);

    Set<String> rangeByScore(String var1, double var2, double var4, long var6, long var8);

    Set<ZSetOperations.TypedTuple<String>> rangeByScoreWithScores(String var1, double var2, double var4, long var6, long var8);

    Set<String> reverseRange(String var1, long var2, long var4);

    Set<ZSetOperations.TypedTuple<String>> reverseRangeWithScores(String var1, long var2, long var4);

    Set<String> reverseRangeByScore(String var1, double var2, double var4);

    Set<ZSetOperations.TypedTuple<String>> reverseRangeByScoreWithScores(String var1, double var2, double var4);

    Set<String> reverseRangeByScore(String var1, double var2, double var4, long var6, long var8);

    Set<ZSetOperations.TypedTuple<String>> reverseRangeByScoreWithScores(String var1, double var2, double var4, long var6, long var8);

    Long count(String var1, double var2, double var4);

    Long size(String var1);

    Long zCard(String var1);

    Double score(String var1, Object var2);

    Long removeRange(String var1, long var2, long var4);

    Long removeRangeByScore(String var1, double var2, double var4);

    Long unionAndStore(String var1, String var2, String var3);

    Long unionAndStore(String var1, Collection<String> var2, String var3);

    Long intersectAndStore(String var1, String var2, String var3);

    Long intersectAndStore(String var1, Collection<String> var2, String var3);

    Cursor<ZSetOperations.TypedTuple<String>> scan(String var1, ScanOptions var2);

    Set<String> rangeByLex(String var1, RedisZSetCommands.Range var2);

    Set<String> rangeByLex(String var1, RedisZSetCommands.Range var2, RedisZSetCommands.Limit var3);

    RedisOperations<String, String> getOperations();

}
