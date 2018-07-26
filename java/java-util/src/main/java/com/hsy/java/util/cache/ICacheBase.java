package com.hsy.java.util.cache;

import com.hsy.java.exception.cache.CacheException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author heshiyuan
 * @description <p>缓存接口</p>
 * @path java/com.hsy.java.util.cache
 * @date 2018/7/25 14:39
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface ICacheBase {

    /**
     * 自增
     * @param key
     * @param value
     * @param liveTime
     * @param timeUnit
     * @return 返回自增之后的值
     * @throws CacheException
     */
    //Long incrTimeOut(String key,Long value,final long liveTime,final TimeUnit timeUnit) throws CacheException;

    /**
     * 自增不超时
     * @param key
     * @param value
     * @return
     * @throws CacheException
     */
//    Long incrNoTimeOut(String key,Long value) throws CacheException;

    /**
     * 保存或者更新
     * 温馨提示：数据的修改是直接失效缓存数据，再修改DB内容，但由于网络或者其他问题导致缓存数据没有清理，造成了脏数据。
     * @param key
     * @param value
     * @param liveTime 存活时间
     * @param timeUnit 存活时间单位
     * @throws CacheException
     */
//    <V> void saveOrUpdateTimeOut(final String key, final V value,final long liveTime,final TimeUnit timeUnit) throws CacheException;

    /**
     * 保存或更新不设置超时时间
     * @param key
     * @param value
     * @throws CacheException
     */
//    <V> void saveOrUpdateNoTimeOut(final String key, final V value) throws CacheException;

    /**
     * @param key
     * @param clazz
     * @return
     * @throws CacheException
     */
//     <V> V get(String key,Class<V> clazz,boolean isTimeOutKey)  throws CacheException;

    /**
     * 获取List
     * @param key
     * @param clazz
     * @return
     * @throws CacheException
     */
//     <V> List<V> getList( String key,Class<V> clazz,boolean isTimeOutKey)  throws CacheException;

    /**
     * @description <p>添加进缓存当中</p>
     * @param key 存入缓存的key
     * @param obj 待存入redis的值对象
     * @return 存入缓存是否成功
     * @author heshiyuan
     * @date 25/09/2017 3:27 PM
     */
//    <V> boolean putCache(String key, V obj) throws CacheException;
    /**
     * @description <p></p>
     * @param key 存入缓存的key
     * @param obj 待存入redis的值对象
     * @param expireTime 缓存过期时间
     * @return 存入缓存是否成功
     * @author heshiyuan
     * @date 25/09/2017 3:29 PM
     */
//    <V> boolean putCacheWithExpireTime(String key, V obj, final long expireTime) throws CacheException;

    /**
     * @description <p>将list添加进缓存</p>
     * @param key 存入缓存的key
     * @param objList 存入缓存的list
     * @return 存入缓存是否成功
     * @author heshiyuan
     * @date 25/09/2017 4:07 PM
     */
//    <V> boolean putListCache(String key, List<V> objList) throws CacheException;
    /**
     * @description <p>将list添加进缓存，带缓存过期时间</p>
     * @param key 存入缓存的key
     * @param objList  存入缓存的list
     * @param expireTime  缓存过期时间
     * @return 存入缓存是否成功
     * @author heshiyuan
     * @date 25/09/2017 4:09 PM
     */
//    <V> boolean putListCacheWithExpireTime(String key, List<V> objList, final long expireTime) throws CacheException;
    /**
     * @description <p></p>
     * @param key 存入缓存的key
     * @param targetClass 存进去的数据类型
     * @return 存入的数据
     * @author heshiyuan
     * @date 25/09/2017 4:18 PM
     */
//    <V> V getCache(final String key, Class<V> targetClass) throws CacheException;
    /**
     * @description <p></p>
     * @param key 存入缓存的key
     * @param targetClass 存进去的数据类型
     * @return 存入的list数据
     * @author heshiyuan
     * @date 25/09/2017 4:18 PM
     */
//    <V> List<V> getListCache(final String key, Class<V> targetClass) throws CacheException;
    /**
     * @description <p>根据key精确删除数据</p>
     * @param key
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
//    void delete(String key) throws CacheException;
    /**
     * @description <p>根据key精确删除数据</p>
     * @param key
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
//    void delete(String... key) throws CacheException;
    /**
     * @description <p>根据key模糊删除数据</p>
     * @param pattern
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
//    void deleteWithPattern(String pattern) throws CacheException;
    /**
     * @description <p>删除所有key</p>
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
//    boolean clear() throws CacheException;
    /**
     * @description <p>根据前缀模糊删除</p>
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
//    void deleteByPrefix(String prex)throws CacheException;
    /**
     * @description <p>根据后缀模糊删除</p>
     * @author heshiyuan
     * @date 25/09/2017 4:25 PM
     */
//    void deleteBySuffix(String suffix) throws CacheException;
}
