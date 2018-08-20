package com.hsy.java.exercise.lock.redis;

import com.hsy.java.base.utils.ConcurrentMock;
import com.hsy.java.exercise.lock.redis.RedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.exercise.lock
 * @date 2018/7/31 22:40
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class OptimisticLockTest extends ConcurrentMock {
    String key = "product:num";
    String clientList = "client:list";//抢购到商品的顾客列表
    @Test
    public void redisLock() throws InterruptedException {
        execute();
    }
    private void testLock(){
        long startTime = System.currentTimeMillis();
        initProduct();
        printResult();
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("程序运行时间 ： " + (int)time + "ms");
    }

    /**
     * 打印抢购结果
     */
    public void printResult() {
        Jedis jedis = RedisUtils.getInstance().getJedis();
        Set<String> set = jedis.smembers(clientList);
        int i = 1;
        for (String value : set) {
            System.out.println("第" + i++ + "个抢到商品，"+value + " ");
        }
        RedisUtils.getInstance().returnResource(jedis);
    }

    private void initProduct() {
        int prdNum = 1;//商品个数
        Jedis jedis = RedisUtils.getInstance().getJedis();
        if (jedis.exists(key)) {
            jedis.del(key);
        }
        if (jedis.exists(clientList)) {
            jedis.del(clientList);
        }
        jedis.set(key, String.valueOf(prdNum));//初始化商品
        RedisUtils.getInstance().returnResource(jedis);
    }

    @Override
    public int getConcurrentNo() {
        return 100;
    }

    @Override
    public void doMethod() {
        testLock();
    }

    @Override
    public int getSleepTime() {
        return 10000;
    }
}