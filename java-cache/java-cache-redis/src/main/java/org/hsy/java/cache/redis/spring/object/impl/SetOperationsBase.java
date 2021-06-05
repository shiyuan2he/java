package org.hsy.java.cache.redis.spring.object.impl;
import org.hsy.java.cache.redis.spring.object.ISetOperationsBase;
import org.hsy.java.cache.redis.spring.object.base.SpringObjectBase;
import org.hsy.java.enums.CacheEnum;
import org.hsy.java.exception.cache.CacheException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.SetOperations;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Slf4j
public abstract class SetOperationsBase extends SpringObjectBase implements ISetOperationsBase {
    private SetOperations<String, Object> setOperations = getRedisTemplate().opsForSet();

    @Override
    public Long add(String key, Object... value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }

            Long returnValue = setOperations.add(key, value);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long remove(String key, Object... value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }

            Long returnValue = setOperations.remove(key, value);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Object pop(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }

            Object returnValue = setOperations.pop(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Boolean move(String key, Object value, String destinationKey) {
        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            Boolean returnValue = setOperations.move(key, value, destinationKey);
            log.info("操作成功！key={}, destinationKey={}", key, value, destinationKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},失败信息：{}", key, e);
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
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }

            Long returnValue = setOperations.size(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Boolean isMember(String key, Object value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }

            Boolean returnValue = setOperations.isMember(key, value);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<Object> intersect(String key, String otherKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            Set<Object> returnValue = setOperations.intersect(key, otherKey);
            log.info("操作成功！key={},otherKeys={}", key, otherKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKeys={},失败信息：{}",  key, otherKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<Object> intersect(String key, Collection<String> otherKeys) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            Set<Object> returnValue = setOperations.intersect(key, otherKeys);
            log.info("操作成功！key={},otherKeys={}", key, otherKeys);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKeys={},失败信息：{}",  key, otherKeys, e);
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
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.intersectAndStore(key, otherKey, destinationKey);
            log.info("操作成功！key={},otherKey={},destinationKey={}", key, otherKey, destinationKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKey={},destinationKey={},失败信息：{}",  key, otherKey, destinationKey, e);
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
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.intersectAndStore(key, otherKeys, destinationKey);
            log.info("操作成功！key={},otherKeys={},destinationKey={}", key, otherKeys, destinationKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKeys={},destinationKey={},失败信息：{}",  key, otherKeys, destinationKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<Object> union(String key, String otherKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            Set<Object> returnValue = setOperations.union(key, otherKey);
            log.info("操作成功！key={},otherKey={}", key, otherKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKey={},失败信息：{}",  key, otherKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<Object> union(String key, Collection<String> otherKeys) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            Set<Object> returnValue = setOperations.union(key, otherKeys);
            log.info("操作成功！key={},otherKeys={}", key, otherKeys);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKeys={},失败信息：{}",  key, otherKeys, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long unionAndStore(String key, String otherKey, String destinationKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.unionAndStore(key, otherKey, destinationKey);
            log.info("操作成功！key={},otherKey={},destinationKey={}", key, otherKey, destinationKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKey={},destinationKey={},失败信息：{}",  key, otherKey, destinationKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long unionAndStore(String key, Collection<String> otherKeys, String destinationKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.unionAndStore(key, otherKeys, destinationKey);
            log.info("操作成功！key={},otherKeys={},destinationKey={}", key, otherKeys, destinationKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKeys={},destinationKey={},失败信息：{}",  key, otherKeys, destinationKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<Object> difference(String key, String otherKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            Set<Object> returnValue = setOperations.difference(key, otherKey);
            log.info("操作成功！key={},otherKey={}", key, otherKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKey={},失败信息：{}",  key, otherKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<Object> difference(String key, Collection<String> otherKeys) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            Set<Object> returnValue = setOperations.difference(key, otherKeys);
            log.info("操作成功！key={},otherKeys={}", key, otherKeys);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKeys={},失败信息：{}",  key, otherKeys, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long differenceAndStore(String key, String otherKey, String destinationKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.differenceAndStore(key, otherKey, destinationKey);
            log.info("操作成功！key={},otherKey={},destinationKey={}", key,  otherKey, destinationKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKeys={},destinationKey={},失败信息：{}",  key,  otherKey, destinationKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Long differenceAndStore(String key, Collection<String> otherKeys, String destinationKey) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }
            Long returnValue = setOperations.differenceAndStore(key, otherKeys, destinationKey);
            log.info("操作成功！key={},otherKeys={},destinationKey={}", key,  otherKeys, destinationKey);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},otherKeys={},destinationKey={},失败信息：{}",  key,  otherKeys, destinationKey, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<Object> members(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }

            Set<Object> returnValue = setOperations.members(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Object randomMember(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }

            Object returnValue = setOperations.randomMember(key);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public Set<Object> distinctRandomMembers(String key, long count) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }

            Set<Object> returnValue = setOperations.distinctRandomMembers(key, count);
            log.info("操作成功！key={}, count={}", key, count);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},count={},失败信息：{}", key, count, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public List<Object> randomMembers(String key, long count) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == setOperations) {
                log.info("正在初始化valueOperations");
                setOperations = getRedisTemplate().opsForSet();
            }

            List<Object> returnValue = setOperations.randomMembers(key, count);
            log.info("操作成功！key={}, count={}", key, count);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={},count={},失败信息：{}", key, count, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
}
