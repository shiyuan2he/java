package com.hsy.java.cache.redis.spring.string.base;

import com.askingdata.y.cache.redis.spring.ISpringRedisInterface;
import com.askingdata.y.cache.redis.spring.base.SpringBase;
import com.askingdata.y.enums.CacheEnum;
import com.askingdata.y.exception.CacheException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
public abstract class SpringStringBase extends SpringBase implements ISpringRedisInterface {
    // 字符型
    public abstract StringRedisTemplate getStringRedisTemplate();

    public Boolean expire(String key, long timeOut) {
        return this.expire(key, timeOut, TimeUnit.SECONDS);
    }

    public Boolean expire(String key, long timeOut, TimeUnit timeUnit) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {

            Boolean returnValue = getStringRedisTemplate().expire(key, timeOut, timeUnit);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    public void delete(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return;
        }

        try {

            getStringRedisTemplate().delete(key);
            log.info("操作成功！key={}", key);
            return;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    public void delete(boolean isTimeOut, String... keys) {
        if (null != keys && keys.length != 0) {
            for (int i = 0; i < keys.length; i++) {
                if (isTimeOut) {
                    keys[i] += TIMEOUT_PREFIX;
                } else {
                    keys[i] += TIMEEVER_PREFIX;
                }
            }
            try {
                this.getStringRedisTemplate().delete(Arrays.asList(keys));
                log.info("操作成功！key={}", Arrays.toString(keys));
            } catch (Exception e) {
                log.error("操作失败！key={},失败信息：{}", Arrays.toString(keys), e);
                throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
            }
        } else {
            throw new IllegalArgumentException("指定删除的key不能为空");
        }
    }

    @Override
    public void delete(List<String> keys) {
        if (null == keys || keys.size() <= 0) {
            log.error("key is null");
            return;
        }
        try {
            getStringRedisTemplate().delete(keys);
            log.info("操作成功！key={}", Arrays.toString(keys.toArray()));
            return;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", Arrays.toString(keys.toArray()), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public void deleteByPrefix(String pattern) {
        this.deleteByPattern(pattern+"*");
    }

    @Override
    public void deleteBySuffix(String pattern) {
        this.deleteByPattern("*"+pattern);
    }

    @Override
    public void deleteByPattern(String pattern) {
        if (StringUtils.isBlank(pattern)) {
            log.error("key is null");
            return;
        }
        try {
            log.info("正则范式：key={}", pattern);
            Set<String> keys = this.getStringRedisTemplate().keys(pattern);
            keys.parallelStream().forEach(key -> log.info("即将删除key={}", key));
            getStringRedisTemplate().delete(keys);
            log.info("操作成功！");
            return;
        } catch (Exception e) {
            log.error("操作失败！异常信息：{}", e);
            return;
        }
    }

    /**
     * @return boolean 是否删除成功
     * @description <p>删除缓存</p>
     * @author heshiyuan
     * @date 2018/7/25 8:37
     */
    public void clear() {
        log.info("30秒后即将清理全部缓存");
        try {
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            log.error("操作失败！异常信息：{}", e);
        }
        this.deleteByPattern("*");
    }
}
