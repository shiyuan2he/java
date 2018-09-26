package com.hsy.java.cache.redis.spring.string.base;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.*;

/**
 * @author heshiyuan
 * @description <p>spring-data-redis缓存工具类</p>
 * @path java/com.hsy.java.util.cache.redis
 * @date 25/09/2017 3:01 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Slf4j
public abstract class StringRedisTemplateBase extends SpringStringBase {
    /**
     * @param key    键
     * @param values 数组类型的值
     * @return long 返回操作成功的数量
     * @description <p>set中添加元素</p>
     * @author heshiyuan
     * @date 2018/7/24 13:54
     *//*
    public long addSet(String key, String... values) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            keyStr.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key={}", keyStr.toString());
            return setOperations.add(keyStr.toString(), values);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key 键
     * @return String 被移除的元素
     * @description <p>从set中移除一个元素</p>
     * @author heshiyuan
     * @date 2018/7/24 13:55
     *//*
    public String popSet(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            keyStr.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key={}", keyStr.toString());
            return setOperations.pop(keyStr.toString());
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key      第一个集合的key
     * @param otherKey 第二个集合的key
     * @return Set 返回不同元素的集合Set
     * @description <p>比较两个set集合不同的元素，并且将不同的元素集合返回</p>
     * @author heshiyuan
     * @date 2018/7/24 14:05
     *//*
    public Set<String> difference(String key, String otherKey) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(otherKey)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            StringBuilder keyStr1 = new StringBuilder();
            StringBuilder keyStr2 = new StringBuilder();
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            keyStr2.append(TIMEEVER_PREFIX).append(otherKey);
            log.info("操作成功！key1={};key2={}", keyStr1.toString(), keyStr2.toString());
            return setOperations.difference(key, otherKey);
        } catch (Exception e) {
            log.error("操作失败！失败信息：{}", e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key      第一个集合的key
     * @param otherKey 第二个集合的key
     * @param storeKey 储存新集合的key
     * @return Set 返回不同元素的集合Set
     * @description <p>比较两个set集合不同的元素，并且将不同的元素集合存储起来</p>
     * @author heshiyuan
     * @date 2018/7/24 14:05
     *//*
    public long differenceAndStore(String key, String otherKey, String storeKey) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(otherKey) || StringUtils.isBlank(storeKey)) {
            log.error("key is null");
            return 0;
        }
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            StringBuilder keyStr1 = new StringBuilder();
            StringBuilder keyStr2 = new StringBuilder();
            StringBuilder keyStr3 = new StringBuilder();
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            keyStr2.append(TIMEEVER_PREFIX).append(otherKey);
            keyStr3.append(TIMEEVER_PREFIX).append(storeKey);
            log.info("操作成功！key1={};key2={}", keyStr1.toString(), keyStr2.toString());
            return setOperations.differenceAndStore(key, otherKey, keyStr3.toString());
        } catch (Exception e) {
            log.error("操作失败！失败信息：{}", e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key   键
     * @param index 索引
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     *//*
    public String indexList(String key, long index) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return listOperations.index(key, index);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key   键
     * @param value 索引
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     *//*
    public long leftPush(String key, String value, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }
            if (isTimeOut) {
                keyStr1.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr1.append(TIMEEVER_PREFIX).append(key);
            }
            log.info("操作成功！key1={};", keyStr1.toString());
            return listOperations.leftPush(keyStr1.toString(), value);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    public long leftPush(String key, String value) {
        return leftPush(key, value, false);
    }

    *//**
     * @param key   键
     * @param value 索引
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     *//*
    public long rightPush(String key, String value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return listOperations.rightPush(keyStr1.toString(), value);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key 键
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     *//*
    public String leftPop(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return listOperations.leftPop(keyStr1.toString());
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key 键
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     *//*
    public String rightPop(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return listOperations.rightPop(keyStr1.toString());
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key 键
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     *//*
    public long listSize(String key, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }
            if (isTimeOut) {
                keyStr1.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr1.append(TIMEEVER_PREFIX).append(key);
            }
            log.info("操作成功！key1={};", keyStr1.toString());
            return listOperations.size(keyStr1.toString());
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    public List<String> range(String key, long start, long end) {
        return range(key, start ,end, false);
    }
    *//**
     * @param key 键
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     *//*
    public List<String> range(String key, long start, long end, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr1.append(TIMEOUT_PREFIX).append(key);
            }else{
                keyStr1.append(TIMEEVER_PREFIX).append(key);
            }
            log.info("操作成功！key1={};", keyStr1.toString());
            return listOperations.range(keyStr1.toString(), start, end);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key 键
     * @return String
     * @description <p>此方法暂时不明白怎么用</p>
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     *//*
    @Deprecated
    public long remove(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return listOperations.remove(keyStr1.toString(), start, end);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key 键
     * @return String
     * @description <p>此方法暂时不明白怎么用</p>
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     *//*
    public void set(String key, long index, String value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("initializing listOperations");
                listOperations = getStringRedisTemplate().opsForList();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            listOperations.set(keyStr1.toString(), index, value);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key   键
     * @param value 值
     * @param score @TODO 猜测事排序的权值
     * @return boolean 是否添加成功
     * @description <p>排序的set添加</p>
     * @author heshiyuan
     * @date 2018/7/24 16:35
     *//*
    public boolean addZSet(String key, String value, double score) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return false;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            keyStr.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr.toString());
            return zSetOperations.add(keyStr.toString(), value, score);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key    键
     * @param values 值
     * @return boolean 是否添加成功
     * @description <p>排序的set添加</p>
     * @author heshiyuan
     * @date 2018/7/24 16:35
     *//*
    public long addZSet(String key, Set<ZSetOperations.TypedTuple<String>> values) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            keyStr.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr.toString());
            return zSetOperations.add(keyStr.toString(), values);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key   键
     * @param value 值
     * @param score 增加的分数
     * @return boolean 是否添加成功
     * @description <p>排序的set添加</p>
     * @author heshiyuan
     * @date 2018/7/24 16:35
     *//*
    public double incrementScore(String key, String value, double score) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == zSetOperations) {
                log.info("initializing zSetOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            keyStr.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr.toString());
            return zSetOperations.incrementScore(keyStr.toString(), value, score);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key 键
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     *//*
    public Set<String> range4ZSet(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == zSetOperations) {
                log.info("initializing listOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return zSetOperations.range(keyStr1.toString(), start, end);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key 键
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     *//*
    public Set<String> range4ZSetReverse(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == zSetOperations) {
                log.info("initializing listOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return zSetOperations.reverseRange(keyStr1.toString(), start, end);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key   键
     * @param start 索引开始处
     * @param end   索引结束处
     * @return String
     * @description <p>返回带有分数的区间</p>
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     *//*
    public Set<ZSetOperations.TypedTuple<String>> rangeWithScores(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == zSetOperations) {
                log.info("initializing listOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key={};", keyStr1.toString());
            return zSetOperations.rangeWithScores(keyStr1.toString(), start, end);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key   键
     * @param start 索引开始处
     * @param end   索引结束处
     * @return String
     * @description <p>返回带有分数的区间</p>
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     *//*
    public Set<ZSetOperations.TypedTuple<String>> reverseRangeWithScores(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == zSetOperations) {
                log.info("initializing listOperations");
                zSetOperations = getStringRedisTemplate().opsForZSet();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key={};", keyStr1.toString());
            return zSetOperations.reverseRangeWithScores(keyStr1.toString(), start, end);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key       键
     * @param hashKey   hash的key
     * @param hashValue hash的值
     * @description <p></p>
     * @author heshiyuan
     * @date 2018/7/24 17:26
     *//*
    public void put4Hash(String key, String hashKey, String hashValue) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            keyStr.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key={};", keyStr.toString());
            hashOperations.put(keyStr.toString(), hashKey, hashValue);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key       键
     * @param hashKey   hash的key
     * @param hashValue hash的值
     * @description <p>如果没有就put，否则不变</p>
     * @author heshiyuan
     * @date 2018/7/24 17:26
     *//*
    public boolean putIfAbsent(String key, String hashKey, String hashValue) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return false;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            keyStr.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key={};", keyStr.toString());
            return hashOperations.putIfAbsent(keyStr.toString(), hashKey, hashValue);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    public void putAll(String key, Map<String, Object> map) {
        putAll(key, map, false);
    }

    *//**
     * @param key 键
     * @param map 被保存的map
     * @description <p></p>
     * @author heshiyuan
     * @date 2018/7/24 17:26
     *//*
    public void putAll(String key, Map<String, Object> map, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            log.info("操作成功！key={};", keyStr.toString());
            hashOperations.putAll(keyStr.toString(), map);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    *//**
     * @description <p>判断hash是否由此key， hkey</p>
     * @author heshiyuan
     * @dateTime 2018/9/20 17:16
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     *//*
    public boolean hasHaskKey(String key, String hkey, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            log.info("操作成功！key={};", keyStr.toString());
            return hashOperations.hasKey(keyStr.toString(), hkey);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    *//**
     * @description <p>根据传入的hash key删除</p>
     * @author heshiyuan
     * @dateTime 2018/9/20 17:23
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     *//*
    public long deleteByHaskKey(String key, String[] hkey, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            log.info("操作成功！key={};", keyStr.toString());
            return hashOperations.delete(keyStr.toString(), hkey);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    *//**
     * @description <p>拿到所有的hash  key value</p>
     * @author heshiyuan
     * @dateTime 2018/9/20 17:03
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     *//*
    public Map<String, Object> getAllForHash(String key, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            log.info("操作成功！key={};", keyStr.toString());
            return hashOperations.entries(keyStr.toString());
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @description <p>统计hash中子key的数量</p>
     * @author heshiyuan
     * @dateTime 2018/9/20 10:55
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     * I'm glad to share my knowledge with you all.
     * @price 3毛    微信：hewei1109
     *//*
    public long hashKeySize(String key, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            log.info("操作成功！key={};", keyStr.toString());
            return hashOperations.size(keyStr.toString());
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    *//**
     * @param key     键
     * @param hashKey hash的key
     * @return Object hash里key对应的value
     * @description <p></p>
     * @author heshiyuan
     * @date 2018/7/24 17:26
     *//*
    public Object get(String key, String hashKey, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("initializing hashOperations");
                hashOperations = getStringRedisTemplate().opsForHash();
            }
            if (isTimeOut) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            log.info("操作成功！key={};", keyStr.toString());
            return hashOperations.get(keyStr.toString(), hashKey);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    public Object get(String key, String hashKey) {
        return get(key, hashKey, false);
    }

    *//**
     * @param key 键
     * @return boolean 是否删除成功
     * @description <p>删除缓存</p>
     * @author heshiyuan
     * @date 2018/7/25 8:37
     *//*
    public boolean delete(String key, boolean isTimeOutKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return false;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (isTimeOutKey) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            getStringRedisTemplate().delete(keyStr.toString());
            log.info("操作成功！key={};", keyStr.toString());
            return true;
        } catch (Exception e) {
            //log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            return false;
        }
    }

    public void delete(boolean isTimeOutKey, String... keys) {
        if (null != keys && keys.length != 0) {
            StringBuilder keyStr = new StringBuilder();
            for (int i = 0; i < keys.length; i++) {
                if (isTimeOutKey) {
                    keyStr.append(TIMEOUT_PREFIX).append(keys[i]);
                } else {
                    keyStr.append(TIMEEVER_PREFIX).append(keys[i]);
                }
            }
            try {
                if (keys.length == 1) {
                    if (StringUtils.isEmpty(keys[0])) {
                        throw new IllegalArgumentException("指定删除的key不能为空");
                    }
                    this.getStringRedisTemplate().delete(keys[0]);
                    log.info("操作成功！key={};", keyStr.toString());
                } else {
                    this.getStringRedisTemplate().delete(Arrays.asList(keys));
                }
            } catch (Exception e) {
                log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
                throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION);
            }
        } else {
            throw new IllegalArgumentException("指定删除的key不能为空");
        }
    }

    *//**
     * @param keys 键
     * @return boolean 是否删除成功
     * @description <p>删除缓存</p>
     * @author heshiyuan
     * @date 2018/7/25 8:37
     *//*
    public boolean delete(List<String> keys, boolean isTimeOutKey) {
        try {
            keys.stream().forEach(key -> {
                if (isTimeOutKey) {
                    key += TIMEOUT_PREFIX;
                } else {
                    key += TIMEEVER_PREFIX;
                }
                log.info("即将删除key={};", key);
            });
            getStringRedisTemplate().delete(keys);
            return true;
        } catch (Exception e) {
            log.error("操作失败！失败信息：{}", e);
            return false;
        }
    }

    *//**
     * @param pattern 键
     * @return boolean 是否删除成功
     * @description <p>删除缓存</p>
     * @author heshiyuan
     * @date 2018/7/25 8:37
     *//*
    public boolean deleteByPattern(String pattern) {
        if (StringUtils.isBlank(pattern)) {
            log.error("key is null");
            return false;
        }
        try {
            log.info("正则范式：key={}", pattern);
            Set<String> keys = this.getStringRedisTemplate().keys(pattern);
            keys.parallelStream().forEach(key -> log.info("即将删除key={}", key));
            getStringRedisTemplate().delete(keys.stream().collect(Collectors.toList()));
            log.info("操作成功！");
            return true;
        } catch (Exception e) {
            log.error("操作失败！异常信息：{}", e);
            return false;
        }
    }

    *//**
     * @return boolean 是否删除成功
     * @description <p>删除缓存</p>
     * @author heshiyuan
     * @date 2018/7/25 8:37
     *//*
    public boolean clear() {
        log.info("即将清理全部缓存");
        return deleteByPattern("*");
    }*/
}
