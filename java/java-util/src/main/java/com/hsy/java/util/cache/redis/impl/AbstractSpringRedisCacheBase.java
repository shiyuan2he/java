package com.hsy.java.util.cache.redis.impl;

import com.hsy.java.enums.CacheEnum;
import com.hsy.java.exception.cache.CacheException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.*;

import javax.annotation.PostConstruct;
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
public abstract class AbstractSpringRedisCacheBase {

    private final Logger logger = LoggerFactory.getLogger(this.getClass()) ;
    protected final static String TIMEOUT_PREFIX = "TO:";
    protected final static String TIMEEVER_PREFIX = "NO:";
    protected final static String LOCK_PREFIX = "LOCK:";
    protected void consoleLog(String key, long timeOut, TimeUnit timeUnit){
        if (0!=timeOut && null!=timeUnit){
            if(TimeUnit.DAYS == timeUnit){
                logger.info("设值缓存成功！key：{};过期时间：{}天；", key, timeOut);
            }else if(TimeUnit.HOURS == timeUnit){
                logger.info("设值缓存成功！key：{};过期时间：{}小时；", key, timeOut);
            }else if(TimeUnit.MINUTES == timeUnit){
                logger.info("设值缓存成功！key：{};过期时间：{}分钟；", key, timeOut);
            }else if(TimeUnit.SECONDS == timeUnit){
                logger.info("设值缓存成功！key：{};过期时间：{}秒；", key, timeOut);
            }else{
                logger.info("设值缓存成功！key：{};过期时间：{}毫秒；", key, timeOut);
            }
        }else if(0!=timeOut && null==timeUnit){
            logger.info("设值缓存成功！key：{};过期时间：{}秒；", key, timeOut);
        }else{
            logger.info("设值缓存成功！key：{};", key);
        }
    }
}
