package com.hsy.java.cache.redis.spring.string.impl;

import com.hsy.java.cache.redis.spring.string.ISetOperationsBase;
import com.hsy.java.cache.redis.spring.string.base.SpringStringBase;
import com.hsy.java.enums.CacheEnum;
import com.hsy.java.exception.cache.CacheException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.SetOperations;

import java.util.*;
import java.util.concurrent.TimeUnit;
@Slf4j
public abstract class SetOperationsBase extends SpringStringBase implements ISetOperationsBase {
    private SetOperations<String, String> setOperations = getStringRedisTemplate().opsForSet();

    @Override
    public Long add(String key, String value) {
       return this.add(key, -1, null, value);
    }


    @Override
    public Long add(String key, long timeOut, String value) {
        return this.add(key, timeOut, null, value);
    }

    @Override
    public Long add(String key, long timeOut, TimeUnit timeUnit, String value) {
        return this.add(key, timeOut, timeUnit, value);
    }

    @Override
    public Long add(String key, String... value) {
        return this.add(key, -1, null, value);
    }

    @Override
    public Long add(String key, long timeOut, String... value) {
        return this.add(key, timeOut, null, value);
    }

    @Override
    public Long add(String key, long timeOut, TimeUnit timeUnit, String... value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0l;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Long returnValue = 0l;
            if (timeOut > 0 && null != timeUnit) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
                returnValue = setOperations.add(keyStr.toString(), value);
                this.getStringRedisTemplate().expire(keyStr.toString(), timeOut, timeUnit);
            } else if (timeOut > 0 && null == timeUnit) {
                keyStr.append(TIMEOUT_PREFIX).append(key);
                returnValue = setOperations.add(keyStr.toString(), value) ;
                this.getStringRedisTemplate().expire(keyStr.toString(), timeOut, TimeUnit.SECONDS);
            } else {
                keyStr.append(TIMEEVER_PREFIX).append(key);
                returnValue = setOperations.add(keyStr.toString(), value) ;
            }
            log.info("操作成功！key={}", keyStr.toString());
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long remove(String key, boolean isTimeOut, String value) {
        return this.remove(key, isTimeOut, value);
    }

