package com.hsy.java.util.cache.redis.impl;

import com.hsy.java.enums.CacheEnum;
import com.hsy.java.exception.cache.CacheException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.*;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
@SuppressWarnings("Duplicates")
@Slf4j
public abstract class AbstractSpringRedisCacheEnhance extends AbstractSpringRedisCacheBase{
    private ValueOperations<String, Object> valueOperations;
    private ListOperations<String, Object> listOperations;
    private SetOperations<String, Object> setOperations;
    private ZSetOperations<String, Object> zSetOperations;
    private HashOperations hashOperations;
    private GeoOperations<String, Object> geoOperations;
    private ClusterOperations<String, Object> clusterOperations;
    private HyperLogLogOperations<String, Object> hyperLogLogOperations;
    @PostConstruct
    public void getValueOperation(){
        log.info("正在初始化redis。。。");
        valueOperations = getRedisTemplate().opsForValue();
        listOperations = getRedisTemplate().opsForList();
        hashOperations = getRedisTemplate().opsForHash();
        setOperations = getRedisTemplate().opsForSet();
        zSetOperations = getRedisTemplate().opsForZSet();
        geoOperations = getRedisTemplate().opsForGeo();
        clusterOperations = getRedisTemplate().opsForCluster();
        hyperLogLogOperations = getRedisTemplate().opsForHyperLogLog();
    }
    public boolean tryLock(String key, long timeOut, TimeUnit timeUnit){
        return Boolean.FALSE;
    }
    /**
     * @param key   键
     * @param value 值oauth/token
     * @return boolean 保存是否成功
     * @description <p>保存字符串类型的值</p>
     * @author heshiyuan
     * @date 2018/7/23 21:59
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public boolean valueSet(String key, Object value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return false;
        }
        try {
            if (null == valueOperations) {
                log.info("正在初始化valueOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }
            valueOperations.set(TIMEEVER_PREFIX + key, value);
            consoleLog(TIMEEVER_PREFIX + key, 0, null);
            return true;
        } catch (Exception e) {
            log.error("设值缓存失败！失败信息：{}", e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @description <p>采用默认过期单位秒</p>
     * @param key     键
     * @param value   值
     * @param timeOut 过期时间
     * @return boolean 是否设值成功
     * @author heshiyuan
     * @date 2018/7/23 22:18
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public boolean valueSet(String key, Object value, long timeOut) {
        return this.valueSet(key, value, timeOut, TimeUnit.SECONDS);
    }
    /**
     * @param key      键
     * @param value    值
     * @param timeOut  过期时间
     * @param timeUnit 过期单位
     * @return boolean 设值是否成功
     * @description <p>给key设值值、过期时间</p>
     * @author heshiyuan
     * @date 2018/7/23 22:48
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public boolean valueSet(String key, Object value, long timeOut, TimeUnit timeUnit) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return false;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == valueOperations) {
                log.info("正在初始化valueOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }
            keyStr.append(TIMEOUT_PREFIX).append(key);
            valueOperations.set(keyStr.toString(), value, timeOut, timeUnit);
            consoleLog(keyStr.toString(), timeOut, timeUnit);
            return true;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    /**
     * @param key          键
     * @param isTimeOutkey 是否是超时key
     * @return String 返回的值
     * @description <p>获取值</p>
     * @author heshiyuan
     * @date 2018/7/24 9:00
     */
    public Object valueGet(String key, boolean isTimeOutkey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == valueOperations) {
                log.info("正在初始化valueOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }
            if (isTimeOutkey) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            Object object = valueOperations.get(keyStr.toString());
            log.info("操作成功！key={}", keyStr.toString());
            return object;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    /**
     * @param key   键
     * @param value 值
     * @return double 原子递增后的值
     * @description <p>原子递增</p>
     * @author heshiyuan
     * @date 2018/7/24 9:12
     */
    public Object valueGetAndSet(String key, Object value, boolean isTimeOutKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == valueOperations) {
                log.info("正在初始化valueOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }
            if (isTimeOutKey) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            log.info("操作成功！key={}", keyStr.toString());
            return valueOperations.getAndSet(keyStr.toString(), value);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    /**
     * @param key   键
     * @param value 值
     * @return long 原子递增后的值
     * @description <p>原子递增</p>
     * @author heshiyuan
     * @date 2018/7/24 9:12
     */
    public long valueIncrement(String key, long value, long timeLive, TimeUnit timeUnit) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == valueOperations) {
                log.info("正在初始化valueOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }
            long newValue = 0l;
            if (timeLive > 0 && null != timeUnit) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
                newValue = valueOperations.increment(keyStr.toString(), value);
                this.getRedisTemplate().expire(keyStr.toString(), timeLive, timeUnit);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
                newValue = valueOperations.increment(keyStr.toString(), value);
            }
            log.info("操作成功！key={}", keyStr.toString());
            return newValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    /**
     * @param key      键
     * @param value    值
     * @param timeLive 存活时间
     * @param timeUnit 过期时间单位
     * @return double 原子递增后的值
     * @description <p>原子递增</p>
     * @author heshiyuan
     * @date 2018/7/24 9:12
     */
    public double valueIncrement(String key, double value, long timeLive, TimeUnit timeUnit) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == valueOperations) {
                log.info("正在初始化valueOperations");
                valueOperations = getRedisTemplate().opsForValue();
            }
            double newValue = 0.0;
            if (timeLive > 0 && null != timeUnit) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
                newValue = valueOperations.increment(keyStr.toString(), value);
                this.getRedisTemplate().expire(keyStr.toString(), timeLive, timeUnit);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
                newValue = valueOperations.increment(keyStr.toString(), value);
            }
            log.info("操作成功！key={}", keyStr.toString());
            return newValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    /**
     * @param key    键
     * @param values 数组类型的值
     * @return long 返回操作成功的数量
     * @description <p>set中添加元素</p>
     * @author heshiyuan
     * @date 2018/7/24 13:54
     */
    public long setAdd(String key, Object ... values) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            keyStr.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key={}", keyStr.toString());
            return setOperations.add(keyStr.toString(), values);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    /**
     * @param key 键
     * @return String 被移除的元素
     * @description <p>从set中移除一个元素</p>
     * @author heshiyuan
     * @date 2018/7/24 13:55
     */
    public Object setPop(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            keyStr.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key={}", keyStr.toString());
            return setOperations.pop(keyStr.toString());
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    /**
     * @param key      第一个集合的key
     * @param otherKey 第二个集合的key
     * @return Set 返回不同元素的集合Set
     * @description <p>比较两个set集合不同的元素，并且将不同的元素集合返回</p>
     * @author heshiyuan
     * @date 2018/7/24 14:05
     */
    public Set<Object> setDifference(String key, String otherKey) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(otherKey)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            StringBuilder keyStr1 = new StringBuilder();
            StringBuilder keyStr2 = new StringBuilder();
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            keyStr2.append(TIMEEVER_PREFIX).append(otherKey);
            log.info("操作成功！key1={};key2={}", keyStr1.toString(), keyStr2.toString());
            return setOperations.difference(keyStr1.toString(), keyStr2.toString());
        } catch (Exception e) {
            log.error("操作失败！失败信息：{}", e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    /**
     * @param key      第一个集合的key
     * @param otherKey 第二个集合的key
     * @param storeKey 储存新集合的key
     * @return Set 返回不同元素的集合Set
     * @description <p>比较两个set集合不同的元素，并且将不同的元素集合存储起来</p>
     * @author heshiyuan
     * @date 2018/7/24 14:05
     */
    public long setDifferenceAndStore(String key, String otherKey, String storeKey) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(otherKey) || StringUtils.isBlank(storeKey)) {
            log.error("key is null");
            return 0;
        }
        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            StringBuilder keyStr1 = new StringBuilder();
            StringBuilder keyStr2 = new StringBuilder();
            StringBuilder keyStr3 = new StringBuilder();
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            keyStr2.append(TIMEEVER_PREFIX).append(otherKey);
            keyStr3.append(TIMEEVER_PREFIX).append(storeKey);
            log.info("操作成功！key1={};key2={}", keyStr1.toString(), keyStr2.toString());
            return setOperations.differenceAndStore(keyStr1.toString(), keyStr2.toString(), keyStr3.toString());
        } catch (Exception e) {
            log.error("操作失败！失败信息：{}", e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    /**
     * @param key   键
     * @param index 索引
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     */
    public Object listIndex(String key, long index) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return listOperations.index(keyStr1.toString(), index);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    /**
     * @param key   键
     * @param value 索引
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     */
    public long listLeftPush(String key, Object value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return listOperations.leftPush(keyStr1.toString(), value);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    /**
     * @param key   键
     * @param value 索引
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     */
    public long listRightPush(String key, Object value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return listOperations.rightPush(keyStr1.toString(), value);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    /**
     * @param key 键
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     */
    public Object listLeftPop(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return listOperations.leftPop(keyStr1.toString());
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    /**
     * @param key 键
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     */
    public Object listRightPop(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return listOperations.rightPop(keyStr1.toString());
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @param key 键
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     */
    public long listSize(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return listOperations.size(keyStr1.toString());
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @param key 键
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     */
    public List<Object> listRange(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return listOperations.range(keyStr1.toString(), start, end);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @description <p>此方法暂时不明白怎么用</p>
     * @param key 键
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     */
    @Deprecated
    public long listRemove(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return listOperations.remove(keyStr1.toString(), start, end);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @description <p>此方法暂时不明白怎么用</p>
     * @param key 键
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     */
    public void listSet(String key, long index, Object value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            listOperations.set(keyStr1.toString(), index, value);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @description <p>排序的set添加</p>
     * @param key 键
     * @param value 值
     * @param score @TODO 猜测事排序的权值
     * @return boolean 是否添加成功
     * @author heshiyuan
     * @date 2018/7/24 16:35
     */
    public boolean zSetAdd(String key, Object value, double score){
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return false;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == zSetOperations) {
                log.info("正在初始化zSetOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }
            keyStr.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr.toString());
            return zSetOperations.add(keyStr.toString(), value, score);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @description <p>排序的set添加</p>
     * @param key 键
     * @param values 值
     * @return boolean 是否添加成功
     * @author heshiyuan
     * @date 2018/7/24 16:35
     */
    public long zSetAdd(String key,Set<ZSetOperations.TypedTuple<Object>> values){
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == zSetOperations) {
                log.info("正在初始化zSetOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }
            keyStr.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr.toString());
            return zSetOperations.add(keyStr.toString(), values);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @description <p>排序的set添加</p>
     * @param key 键
     * @param value 值
     * @param score 增加的分数
     * @return boolean 是否添加成功
     * @author heshiyuan
     * @date 2018/7/24 16:35
     */
    public double zSetIncrementScore(String key, Object value, double score){
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == zSetOperations) {
                log.info("正在初始化zSetOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }
            keyStr.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr.toString());
            return zSetOperations.incrementScore(keyStr.toString(), value, score);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @param key 键
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     */
    public Set<Object> zSetRange(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return zSetOperations.range(keyStr1.toString(), start, end);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @param key 键
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     */
    public Set<Object> zSetReverseRange(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key1={};", keyStr1.toString());
            return zSetOperations.reverseRange(keyStr1.toString(), start, end);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @description <p>返回带有分数的区间</p>
     * @param key 键
     * @param start 索引开始处
     * @param end 索引结束处
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     */
    public Set<ZSetOperations.TypedTuple<Object>> zSetRangeWithScores(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key={};", keyStr1.toString());
            return zSetOperations.rangeWithScores(keyStr1.toString(), start, end);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @description <p>返回带有分数的区间</p>
     * @param key 键
     * @param start 索引开始处
     * @param end 索引结束处
     * @return String
     * @description <p>查看list中位于index位置的元素值</p>
     * @author heshiyuan
     * @date 2018/7/24 14:51
     */
    public Set<ZSetOperations.TypedTuple<Object>> zSetReverseRangeWithScores(String key, long start, long end) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr1 = new StringBuilder();
        try {
            if (null == zSetOperations) {
                log.info("正在初始化listOperations");
                zSetOperations = getRedisTemplate().opsForZSet();
            }
            keyStr1.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key={};", keyStr1.toString());
            return zSetOperations.reverseRangeWithScores(keyStr1.toString(), start, end);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr1.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @description <p></p>
     * @param key 键
     * @param hashKey hash的key
     * @param hashValue hash的值
     * @author heshiyuan
     * @date 2018/7/24 17:26
     */
    public void hashPut(String key, String hashKey, Object hashValue){
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }
            keyStr.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key={};", keyStr.toString());
            hashOperations.put(keyStr.toString(), hashKey, hashValue);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @description <p>如果没有就put，否则不变</p>
     * @param key 键
     * @param hashKey hash的key
     * @param hashValue hash的值
     * @author heshiyuan
     * @date 2018/7/24 17:26
     */
    public boolean hashPutIfAbsent(String key, String hashKey, Object hashValue){
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return false;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }
            keyStr.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key={};", keyStr.toString());
            return hashOperations.putIfAbsent(keyStr.toString(), hashKey, hashValue);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @description <p></p>
     * @param key 键
     * @param map 被保存的map
     * @author heshiyuan
     * @date 2018/7/24 17:26
     */
    public void hashPutAll(String key, Map<String, Object> map){
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }
            keyStr.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key={};", keyStr.toString());
            hashOperations.putAll(keyStr.toString(), map);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @description <p></p>
     * @param key 键
     * @param hashKey hash的key
     * @return Object hash里key对应的value
     * @author heshiyuan
     * @date 2018/7/24 17:26
     */
    public Object hashGet(String key, String hashKey){
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == hashOperations) {
                log.info("正在初始化hashOperations");
                hashOperations = getRedisTemplate().opsForHash();
            }
            keyStr.append(TIMEEVER_PREFIX).append(key);
            log.info("操作成功！key={};", keyStr.toString());
            return hashOperations.get(keyStr.toString(), hashKey);
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    /**
     * @description <p>删除缓存</p>
     * @param key 键
     * @return boolean 是否删除成功
     * @author heshiyuan
     * @date 2018/7/25 8:37
     */
    public boolean delete(String key, boolean isTimeOutKey){
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return false;
        }
        StringBuilder keyStr = new StringBuilder();
        try{
            if(isTimeOutKey){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else{
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            getRedisTemplate().delete(keyStr.toString());
            log.info("操作成功！key={};", keyStr.toString());
            return true ;
        }catch (Exception e){
            //log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            return false;
        }
    }

    public void delete(boolean isTimeOutKey, String... keys) {
        if(null!=keys && keys.length!=0) {
            StringBuilder keyStr = new StringBuilder();
            for (int i = 0; i < keys.length; i++) {
                if (isTimeOutKey){
                    keyStr.append(TIMEOUT_PREFIX).append(keys[i]);
                }else{
                    keyStr.append(TIMEEVER_PREFIX).append(keys[i]);
                }
            }
            try{
                if(keys.length == 1) {
                    if(StringUtils.isEmpty(keys[0])) {
                        throw new IllegalArgumentException("指定删除的key不能为空");
                    }
                    this.getRedisTemplate().delete(keys[0]);
                    log.info("操作成功！key={};", keyStr.toString());
                } else {
                    this.getRedisTemplate().delete(Arrays.asList(keys));
                }
            }catch(Exception e){
                log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
                throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION) ;
            }
        } else {
            throw new IllegalArgumentException("指定删除的key不能为空");
        }
    }
    /**
     * @description <p>删除缓存</p>
     * @param keys 键
     * @return boolean 是否删除成功
     * @author heshiyuan
     * @date 2018/7/25 8:37
     */
    public boolean delete(List<String> keys, boolean isTimeOutKey){
        try{
            keys.stream().forEach(key -> {
                if (isTimeOutKey){
                    key += TIMEOUT_PREFIX;
                }else{
                    key += TIMEEVER_PREFIX;
                }
                log.info("即将删除key={};", key);
            });
            getRedisTemplate().delete(keys);
            return true ;
        }catch (Exception e){
            log.error("操作失败！失败信息：{}", e);
            return false;
        }
    }
    /**
     * @description <p>删除缓存</p>
     * @param pattern 键
     * @return boolean 是否删除成功
     * @author heshiyuan
     * @date 2018/7/25 8:37
     */
    public boolean deleteByPattern(String pattern){
        if(StringUtils.isBlank(pattern)){
            log.error("key is null");
            return false;
        }
        try{
            log.info("正则范式：key={}", pattern);
            Set<String> keys = this.getRedisTemplate().keys(pattern);
            keys.parallelStream().forEach(key -> log.info("即将删除key={}", key));
            getRedisTemplate().delete(keys.stream().collect(Collectors.toList()));
            log.info("操作成功！");
            return true ;
        }catch (Exception e){
            log.error("操作失败！异常信息：{}", e);
            return false;
        }
    }
    /**
     * @description <p>删除缓存</p>
     * @return boolean 是否删除成功
     * @author heshiyuan
     * @date 2018/7/25 8:37
     */
    public boolean clear(){
        log.info("即将清理全部缓存");
        return deleteByPattern("*");
    }
}
}
