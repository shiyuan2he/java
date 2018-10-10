package com.hsy.java.cache.redis.spring.string;

import com.askingdata.y.cache.redis.spring.ISpringRedisInterface;

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
    Long add(String key, String value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:26
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long add(String key, String... value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:27
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long add(String key, long timeOut, String value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:27
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long add(String key, long timeOut, TimeUnit timeUnit, String value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:27
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long add(String key, long timeOut, String... value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:27
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long add(String key, long timeOut, TimeUnit timeUnit, String... value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:55
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all. 
     *  @price 3毛    微信：hewei1109
     */
    Long remove(String key, String value);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:55
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long remove(String key, String... value);
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
     * @description <p>将key下的value移动到destinationKey下</p>
     * <p>此操作不会自动拼接上TO、NO。请注意</p>
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
    Long size(String key);
    /**
     * @description <p>判断某个value是否是这个key中的元素</p>
     * @author heshiyuan
     * @dateTime 2018/9/26 20:59
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    boolean isMember(String key, String value);
    /**
     * @description <p>将两个key对应的数据合并返回</p>
     * <p>请注意：此key不会自动拼接NO、TO等前缀</p>
     * @author heshiyuan
     * @dateTime 2018/9/27 15:25
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Set<String> intersect(String key, String otherKey);
    /**
     * @description <p>将多个key对应的数据合并返回</p>
     * <p>请注意：此key不会自动拼接NO、TO等前缀</p>
     * @author heshiyuan
     * @dateTime 2018/9/27 15:29
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Set<String> intersect(String key, Collection<String> otherKeys);
    /**
     * @description <p>交叉存储于第三个key</p>
     * @param key 第一个key
     * @param otherKey 第二个key
     * @param destinationKey 目标key
     * @return Long 返回交叉成功的个数
     * @author heshiyuan
     * @dateTime 2018/9/27 15:29
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long intersectAndStore(String key, String otherKey, String destinationKey);
    /**
     * @description <p>交叉存储很多key到目的key</p>
     * @author heshiyuan
     * @dateTime 2018/9/27 15:31
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long intersectAndStore(String key, Collection<String> otherKeys, String destinationKey);
    /**
     * @description <p>合并</p>
     * @author heshiyuan
     * @dateTime 2018/9/27 15:33
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Set<String> union(String key, String otherKey);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 15:34
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Set<String> union(String key, Collection<String> otherKeys);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 15:35
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long unionAndStore(String key, String otherKey, String destinationKey);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 15:35
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long unionAndStore(String key, Collection<String> otherKeys, String destinationKey);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 15:40
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Set<String> difference(String key, String otherKey);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 15:41
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Set<String> difference(String key, Collection<String> otherKeys);
   /**
    * @description <p></p>
    * @author heshiyuan
    * @dateTime 2018/9/27 15:42
    * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
    *  I'm glad to share my knowledge with you all.
    *  @price 3毛    微信：hewei1109
    */
    Long differenceAndStore(String key, String otherKey, String destinationKey);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 15:42
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Long differenceAndStore(String key, Collection<String> otherKeys, String destinationKey);
    /**
     * @description <p>查出某个key的成员</p>
     * @author heshiyuan
     * @dateTime 2018/9/27 15:43
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Set<String> members(String key);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 15:45
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    String randomMember(String key);
    /**
     * @description <p>指定key的随机count个元素</p>
     * @author heshiyuan
     * @dateTime 2018/9/27 15:46
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    Set<String> distinctRandomMembers(String key, long count);
    /**
     * @description <p></p>
     * @author heshiyuan
     * @dateTime 2018/9/27 15:49
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
    List<String> randomMembers(String key, long count);
    /**
     * @description <p>暂不实现</p>
     * @author heshiyuan
     * @dateTime 2018/9/27 15:50
     * @copyright Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
     *  I'm glad to share my knowledge with you all.
     *  @price 3毛    微信：hewei1109
     */
//    Cursor<String> scan(String var1, ScanOptions var2);
}
