package com.hsy.java.cache.redis.spring.object;

import com.hsy.java.cache.redis.spring.ISpringRedisInterface;

import java.util.Collection;
import java.util.Set;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.cache.redis.spring.object
 * @date 08/10/2018 6:10 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface IZSetOperationsBase extends ISpringRedisInterface {
    Boolean add(String key, Object value, double score, boolean isTimeOut);

    Long remove(String key, boolean isTimeOut, Object... objects);

    Double incrementScore(String key, Object value, double score, boolean isTimeOut);

    Long rank(String key, Object value, boolean isTimeOut);

    Long reverseRank(String key, Object value, boolean isTimeOut);

    Set<Object> range(String key, long start, long end, boolean isTimeOut);

    Set<Object> rangeByScore(String key, double min, double max, boolean isTimeOut);

    Set<Object> rangeByScore(String key, double min, double max, long offset, long count, boolean isTimeOut);

    Set<Object> reverseRange(String key, long start, long end, boolean isTimeOut);

    Set<Object> reverseRangeByScore(String key, double min, double max, boolean isTimeOut);

    Set<Object> reverseRangeByScore(String key, double min, double max, long offset, long count, boolean isTimeOut);

    Long count(String key, double min, double max, boolean isTimeOut);

    Long size(String key, boolean isTimeOut);

    Long zCard(String key, boolean isTimeOut);

    Double score(String key, Object value, boolean isTimeOut);

    Long removeRange(String key, long start, long end, boolean isTimeOut);

    Long removeRangeByScore(String key, double min, double max, boolean isTimeOut);

    Long unionAndStore(String key, String key1, String key2);

    Long unionAndStore(String key, Collection<String> collection, String key1);

    Long intersectAndStore(String key, String key1, String key2);

    Long intersectAndStore(String key, Collection<String> collection, String key1);
}
