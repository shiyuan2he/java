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

    Boolean add(String key, String value, double score, boolean isTimeOut);

//    Long add(String key, Set<ZSetOperations.TypedTuple<String>> tuples);

    Long remove(String key, boolean isTimeOut, Object... value);

    Double incrementScore(String key, String value, double delta, boolean isTimeOut);

    Long rank(String key, Object value, boolean isTimeOut);

    Long reverseRank(String key, Object value, boolean isTimeOut);

    Set<String> range(String key, long start, long end, boolean isTimeOut);

    Set<ZSetOperations.TypedTuple<String>> rangeWithScores(String key, long start, long end, boolean isTimeOut);

    Set<String> rangeByScore(String key, double start, double end, boolean isTimeOut);

//    Set<ZSetOperations.TypedTuple<String>> rangeByScoreWithScores(String var1, double var2, double var4);

    Set<String> rangeByScore(String key, double min, double max, long offset, long count, boolean isTimeOut);

//    Set<ZSetOperations.TypedTuple<String>> rangeByScoreWithScores(String var1, double min, double max, long offset, long count);

    Set<String> reverseRange(String key, long start, long end, boolean isTimeOut);

    Set<ZSetOperations.TypedTuple<String>> reverseRangeWithScores(String key, long start, long end, boolean isTimeOut);

    Set<String> reverseRangeByScore(String key, double min, double max, boolean isTimeOut);

    Set<ZSetOperations.TypedTuple<String>> reverseRangeByScoreWithScores(String key, double min, double max, boolean isTimeOut);

    Set<String> reverseRangeByScore(String key, double min, double max, long offset, long count, boolean isTimeOut);

//    Set<ZSetOperations.TypedTuple<String>> reverseRangeByScoreWithScores(String key, double min, double max, long offset, long count);

    Long count(String key, double min, final double max, boolean isTimeOut);

    Long size(String key, boolean isTimeOut);

    Long zCard(String key, boolean isTimeOut);

    Double score(String key, Object value, boolean isTimeOut);

    Long removeRange(String key, long start, long end, boolean isTimeOut);

    Long removeRangeByScore(String key, double min, double max, boolean isTimeOut);

    Long unionAndStore(String key, String otherKey, String destinationKey);

    Long unionAndStore(String key, Collection<String> otherKeys, String destinationKey);

    Long intersectAndStore(String key, String otherKey, String destinationKey);

    Long intersectAndStore(String key, Collection<String> otherKey, String destinationKey);

//    Cursor<ZSetOperations.TypedTuple<String>> scan(String var1, ScanOptions var2);

//    Set<String> rangeByLex(String var1, RedisZSetCommands.Range var2);

//    Set<String> rangeByLex(String var1, RedisZSetCommands.Range var2, RedisZSetCommands.Limit var3);

//    RedisOperations<String, String> getOperations();
}
