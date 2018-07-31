package com.hsy.java.exercise.lock;
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
public class LockServiceImpl {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private TStockDaoImpl stockDao;

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
        logger.info("开始业务");
        String key = "TO:redisLock";
        Jedis jedis = RedisUtils.getInstance().getJedis();
        jedis.watch(key); //如果事务提交exec时发现监视的键值对发生变化，事务将被取消
        Transaction transaction = jedis.multi();
        if(redisRepository.getRedisTemplate().getConnectionFactory().getConnection().setNX(key.getBytes(), "redisLock".getBytes())){
            redisRepository.getRedisTemplate().getConnectionFactory().getConnection().expire(key.getBytes(), 1000 * 300);
            logger.info("进入lock区");
            logger.info("获取到数据库锁");
            if (stockDao.getCount(1l) > 0) {
                // 减库存
                stockDao.reduce();
            }
            redisRepository.getRedisTemplate().getConnectionFactory().getConnection().del(key.getBytes());
        }else{
            logger.info("没有拿到锁，请求返回");
        }
        logger.info("结束业务");
    }
}
