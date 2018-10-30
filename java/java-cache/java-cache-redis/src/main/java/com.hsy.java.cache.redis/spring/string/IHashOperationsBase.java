package com.hsy.java.cache.redis.spring.string;

import com.hsy.java.cache.redis.spring.ISpringRedisInterface;

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
    Long delete(String key, String... hashKey);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:55
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Boolean hasKey(String key, String hashKey);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:55
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    String get(String key, String hashKey);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:56
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    List<String> multiGet(String key, Collection<String> hashKeys);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:56
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Long increment(String key, String hashKey, long delta);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:56
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Double increment(String key, String hashKey, double delta);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:56
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Set<String> keys(String key);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:56
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Long size(String key);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:56
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    void putAll(String key, Map<String, String> hashKeyMapValue);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:56
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    void put(String key, String hashKey, String hashValue);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 20:11
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Boolean putIfAbsent(String key, String hashKey, String hashValue);
    /**
     * @description <p>返回key下的hashKey list</p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:53
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    List<String> values(String key);
    /**
     * @description <p>返回key下的hashKey，hashValue</p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:54
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Map<String, String> entries(String key);

//    Cursor<Map.Entry<String , String >> scan(String var1, ScanOptions var2);

//    RedisOperations<String, String> getOperations();
}
