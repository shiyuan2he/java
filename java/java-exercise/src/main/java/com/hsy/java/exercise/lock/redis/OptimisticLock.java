package com.hsy.java.exercise.lock.redis;
import com.hsy.java.exercise.lock.dao.TStockDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.distributed.lock.service
 * @date 2018/7/20 14:55
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class OptimisticLock {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private TStockDaoImpl stockDao;
    String key = "product:num";
    String clientList = "client:list";//抢购到商品的顾客列表
    /**
     * @description <p>
     *     redis实现分布式锁
     *         1.multi，开启Redis的事务，置客户端为事务态。
     *         2.exec，提交事务，执行从multi到此命令前的命令队列，置客户端为非事务态。
     *         3.discard，取消事务，置客户端为非事务态。
     *         4.watch,监视键值对，作用是如果事务提交exec时发现监视的键值对发生变化，事务将被取消。
     * </p>
     * @author heshiyuan
     * @date 2018/7/22 18:19
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public void redisLock(){
        /*logger.info("开始业务");
        String key = "TO:redisLock";
        Jedis jedis = RedisUtils.getInstance().getJedis();
        jedis.watch(key); //如果事务提交exec时发现监视的键值对发生变化，事务将被取消
        int num = Integer.parseInt(jedis.get(key));
        if(num > 0){
            Transaction transaction = jedis.multi();
            //(Jedis) transaction.set(key, String.valueOf(num-1));

        }
        logger.info("结束业务");*/
    }
}
