package com.hsy.java.cache.redis.spring.object;

import com.hsy.java.cache.redis.spring.ISpringRedisInterface;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.cache.redis.spring.object
 * @date 08/10/2018 4:49 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface IHashOperationsBase extends ISpringRedisInterface {
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 6:08 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Long delete(String key,boolean isTimeOut, Object... objects);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 6:08 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Boolean hasKey(String key,boolean isTimeOut, Object hashKey);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 6:08 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Object get(String key, boolean isTimeOut,Object hashKey);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 6:08 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    java.util.List<Object> multiGet(String key, boolean isTimeOut, Collection<Object> collection);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 6:08 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Long increment(String key, boolean isTimeOut, Object hashKey, long delta);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 6:08 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Double increment(String key, boolean isTimeOut, Object hashKey, double delta);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 6:08 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Set<Object> keys(String key, boolean isTimeOut);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 6:08 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Long size(String key, boolean isTimeOut);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 6:08 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    void putAll(String key, boolean isTimeOut, Map<Object, Object> map);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 6:08 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    void put(String key, boolean isTimeOut, Object hashKey, Object hashValue);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 6:09 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Boolean putIfAbsent(String key, boolean isTimeOut, Object hashKey, Object hashValue);
    /**
     * @description <p></p>
     * @param 
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 6:09 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    List<Object> values(String key, boolean isTimeOut);
    /**
     * @description <p></p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan 
     * @date 08/10/2018 6:09 PM 
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    Map<Object, Object> entries(String key, boolean isTimeOut);
}
