package com.hsy.java.cache.redis.spring;

import com.hsy.java.cache.base.ICacheBase;

import java.util.concurrent.TimeUnit;

public interface ISpringRedisInterface extends ICacheBase {
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:40
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    boolean expire(String key, long timeout);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:40
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    boolean expire(String key, long timeout, TimeUnit timeUnit);

    boolean delete(String key, boolean isTimeOut);
}
