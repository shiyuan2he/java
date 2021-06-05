package org.hsy.java.cache.redis.spring.string;
import org.hsy.java.cache.redis.spring.ISpringRedisInterface;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface IValueOperationsBase extends ISpringRedisInterface {
    /**
     * @param key   键
     * @param value 值
     * @return boolean 保存是否成功
     * @description <p>保存字符串类型的值，不过期</p>
     * @author heshiyuan
     * @date 2018/7/23 21:59
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    boolean set(String key, String value) ;
    /**
     * @param key     键
     * @param value   值
     * @param timeOut 过期时间 默认过期单位是秒
     * @return boolean 是否设值成功
     * @description <p>采用默认 过期单位指定过期时间的值,此方法经测试有问题，不建议使用</p>
     * @author heshiyuan
     * @date 2018/7/23 22:18
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    boolean set(String key, String value, long timeOut);
    /**
     * @param key      键
     * @param value    值
     * @param timeOut  过期时间
     * @param timeUnit 过期单位
     * @return boolean 设值是否成功
     * @description <p>给key设值值、过期时间</p>
     * @author heshiyuan
     * @date 2018/7/23 22:48
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    boolean set(String key, String value, long timeOut, TimeUnit timeUnit);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:19
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    boolean setIfAbsent(String key, String value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:19
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    boolean setIfAbsent(String key, String value, long timeOut);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:20
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    boolean setIfAbsent(String key, String value, long timeOut, TimeUnit timeUnit);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:20
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    int append(String key, String value);

    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:20
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    int append(String key, String value, long timeOut);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:20
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    int append(String key, String value, long timeOut, TimeUnit timeUnit);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:20
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    void multiSet(Map<String, String> keyValue);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:20
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    void multiSet(Map<String, String> keyValue, long timeOut);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:20
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    void multiSet(Map<String, String> keyValue, long timeOut, TimeUnit timeUnit);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:20
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    boolean multiSetIfAbsent(Map<String, String> keyValue);
    /**
     * @description <p>是否使用原生的api</p>
     * @author heshiyuan
     * @dateTime 2018/9/26 19:58
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    boolean multiSetIfAbsent(Map<String, String> keyValue, boolean isOriginal);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:20
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    boolean multiSetIfAbsent(Map<String, String> keyValue, long timeOut);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:20
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    boolean multiSetIfAbsent(Map<String, String> keyValue, long timeOut, TimeUnit timeUnit);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:20
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    String get(String key);

    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:20
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    String getAndSet(String key, String value);

    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:20
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    List<String> multiGet(List<String> keyList);

    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:21
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    long increment(String key, long value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:21
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    long increment(String key, long value, long timeLive);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:21
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    long increment(String key, long value, long timeLive, TimeUnit timeUnit);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:21
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    double increment(String key, double value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:21
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    double increment(String key, double value, long timeLive);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:21
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    double increment(String key, double value, long timeLive, TimeUnit timeUnit);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:21
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    long size(String key);

    /**
     * @description <p>
     *     暂时不实现其接口
     *     对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)。
     * 位的设置或清除取决于 value 参数，可以是 0 也可以是 1 。
     * 当 key 不存在时，自动生成一个新的字符串值。
     * 字符串会进行伸展(grown)以确保它可以将 value 保存在指定的偏移量上。当字符串值进行伸展时，空白位置以 0 填充。
     * offset 参数必须大于或等于 0 ，小于 2^32 (bit 映射被限制在 512 MB 之内)。
     * </p>
     * @author heshiyuan
     * 2018/9/26 19:26
     */
//    boolean setBit(String key, long offset, boolean value);

//    boolean getBit(String key, long offset);
}
