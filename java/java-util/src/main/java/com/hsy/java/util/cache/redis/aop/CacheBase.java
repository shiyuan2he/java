package com.hsy.java.util.cache.redis.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path ai/com.hsy.ai.base.common
 * @date 25/09/2017 1:40 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public abstract class CacheBase<T> {
    private final Logger _logger = LoggerFactory.getLogger(this.getClass()) ;
    /**
     * @description <p>缓存切点，满足切点会添加缓存</p>
     * @author heshiyuan
     * @date 25/09/2017 1:41 PM
     */
    protected abstract void cacheAspect() ;
    @Around("cacheAspect()")
    public List<T> execute(ProceedingJoinPoint joinPoint) throws Throwable {
        // 调用所拦截方法传递参数
        Object[] args = joinPoint.getArgs();
        _logger.info("【reids切面缓存】进入切面缓存中，参数{}", Arrays.asList(args)) ;

        // 获取key
        StringBuffer sb = new StringBuffer();
        sb.append(getKey()).append(getStringKey(getParameterMap(args)));
        String key = sb.toString();

        // 从缓存中获取数据
        //List <T> list = springRedisCache.getListCache(key, getResponseGeneric()) ;

        /*if (null!=list&&list.size()>0) {
            _logger.info("【reids切面缓存】从缓存中获取到key={}的数据，请求返回。") ;
            return list ;
        }else{
            _logger.info("【reids切面缓存】没有从缓存中获取到key={}的数据，执行数据库查询操作。") ;
            // 没有从缓存中得到数据，从数据库中查询并写入缓存
            List<T> listFromDB = (List<T>) joinPoint.proceed(args);
            _logger.info("【reids切面缓存】从数据库查询到{}条数据。",listFromDB.size()) ;
            long expireTime = getTimeOut() ;
            if(expireTime>0l){
                springRedisCache.putListCacheWithExpireTime(key,listFromDB,expireTime) ;
                _logger.info("【reids切面缓存】将从数据库查询到{}条数据保存到缓存中，key={},过期时间={}",listFromDB.size(),key,getTimeOut()) ;
            }else{
                springRedisCache.putListCache(key,listFromDB) ;
                _logger.info("【reids切面缓存】将从数据库查询到{}条数据保存到缓存中，key={}",listFromDB.size(),key) ;
            }
        }

        if (list == null) {// 防止数据库查不到，空指针异常
            list = new ArrayList<>();
        }
        return list;*/
        return null ;
    }
    /**
     * @description <p>获取缓存key</p>
     * @return 缓存key
     * @author heshiyuan
     * @date 25/09/2017 2:10 PM
     */
    protected abstract String getKey() ;
    /**
     * @description <p>获取缓存过期时间</p>
     * @return 缓存过期时间
     * @author heshiyuan
     * @date 25/09/2017 2:11 PM
     */
    protected abstract long getTimeOut() ;
    /**
     * @description <p>获取过期时间单位</p>
     * @return 过期时间单位
     * @author heshiyuan
     * @date 25/09/2017 2:13 PM
     */
    protected abstract TimeUnit getTimeUnit() ;

    /**
     * @description <p>通过反射获取泛型类型</p>
     * @return 实现类的泛型实体类型
     * @author heshiyuan
     * @date 25/09/2017 5:12 PM
     */
    protected Class<T> getResponseGeneric() {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }

        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        return actualTypeArguments != null ? (Class<T>) actualTypeArguments[0] : null;
    }
    /**
     * @description <p>从参数中组装参数Map，默认没有参数，若有需要在子类中自行重写实现</p>
     * @param args  切面拦截的参数
     * @return 参数
     * @author heshiyuan
     * @date 25/09/2017 5:11 PM
     */
    protected Map<String, Object> getParameterMap(Object[] args) {
        return new HashMap<>();
    }
    /**
     * @Description::获取查询条件字符串. <br/>
     * @author hehch
     * @param map
     * @return
     */
    protected String getStringKey(Map<String, Object> map) {
        List<String> filterList = new ArrayList<String>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (isNotNull(entry.getValue())) {
                filterList.add(entry.getKey());
            }
        }
        filterList.sort(new Comparator<String>() {
            @Override
            public int compare(String arg0, String arg1) {
                return arg0.compareTo(arg1);
            }
        });

        StringBuffer sb = new StringBuffer();
        for (String key : filterList) {
            sb.append(key).append(":").append(map.get(key)).append("_");
        }
        return sb.toString();
    }
    /**
     * @description <p>检查参数是否为空</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 25/09/2017 5:53 PM
     */
    protected boolean isNotNull(Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                String str = (String) obj;
                if (StringUtils.isNotBlank(str)) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
