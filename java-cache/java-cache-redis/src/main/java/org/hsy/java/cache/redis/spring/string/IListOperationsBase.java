package org.hsy.java.cache.redis.spring.string;
import org.hsy.java.cache.redis.spring.ISpringRedisInterface;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface IListOperationsBase extends ISpringRedisInterface {
    /**
     * @description <p>取值 索引start->end</p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:05
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    List<String> range(String key, long start, long end);

    void trim(String key, long start, long end);
    /**
     * @description <p>返回此key的size</p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:06
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long size(String key);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:11
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long leftPush(String key, String value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:11
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long leftPushAll(String key, String... value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:12
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long leftPushAll(String key, Collection<String> value);

    Long leftPushIfPresent(String var1, String var2);

    Long leftPush(String var1, String var2, String var3);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:14
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long rightPush(String key, String value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:14
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long rightPushAll(String key, String... value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:15
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long rightPushAll(String key, Collection<String> value);

    Long rightPushIfPresent(String var1, String var2);

    Long rightPush(String var1, String var2, String var3);
    /**
     * @description <p>指定key的第index个值设置成value</p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:15
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    void set(String key, long index, String value);
    /**
     * TODO
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:16
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long remove(String key, long index, Object value);
    /**
     * @description <p>指定key索引index处的值</p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:18
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    String index(String key, long index);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:19
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    String leftPop(String key);
    /**
     * @author heshiyuan
     * 2018/9/27 19:20
     * TODO
     */
    String leftPop(String var1, long var2, TimeUnit var4);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:20
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    String rightPop(String key);

    String rightPop(String var1, long var2, TimeUnit var4);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:21
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    String rightPopAndLeftPush(String sourceKey, String destinationKey);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 19:23
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    String rightPopAndLeftPush(String var1, String var2, long var3, TimeUnit var5);
}
