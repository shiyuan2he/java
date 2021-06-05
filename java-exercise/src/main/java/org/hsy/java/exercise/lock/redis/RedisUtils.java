package org.hsy.java.exercise.lock.redis;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.exercise.lock
 * @date 2018/7/30 16:07
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class RedisUtils {
    private static RedisUtils redisUtils = new RedisUtils();
    /*@Override
    public JedisPool getJedisPool() {
        JedisPool pool = new JedisPool();
        JedisPoolConfig config = new JedisPoolConfig();
        // 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
        // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
        config.setMaxTotal(10000);
        // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(2000);
        // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        config.setMaxWaitMillis(1000 * 100);
        config.setTestOnBorrow(true);
        pool = new JedisPool(config, "10.62.245.11", 6379, 100000);
        return pool;
    }*/

    public static RedisUtils getInstance(){
        return redisUtils ;
    }
}
