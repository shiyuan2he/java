package com.hsy.java.cache.redis.spring.string.impl;
import com.askingdata.y.cache.redis.spring.string.ISetOperationsBase;
import com.askingdata.y.cache.redis.spring.string.base.SpringStringBase;
import com.askingdata.y.enums.CacheEnum;
import com.askingdata.y.exception.CacheException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.SetOperations;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class SetOperationsBase extends SpringStringBase implements ISetOperationsBase {
    private SetOperations<String, String> setOperations = getStringRedisTemplate().opsForSet();

    @Override
    public Long add(String key, String value) {
       return this.add(key, -1, null, value);
    }


    @Override
    public Long add(String key, long timeOut, String value) {
        return this.add(key, timeOut, null, value);
    }

    @Override
    public Long add(String key, long timeOut, TimeUnit timeUnit, String value) {
        return this.add(key, timeOut, timeUnit, value);
    }

    @Override
    public Long add(String key, String... value) {
        return this.add(key, -1, null, value);
    }

    @Override
    public Long add(String key, long timeOut, String... value) {
        return this.add(key, timeOut, null, value);
    }

    @Override
    public Long add(String key, long timeOut, TimeUnit timeUnit, String... value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0l;
        }

        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Long returnValue = 0l;
            if (timeOut > 0 && null != timeUnit) {
                returnValue = setOperations.add(key, value);
                this.getStringRedisTemplate().expire(key, timeOut, timeUnit);
            } else if (timeOut > 0 && null == timeUnit) {
                returnValue = setOperations.add(key, value) ;
                this.getStringRedisTemplate().expire(key, timeOut, TimeUnit.SECONDS);
            } else {
                returnValue = setOperations.add(key, value) ;
            }
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    public Long remove(String key, String value) {
        return this.remove(key, value);
    }

    @Override
    public Long remove(String key, String... value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0l;
        }

        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }

            Long returnValue = setOperations.remove(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public String pop(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }

            String returnValue = setOperations.pop(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public boolean move(String key, String value, String destinationKey) {
        if (StringUtils.isBlank(key) ||StringUtils.isBlank(destinationKey)) {
            log.error("key is null");
            return false;
        }

        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            boolean returnValue = setOperations.move(key, value, destinationKey);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long size(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }

            Long returnValue = setOperations.size(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public boolean isMember(String key, String value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return false;
        }

        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }

            boolean returnValue = setOperations.isMember(key, value);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> intersect(String key, String otherKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Set<String> returnValue = setOperations.intersect(key, otherKey);
            log.info("操作成功！key={};otherKey={}", key, otherKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKey={}失败！失败信息：{}", key, otherKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> intersect(String key, Collection<String> otherKeys) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Set<String> returnValue = setOperations.intersect(key, otherKeys);
            log.info("操作成功！key={};otherKey={}", key, Arrays.toString(otherKeys.toArray()));
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKey={}失败！失败信息：{}", key, Arrays.toString(otherKeys.toArray()), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long intersectAndStore(String key, String otherKey, String destinationKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.intersectAndStore(key, otherKey, destinationKey);
            log.info("操作成功！key={};otherKey={};destinationKey={}", key, otherKey, destinationKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKey={};destinationKey={}失败！失败信息：{}",  key, otherKey, destinationKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long intersectAndStore(String key, Collection<String> otherKeys, String destinationKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.intersectAndStore(key, otherKeys, destinationKey);
            log.info("操作成功！key={};otherKeys={};destinationKey={}", key, Arrays.toString(otherKeys.toArray()), destinationKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKey={};destinationKey={}失败！失败信息：{}",  key, otherKeys, destinationKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> union(String key, String otherKey) {
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Set<String> returnValue = setOperations.union(key, otherKey);
            log.info("操作成功！key={};otherKeys={}", key, otherKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKey={}失败！失败信息：{}",  key, otherKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> union(String key, Collection<String> otherKeys) {
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Set<String> returnValue = setOperations.union(key, otherKeys);
            log.info("操作成功！key={};otherKeys={}", key, Arrays.toString(otherKeys.toArray()));
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKeys={}失败！失败信息：{}",  key, Arrays.toString(otherKeys.toArray()), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long unionAndStore(String key, String otherKey, String destinationKey) {
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.unionAndStore(key, otherKey, destinationKey);
            log.info("操作成功！key={};otherKeys={}", key, otherKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKeys={}失败！失败信息：{}",  key, otherKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long unionAndStore(String key, Collection<String> otherKeys, String destinationKey) {
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.unionAndStore(key, otherKeys, destinationKey);
            log.info("操作成功！key={};otherKeys={}", key, Arrays.toString(otherKeys.toArray()));
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKeys={}失败！失败信息：{}",  key, Arrays.toString(otherKeys.toArray()), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> difference(String key, String otherKey) {
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Set<String> returnValue = setOperations.difference(key, otherKey);
            log.info("操作成功！key={};otherKeys={}", key, otherKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKeys={}失败！失败信息：{}",  key, otherKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> difference(String key, Collection<String> otherKeys) {
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Set<String> returnValue = setOperations.difference(key, otherKeys);
            log.info("操作成功！key={};otherKeys={}", key, Arrays.toString(otherKeys.toArray()));
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKeys={}失败！失败信息：{}",  key, otherKeys, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long differenceAndStore(String key, String otherKey, String destinationKey) {
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.differenceAndStore(key, otherKey, destinationKey);
            log.info("操作成功！key={};otherKey={}", key, otherKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKey={}失败！失败信息：{}",  key, otherKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long differenceAndStore(String key, Collection<String> otherKeys, String destinationKey) {
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.differenceAndStore(key, otherKeys, destinationKey);
            log.info("操作成功！key={};otherKeys={}", key, Arrays.toString(otherKeys.toArray()));
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={};otherKeys={}失败！失败信息：{}",  key, Arrays.toString(otherKeys.toArray()), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> members(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuffer keyStr = null;
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Set<String> returnValue = setOperations.members(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}",  key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public String randomMember(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuffer keyStr = null;
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            String returnValue = setOperations.randomMember(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={}失败！失败信息：{}",  key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<String> distinctRandomMembers(String key, long count) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuffer keyStr = null;
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            Set<String> returnValue = setOperations.distinctRandomMembers(key, count);
            log.info("操作成功！key={},count={}", key, count);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={},count={}失败！失败信息：{}",  key, count, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public List<String> randomMembers(String key, long count) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        StringBuffer keyStr = null;
        try {
            if (null == setOperations) {
                log.info("initializing valueOperations");
                setOperations = getStringRedisTemplate().opsForSet();
            }
            List<String> returnValue = setOperations.randomMembers(key, count);
            log.info("操作成功！key={},count={}", key, count);
            return returnValue;
        } catch (Exception e) {
            log.error("操作key={},count={}失败！失败信息：{}",  key, count, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
}
