package com.hsy.java.cache.redis.spring.string;
import com.hsy.java.cache.redis.spring.ISpringRedisInterface;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface ISetOperationsBase extends ISpringRedisInterface {
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:26
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    long add(String key, String value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:26
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    long add(String key, String... value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:27
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    long add(String key, long timeOut, String value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:27
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    long add(String key, long timeOut, TimeUnit timeUnit, String value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:27
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    long add(String key, long timeOut, String... value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:27
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    long add(String key, long timeOut, TimeUnit timeUnit, String... value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:55
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    long remove(String key, String value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:55
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    long remove(String key, String... value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:56
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    String pop(String key);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:59
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    boolean move(String key, String value, String destinationKey);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:59
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    long size(String key);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:59
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    boolean isMember(String key, String value);

    Set<String> intersect(String var1, String var2);

    Set<String> intersect(String var1, Collection<String> var2);

    Long intersectAndStore(String var1, String var2, String var3);

    Long intersectAndStore(String var1, Collection<String> var2, String var3);

    Set<String> union(String var1, String var2);

    Set<String> union(String var1, Collection<String> var2);

    Long unionAndStore(String var1, String var2, String var3);

    Long unionAndStore(String var1, Collection<String> var2, String var3);

    Set<String> difference(String var1, String var2);

    Set<String> difference(String var1, Collection<String> var2);

    Long differenceAndStore(String var1, String var2, String var3);

    Long differenceAndStore(String var1, Collection<String> var2, String var3);

    Set<String> members(String var1);

    String randomMember(String var1);

    Set<String> distinctRandomMembers(String var1, long var2);

    List<String> randomMembers(String var1, long var2);

    Cursor<String> scan(String var1, ScanOptions var2);
}
