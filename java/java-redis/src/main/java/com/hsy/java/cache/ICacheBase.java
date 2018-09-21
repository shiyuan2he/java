package com.hsy.java.cache;
/**
 * @author heshiyuan
 * @description <p>缓存规范接口</p>
 * @path java/com.hsy.java.util.cache
 * @date 2018/7/25 14:39
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface ICacheBase {
    /**
     * @description <p>接口里定义的属性是 static， final的</p>
     * @author heshiyuan
     * 2018/9/21 15:36
     */
    String TIMEOUT_PREFIX = "TO:";//有过期时间的key前缀
    String TIMEEVER_PREFIX = "NO:";// 没有过期时间的key前缀
    String LOCK_PREFIX = "LOCK:";// 锁key前缀
}
