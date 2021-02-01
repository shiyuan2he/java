package com.hsy.java.exercise.lock.db;

import com.hsy.java.exercise.lock.dao.TLockDaoImpl;
import com.hsy.java.exercise.lock.dao.TStockDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author heshiyuan
 * @description <p>乐观锁实现分布式锁</p>
 * @path java/com.hsy.java.exercise.lock.db
 * @date 2018/8/2 15:16
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class OptimisticLock {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private TLockDaoImpl lockDao = new TLockDaoImpl();
    private TStockDaoImpl stockDao = new TStockDaoImpl();
    /**
     * @description <p>
     *     乐观锁实现
     *      业务开始之前拿到库存表得更新时间
     *      业务处理完之后，如果更新时间跟拿到的一致即可更新，否则就是过期数据
     * </p>
     * @param
     * @return
     * @author heshiyuan
     * @date 2018/8/2 15:59
     */
    public void lockService() throws InterruptedException {
        while (true){
            Date version = stockDao.getVersion(1);
            // 模拟业务处理业务得时间
            Thread.sleep(1000);
            Date nowVersion = stockDao.getVersion(1);
            if(version.compareTo(nowVersion) == 0){
                if(stockDao.getCount(1l)>0){
                    logger.info("版本一致,且有库存，准许更新");
                    stockDao.reduce();
                }else{
                    logger.info("暂无库存");
                    break;
                }
            }else{
                logger.info("历史数据，重新获取版本号");
            }
        }
    }
}
