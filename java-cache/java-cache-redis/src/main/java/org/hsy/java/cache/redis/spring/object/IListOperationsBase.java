package org.hsy.java.cache.redis.spring.object;
import org.hsy.java.cache.redis.spring.ISpringRedisInterface;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author heshiyuan
 * @description <p>list数据结构模型</p>
 * @path java/org.hsy.java.cache.redis.spring.object
 * @date 2018/9/30 14:57
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface IListOperationsBase extends ISpringRedisInterface {
    /**
     * @description <p></p>
     * @param key 键
     * @param start 开始索引
     * @param end 结束索引
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 08/10/2018 11:37 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    List<Object> range(String key, long start, long end);
    /**
     * @description <p></p>
     * @param key 键
     * @param start 开始索引
     * @param end 结束索引
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 08/10/2018 11:38 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    void trim(String key, long start, long end);
    /**
     * @description <p></p>
     * @param key 键
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:39 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Long size(String key);
    /**
     * @description <p></p>
     * @param key
     * @param value
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 08/10/2018 11:39 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Long leftPush(String key, String value);
    /**
     * @description <p></p>
     * @param key 键
     * @param vs 数组类型的值
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 08/10/2018 11:40 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Long leftPushAll(String key, Object... vs);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:40 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Long leftPushAll(String key, Collection<Object> collection);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:40 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Long leftPushIfPresent(String key, String value);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:40 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Long leftPush(String key, String pivot, String value);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:40 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Long rightPush(String key, String value);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:40 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Long rightPushAll(String key, Object... values);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:41 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Long rightPushAll(String key, Collection<Object> collection);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:41 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Long rightPushIfPresent(String key, String value);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:41 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Long rightPush(String key, String value, String otherValue);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:41 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    void set(String key, long index, String value);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:41 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Long remove(String key, long count, Object value);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:41 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Object index(String key, long index);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:41 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Object leftPop(String key);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:41 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Object leftPop(String key, long timeOut, TimeUnit timeUnit);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:41 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Object rightPop(String key);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:41 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Object rightPop(String key, long timeOut, TimeUnit timeUnit);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:41 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Object rightPopAndLeftPush(String key, String otherKey);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 11:41 AM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Object rightPopAndLeftPush(String key, String otherKey, long timeOut, TimeUnit timeUnit);
}
