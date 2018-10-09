package com.hsy.java.cache.redis.spring.string;

import com.hsy.java.cache.redis.spring.ISpringRedisInterface;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.ScanOptions;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IHashOperationsBase extends ISpringRedisInterface {
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:55
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Long delete(String key, boolean isTimeOut, Object... hashKey);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:55
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Boolean hasKey(String key, Object hashKey, boolean isTimeOut);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:55
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    String get(String key, Object hashKey, boolean isTimeOut);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:56
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    List<String> multiGet(String key, Collection<Object> hashKeys, boolean isTimeOut);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:56
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Long increment(String key, Object hashKey, long delta, boolean isTimeOut);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:56
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Double increment(String key, Object hashKey, double delta, boolean isTimeOut);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:56
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Set<Object> keys(String key, boolean isTimeOut);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:56
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Long size(String key, boolean isTimeOut);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:56
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    void putAll(String key, Map<Object, String> hashKeyMapValue, boolean isTimeOut);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:56
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    void put(String key, Object hashKey, String hashValue, boolean isTimeOut);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 20:11
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Boolean putIfAbsent(String key, Object hashKey, String hashValue, boolean isTimeOut);
    /**
     * @description <p>返回key下的hashKey list</p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:53
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    List<String> values(String key, boolean isTimeOut);
    /**
     * @description <p>返回key下的hashKey，hashValue</p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:54
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Map<Object, String> entries(String key, boolean isTimeOut);

//    Cursor<Map.Entry<String , String >> scan(String var1, ScanOptions var2);

//    RedisOperations<String, String> getOperations();
}
