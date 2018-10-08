package com.hsy.java.cache.redis.spring.object.impl;

import com.hsy.java.cache.redis.spring.object.IListOperationsBase;
import com.hsy.java.cache.redis.spring.object.base.SpringObjectBase;
import com.hsy.java.enums.CacheEnum;
import com.hsy.java.exception.cache.CacheException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.ListOperations;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.cache.redis.spring.object.impl
 * @date 2018/9/30 15:20
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Slf4j
public abstract class ListOperationsBase extends SpringObjectBase implements IListOperationsBase {
    private ListOperations<String, Object> listOperations = getRedisTemplate().opsForList();

    @Override
    public List<Object> range(String key, long start, long end, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            List<Object> returnValue = listOperations.range(key, start, end);
            log.info("操作成功！key={},start={},end={};", key, start, end);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},start={},end={};错误信息：{}", key, start, end, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public void trim(String key, long start, long end, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            listOperations.trim(key, start, end);
            log.info("操作成功！key={},start={},end={};", key, start, end);
            return;
        } catch (Exception e) {
            log.error("操作失败！key={},start={},end={};错误信息：{}", key, start, end, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long size(String key, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Long returnValue = listOperations.size(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long leftPush(String key, String value, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Long returnValue = listOperations.leftPush(key, value);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long leftPushAll(String key, boolean isTimeOut, Object... vs) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Long returnValue = listOperations.leftPushAll(key, vs);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long leftPushAll(String key, boolean isTimeOut, Collection<Object> collection) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Long returnValue = listOperations.leftPushAll(key, collection);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long leftPushIfPresent(String key, boolean isTimeOut, String value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Long returnValue = listOperations.leftPushIfPresent(key, value);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long leftPush(String key, String pivot, String value, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Long returnValue = listOperations.leftPush(key, value);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long rightPush(String key, String value, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Long returnValue = listOperations.rightPush(key, value);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long rightPushAll(String key, boolean isTimeOut, Object... values) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Long returnValue = listOperations.rightPushAll(key, values);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long rightPushAll(String key, Collection<Object> collection, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Long returnValue = listOperations.rightPushAll(key, collection);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long rightPushIfPresent(String key, String value, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Long returnValue = listOperations.rightPushIfPresent(key, value);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long rightPush(String key, String value, String otherValue) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }

            Long returnValue = listOperations.rightPush(key, value, otherValue);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public void set(String key, long index, String value, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return ;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            listOperations.set(key, index, value);
            log.info("操作成功！key={}", key);
            return;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long remove(String key, long count, Object value, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Long returnValue = listOperations.remove(key, count, value);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Object index(String key, long index, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Object returnValue = listOperations.index(key, index);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Object leftPop(String key, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Object returnValue = listOperations.leftPop(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Object leftPop(String key, long timeOut, TimeUnit timeUnit) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            keyStr.append(TIMEOUT_PREFIX).append(key);
            key = keyStr.toString();
            Object returnValue = listOperations.leftPop(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Object rightPop(String key, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            key = keyStr.toString();
            Object returnValue = listOperations.rightPop(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Object rightPop(String key, long timeOut, TimeUnit timeUnit) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            keyStr.append(TIMEOUT_PREFIX).append(key);
            key = keyStr.toString();
            Object returnValue = listOperations.rightPop(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};错误信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Object rightPopAndLeftPush(String key, String otherKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            keyStr.append(TIMEOUT_PREFIX).append(key);
            key = keyStr.toString();
            Object returnValue = listOperations.rightPopAndLeftPush(key, otherKey);
            log.info("操作成功！key={}, otherKey={}", key, otherKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKey={};错误信息：{}", key, otherKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Object rightPopAndLeftPush(String key, String otherKey, long timeOut, TimeUnit timeUnit) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuilder keyStr = new StringBuilder();
        StringBuilder otherKeyStr = new StringBuilder();
        try {
            if (null == listOperations) {
                log.info("正在初始化listOperations");
                listOperations = getRedisTemplate().opsForList();
            }
            keyStr.append(TIMEOUT_PREFIX).append(key);
            otherKeyStr.append(TIMEOUT_PREFIX).append(key);
            key = keyStr.toString();
            otherKey = otherKeyStr.toString();
            Object returnValue = listOperations.rightPopAndLeftPush(key, otherKey);
            log.info("操作成功！key={}, otherKey={}", key, otherKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKey={};错误信息：{}", key, otherKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
}
