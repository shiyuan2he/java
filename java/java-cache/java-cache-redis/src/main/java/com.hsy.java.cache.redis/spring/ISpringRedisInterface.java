package com.hsy.java.cache.redis.spring;
import com.askingdata.y.cache.base.ICacheBase;

import java.util.List;
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
    Boolean expire(String key, long timeout);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:40
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Boolean expire(String key, long timeout, TimeUnit timeUnit);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/28 17:00
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    void delete(String key);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/28 17:02
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    void delete(boolean isTimeOut, String... key);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/28 17:06
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    void delete(List<String> keys);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/28 17:14
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    void deleteByPrefix(String pattern);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/28 17:14
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    void deleteBySuffix(String pattern);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/28 17:14
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    void deleteByPattern(String pattern);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/28 17:15
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    void clear();
}
