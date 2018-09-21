package com.hsy.java.cache.spring;
import com.hsy.java.cache.ICacheBase;

import java.util.concurrent.TimeUnit;
public interface ISpringRedisInterface extends ICacheBase {
    /**
     * @param key   键
     * @param value 值
     * @return boolean 保存是否成功
     * @description <p>保存字符串类型的值</p>
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
     * @param timeOut 过期时间
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

    String get(String key);
    String get(String key, boolean isTimeOutkey);
}
