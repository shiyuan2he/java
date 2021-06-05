package org.hsy.java.cache.redis.spring.string;

import org.hsy.java.cache.redis.spring.ISpringRedisInterface;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Collection;
import java.util.Set;

public interface IZSetOperationsBase extends ISpringRedisInterface {

    Boolean add(String key, String value, double score);

//    Long add(String key, Set<ZSetOperations.TypedTuple<String>> tuples);

    Long remove(String key, Object... value);

    Double incrementScore(String key, String value, double delta);

    Long rank(String key, Object value);

    Long reverseRank(String key, Object value);

    Set<String> range(String key, long start, long end);

    Set<ZSetOperations.TypedTuple<String>> rangeWithScores(String key, long start, long end);

    Set<String> rangeByScore(String key, double start, double end);

//    Set<ZSetOperations.TypedTuple<String>> rangeByScoreWithScores(String var1, double var2, double var4);

    Set<String> rangeByScore(String key, double min, double max, long offset, long count);

//    Set<ZSetOperations.TypedTuple<String>> rangeByScoreWithScores(String var1, double min, double max, long offset, long count);

    Set<String> reverseRange(String key, long start, long end);

    Set<ZSetOperations.TypedTuple<String>> reverseRangeWithScores(String key, long start, long end);

    Set<String> reverseRangeByScore(String key, double min, double max);

    Set<ZSetOperations.TypedTuple<String>> reverseRangeByScoreWithScores(String key, double min, double max);

    Set<String> reverseRangeByScore(String key, double min, double max, long offset, long count);

//    Set<ZSetOperations.TypedTuple<String>> reverseRangeByScoreWithScores(String key, double min, double max, long offset, long count);

    Long count(String key, double min, final double max);

    Long size(String key);

    Long zCard(String key);

    Double score(String key, Object value);

    Long removeRange(String key, long start, long end);

    Long removeRangeByScore(String key, double min, double max);

    Long unionAndStore(String key, String otherKey, String destinationKey);

    Long unionAndStore(String key, Collection<String> otherKeys, String destinationKey);

    Long intersectAndStore(String key, String otherKey, String destinationKey);

    Long intersectAndStore(String key, Collection<String> otherKey, String destinationKey);

//    Cursor<ZSetOperations.TypedTuple<String>> scan(String var1, ScanOptions var2);

//    Set<String> rangeByLex(String var1, RedisZSetCommands.Range var2);

//    Set<String> rangeByLex(String var1, RedisZSetCommands.Range var2, RedisZSetCommands.Limit var3);

//    RedisOperations<String, String> getOperations();
}
