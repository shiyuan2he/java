package org.hsy.java.exercise.lock.db;

import org.hsy.java.exercise.lock.dao.TLockDaoImpl;
import org.hsy.java.exercise.lock.dao.TStockDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heshiyuan
 * @description <p>悲观锁</p>
 * @path java/org.hsy.java.exercise.lock
 * @date 2018/7/31 23:01
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class PessimisticLock {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private TLockDaoImpl lockDao = new TLockDaoImpl();
    TStockDaoImpl stockDao = new TStockDaoImpl();

    private Map<String, String> owner = new HashMap<>();
    public void lockService(){
        String lock = "dbLock" ;
        //while (true){
            if (lockDao.insert(lock, "数据库实现分布式锁") > 0) {
                logger.info("获取到数据库锁");
                if (stockDao.getCount(1l) > 0) {
                    // 减库存
                    stockDao.reduce();
                    owner.put(Thread.currentThread().getName(), stockDao.getName(1l));
                    lockDao.delete(lock);
//                    break;
                }else{
//                    break;
                }
            } else {
                logger.info("没有拿到锁，请求返回");
            }
        //}
        printOwner();
    }

    private void printOwner() {
        owner.forEach((key, value) -> {
            logger.info("恭喜：{} 抢购：{}！", key, value);
        });
    }
}
