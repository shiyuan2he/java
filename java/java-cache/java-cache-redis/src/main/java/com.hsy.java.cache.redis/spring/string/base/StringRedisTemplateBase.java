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
