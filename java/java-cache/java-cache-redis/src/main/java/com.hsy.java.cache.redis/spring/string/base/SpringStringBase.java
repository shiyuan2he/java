package com.hsy.java.cache.redis.spring.string.base;

import com.hsy.java.cache.redis.spring.ISpringRedisInterface;
import com.hsy.java.cache.redis.spring.base.SpringBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.*;

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

    public boolean expire(String key, long timeout){
        return getStringRedisTemplate().expire(key, timeout, TimeUnit.SECONDS);
    }
    public boolean expire(String key, long timeout, TimeUnit timeUnit){
        return getStringRedisTemplate().expire(key, timeout, timeUnit);
    }

    public boolean delete(String key, boolean isTimeOut){
//        return getStringRedisTemplate().delete(key);
        return false;
    }
}
