package com.hsy.java.util.cache.redis;

import com.hsy.java.base.exception.CacheException;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p>缓存工具类接口</p>
 * @path java/com.hsy.java.util.cache.redis
 * @date 25/09/2017 3:26 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface ISpringRedisCache {
    /**
     * @description <p>添加进缓存当中</p>
     * @param key 存入缓存的key
     * @param obj 待存入redis的值对象
     * @return 存入缓存是否成功
     * @author heshiyuan
     * @date 25/09/2017 3:27 PM
     */
    <T> boolean putCache(String key, T obj) throws CacheException ;
    /**
     * @description <p></p>
     * @param key 存入缓存的key
     * @param obj 待存入redis的值对象
     * @param expireTime 缓存过期时间
     * @return 存入缓存是否成功
     * @author heshiyuan
     * @date 25/09/2017 3:29 PM
     */
    <T> boolean putCacheWithExpireTime(String key, T obj, final long expireTime) throws CacheException;

    /**
     * @description <p>将list添加进缓存</p>
     * @param key 存入缓存的key
     * @param objList 存入缓存的list
     * @return 存入缓存是否成功
     * @author heshiyuan
     * @date 25/09/2017 4:07 PM
     */
    <T> boolean putListCache(String key, List<T> objList) throws CacheException;
    /**
     * @description <p>将list添加进缓存，带缓存过期时间</p>
     * @param key 存入缓存的key
     * @param objList  存入缓存的list
     * @param expireTime  缓存过期时间
     * @return 存入缓存是否成功
     * @author heshiyuan
     * @date 25/09/2017 4:09 PM
     */
    <T> boolean putListCacheWithExpireTime(String key, List<T> objList, final long expireTime) throws CacheException;
    /**
     * @description <p></p>
     * @param key 存入缓存的key
     * @param targetClass 存进去的数据类型
     * @return 存入的数据
     * @author heshiyuan
     * @date 25/09/2017 4:18 PM
     */
    <T> T getCache(final String key, Class<T> targetClass) throws CacheException;
    /**
     * @description <p></p>
     * @param key 存入缓存的key
     * @param targetClass 存进去的数据类型
     * @return 存入的list数据
     * @author heshiyuan
     * @date 25/09/2017 4:18 PM
     */
    <T> List<T> getListCache(final String key, Class<T> targetClass) throws CacheException;
    /**
     * @description <p>根据key精确删除数据</p>
     * @param key
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
    void deleteCacheByKey(String key) throws CacheException;
    /**
     * @description <p>根据key精确删除数据</p>
     * @param key
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
    void deleteCacheByKeys(String... key) throws CacheException;
    /**
     * @description <p>根据key模糊删除数据</p>
     * @param pattern
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
    void deleteCacheWithPattern(String pattern) throws CacheException;
    /**
     * @description <p>删除所有key</p>
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
    void clearCache() throws CacheException;
    /**
     * @description <p>根据前缀模糊删除</p>
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
    void deleteByPrefix(String prex)throws CacheException;
    /**
     * @description <p>根据后缀模糊删除</p>
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
    void deleteBySuffix(String suffix) throws CacheException;
}