    @Override
    public Long remove(String key, boolean isTimeOut, String... value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0l;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else{
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            Long returnValue = setOperations.remove(keyStr.toString());
            log.info("操作成功！key={}", keyStr.toString());
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public String pop(String key, boolean isTimeOut) {
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
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else{
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            String returnValue = setOperations.pop(keyStr.toString());
            log.info("操作成功！key={}", keyStr.toString());
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public boolean move(String key, String value, String destinationKey) {
        if (StringUtils.isBlank(key) ||StringUtils.isBlank(destinationKey)) {
            log.error("key is null");
            return false;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            boolean returnValue = setOperations.move(key, value, destinationKey);
            log.info("操作成功！key={}", keyStr.toString());
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
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
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else{
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            Long returnValue = setOperations.size(keyStr.toString());
            log.info("操作成功！key={}", keyStr.toString());
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public boolean isMember(String key, String value, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return false;
        }
        StringBuilder keyStr = new StringBuilder();
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            if(isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else{
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            boolean returnValue = setOperations.isMember(keyStr.toString(), value);
            log.info("操作成功！key={}", keyStr.toString());
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> intersect(String key, String otherKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Set<String> returnValue = setOperations.intersect(key, otherKey);
            log.info("操作成功！key={};otherKey={}", key, otherKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKey={}失败！失败信息：{}", key, otherKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> intersect(String key, Collection<String> otherKeys) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Set<String> returnValue = setOperations.intersect(key, otherKeys);
            log.info("操作成功！key={};otherKey={}", key, Arrays.toString(otherKeys.toArray()));
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKey={}失败！失败信息：{}", key, Arrays.toString(otherKeys.toArray()), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long intersectAndStore(String key, String otherKey, String destinationKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.intersectAndStore(key, otherKey, destinationKey);
            log.info("操作成功！key={};otherKey={};destinationKey={}", key, otherKey, destinationKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKey={};destinationKey={}失败！失败信息：{}",  key, otherKey, destinationKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long intersectAndStore(String key, Collection<String> otherKeys, String destinationKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.intersectAndStore(key, otherKeys, destinationKey);
            log.info("操作成功！key={};otherKeys={};destinationKey={}", key, Arrays.toString(otherKeys.toArray()), destinationKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKey={};destinationKey={}失败！失败信息：{}",  key, otherKeys, destinationKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> union(String key, String otherKey) {
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Set<String> returnValue = setOperations.union(key, otherKey);
            log.info("操作成功！key={};otherKeys={}", key, otherKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKey={}失败！失败信息：{}",  key, otherKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> union(String key, Collection<String> otherKeys) {
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Set<String> returnValue = setOperations.union(key, otherKeys);
            log.info("操作成功！key={};otherKeys={}", key, Arrays.toString(otherKeys.toArray()));
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKeys={}失败！失败信息：{}",  key, Arrays.toString(otherKeys.toArray()), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long unionAndStore(String key, String otherKey, String destinationKey) {
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.unionAndStore(key, otherKey, destinationKey);
            log.info("操作成功！key={};otherKeys={}", key, otherKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKeys={}失败！失败信息：{}",  key, otherKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long unionAndStore(String key, Collection<String> otherKeys, String destinationKey) {
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.unionAndStore(key, otherKeys, destinationKey);
            log.info("操作成功！key={};otherKeys={}", key, Arrays.toString(otherKeys.toArray()));
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKeys={}失败！失败信息：{}",  key, Arrays.toString(otherKeys.toArray()), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> difference(String key, String otherKey) {
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Set<String> returnValue = setOperations.difference(key, otherKey);
            log.info("操作成功！key={};otherKeys={}", key, otherKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKeys={}失败！失败信息：{}",  key, otherKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> difference(String key, Collection<String> otherKeys) {
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Set<String> returnValue = setOperations.difference(key, otherKeys);
            log.info("操作成功！key={};otherKeys={}", key, Arrays.toString(otherKeys.toArray()));
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKeys={}失败！失败信息：{}",  key, otherKeys, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long differenceAndStore(String key, String otherKey, String destinationKey) {
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.differenceAndStore(key, otherKey, destinationKey);
            log.info("操作成功！key={};otherKey={}", key, otherKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKey={}失败！失败信息：{}",  key, otherKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long differenceAndStore(String key, Collection<String> otherKeys, String destinationKey) {
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.differenceAndStore(key, otherKeys, destinationKey);
            log.info("操作成功！key={};otherKeys={}", key, Arrays.toString(otherKeys.toArray()));
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKeys={}失败！失败信息：{}",  key, Arrays.toString(otherKeys.toArray()), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> members(String key, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuffer keyStr = null;
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            if (isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else{
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            Set<String> returnValue = setOperations.members(keyStr.toString());
            log.info("操作成功！key={}", keyStr.toString());
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}",  keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public String randomMember(String key, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuffer keyStr = null;
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            if (isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else{
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            String returnValue = setOperations.randomMember(keyStr.toString());
            log.info("操作成功！key={}", keyStr.toString());
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}",  keyStr.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> distinctRandomMembers(String key, long count, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuffer keyStr = null;
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            if (isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else{
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            Set<String> returnValue = setOperations.distinctRandomMembers(keyStr.toString(), count);
            log.info("操作成功！key={},count={}", keyStr.toString(), count);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={},count={}失败！失败信息：{}",  key, count, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public List<String> randomMembers(String key, long count, boolean isTimeOut) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuffer keyStr = null;
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            if (isTimeOut){
                keyStr.append(TIMEOUT_PREFIX).append(key);
            }else{
                keyStr.append(TIMEEVER_PREFIX).append(key);
            }
            List<String> returnValue = setOperations.randomMembers(keyStr.toString(), count);
            log.info("操作成功！key={},count={}", keyStr.toString(), count);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={},count={}失败！失败信息：{}",  key, count, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
}
