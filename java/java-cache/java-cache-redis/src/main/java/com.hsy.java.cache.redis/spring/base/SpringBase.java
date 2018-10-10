package com.hsy.java.cache.redis.spring.base;
import com.askingdata.y.cache.redis.spring.ISpringRedisInterface;
import lombok.extern.slf4j.Slf4j;

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
public abstract class SpringBase implements ISpringRedisInterface {
    protected void consoleLog(String key, long timeOut, TimeUnit timeUnit){
        if (0!=timeOut && null!=timeUnit){
            if(TimeUnit.DAYS == timeUnit){
                log.info("设值缓存成功！key：{};过期时间：{}天；", key, timeOut);
            }else if(TimeUnit.HOURS == timeUnit){
                log.info("设值缓存成功！key：{};过期时间：{}小时；", key, timeOut);
            }else if(TimeUnit.MINUTES == timeUnit){
                log.info("设值缓存成功！key：{};过期时间：{}分钟；", key, timeOut);
            }else if(TimeUnit.SECONDS == timeUnit){
                log.info("设值缓存成功！key：{};过期时间：{}秒；", key, timeOut);
            }else{
                log.info("设值缓存成功！key：{};过期时间：{}毫秒；", key, timeOut);
            }
        }else if(0!=timeOut && null==timeUnit){
            log.info("设值缓存成功！key：{};过期时间：{}秒；", key, timeOut);
        }else{
            log.info("设值缓存成功！key：{};", key);
        }
    }
}
