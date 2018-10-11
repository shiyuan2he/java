package com.hsy.java.cache.redis.spring.string.impl;
import com.hsy.java.cache.redis.spring.string.IValueOperationsBase;
import com.hsy.java.cache.redis.spring.string.base.SpringStringBase;
import com.hsy.java.enums.CacheEnum;
import com.hsy.java.exception.cache.CacheException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.ValueOperations;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class StringValueOperationsBase extends SpringStringBase implements IValueOperationsBase {
    private ValueOperations<String, String> valueOperations = getStringRedisTemplate().opsForValue();

    @Override
    public boolean set(String key, String value) {
        return this.set(key, value, -1, null);
    }

    @Override
    public boolean set(String key, String value, long timeOut) {
        return this.set(key, value, timeOut, null);
    }

    @Override
    public boolean set(String key, String value, long timeOut, TimeUnit timeUnit) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return false;
        }
        try {
            if (null == valueOperations) {
                log.info("initializing valueOperations");
                valueOperations = getStringRedisTemplate().opsForValue();
            }
            if (timeOut <= 0 || timeUnit == null) {
                valueOperations.set(key, value);
            } else if (timeOut > 0 && null == timeUnit) {
                valueOperations.set(key, value, timeOut, TimeUnit.SECONDS);
            } else {
                valueOperations.set(key, value, timeOut, timeUnit);
            }
            consoleLog(key, timeOut, timeUnit);
            return true;
        } catch (Exception e) {
            log.error("设值缓存失败！失败信息：{}", e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    public boolean setIfAbsent(String key, String value) {
        return this.setIfAbsent(key, value, -1, null);
    }


    public boolean setIfAbsent(String key, String value, long timeOut) {
        return this.setIfAbsent(key, value, timeOut, null);
    }

    public boolean setIfAbsent(String key, String value, long timeOut, TimeUnit timeUnit) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return false;
        }

        try {
            if (null == valueOperations) {
                log.info("initializing valueOperations");
                valueOperations = getStringRedisTemplate().opsForValue();
            }
            boolean flag ;
            if (timeOut > 0 && null != timeUnit) {
                flag = valueOperations.setIfAbsent(key, value);
                this.getStringRedisTemplate().expire(key, timeOut, timeUnit);
            } else if (timeOut > 0 && null == timeUnit) {
                flag = valueOperations.setIfAbsent(key, value);
                this.getStringRedisTemplate().expire(key, timeOut, TimeUnit.SECONDS);
            } else {
                flag = valueOperations.setIfAbsent(key, value);
            }
            log.info("操作成功！key={}", key);
            return flag;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public int append(String key, String value) {
        return this.append(key, value, -1, null);
    }

    @Override
    public int append(String key, String value, long timeOut) {
        return this.append(key, value, timeOut, null);
    }

    @Override
    public int append(String key, String value, long timeOut, TimeUnit timeUnit) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return -1;
        }
        try {
            if (null == valueOperations) {
                log.info("initializing valueOperations");
                valueOperations = getStringRedisTemplate().opsForValue();
            }
            int flag ;
            if (timeOut > 0 && null != timeUnit) {
                flag = valueOperations.append(key, value);
                this.getStringRedisTemplate().expire(key, timeOut, timeUnit);
            } else if (timeOut > 0 && null == timeUnit) {
                flag = valueOperations.append(key, value);
                this.getStringRedisTemplate().expire(key, timeOut, TimeUnit.SECONDS);
            } else {
                flag = valueOperations.append(key, value);
            }
            log.info("操作成功！key={}", key);
            return flag;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public void multiSet(Map<String, String> keyValue) {
        this.multiSet(keyValue, -1, null);
    }

    /*@Override
    public void multiSet(Map<String, String> keyValue) {
        if (Objects.isNull(keyValue)) {
            log.error("keyValue is null");
            return ;
        }
        try {
            if (null == valueOperations) {
                log.info("initializing valueOperations");
                valueOperations = getStringRedisTemplate().opsForValue();
            }
            if (isTimeOut) {
                valueOperations.multiSet(keyValue);
                log.info("操作成功！key={}", keyValue.toString());
                return;
            }else {
               this.multiSet(keyValue);
            }
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", keyValue.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }*/

    @Override
    public void multiSet(Map<String, String> keyValue, long timeOut) {
        this.multiSet(keyValue, timeOut, null);
    }

    @Override
    public void multiSet(Map<String, String> keyValue, long timeOut, TimeUnit timeUnit) {
        if (Objects.isNull(keyValue)) {
            log.error("keyValue is null");
            return ;
        }
        try {
            if (null == valueOperations) {
                log.info("initializing valueOperations");
                valueOperations = getStringRedisTemplate().opsForValue();
            }
            Map<String, String> newMap = Collections.EMPTY_MAP;
            if (timeOut > 0 && null != timeUnit) {
                keyValue.forEach((key, value) -> newMap.put(key, value));
                valueOperations.multiSet(newMap);
                newMap.keySet().stream().forEach(key -> this.getStringRedisTemplate().expire(key, timeOut, timeUnit));
            } else if (timeOut > 0 && null == timeUnit) {
                keyValue.forEach((key, value) -> newMap.put(key, value));
                valueOperations.multiSet(newMap);
                newMap.keySet().stream().forEach(key -> this.getStringRedisTemplate().expire(key, timeOut, TimeUnit.SECONDS));
            } else {
                keyValue.forEach((key, value) -> newMap.put(key, value));
                valueOperations.multiSet(newMap);
            }
            log.info("操作成功！key={}", newMap.toString());
            return ;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", keyValue.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public boolean multiSetIfAbsent(Map<String, String> keyValue) {
        return this.multiSetIfAbsent(keyValue, -1, null);
    }
    @Override
    public boolean multiSetIfAbsent(Map<String, String> keyValue, boolean isOriginal) {
        if (Objects.isNull(keyValue)) {
            log.error("keyValue is null");
            return false;
        }
        try {
            if (null == valueOperations) {
                log.info("initializing valueOperations");
                valueOperations = getStringRedisTemplate().opsForValue();
            }
            if (isOriginal) {
                boolean flag = valueOperations.multiSetIfAbsent(keyValue);
                log.info("操作成功！key={}", keyValue.toString());
                return flag;
            }else {
                return this.multiSetIfAbsent(keyValue);
            }
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", keyValue.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    @Override
    public boolean multiSetIfAbsent(Map<String, String> keyValue, long timeOut) {
        return this.multiSetIfAbsent(keyValue, timeOut, null);
    }

    @Override
    public boolean multiSetIfAbsent(Map<String, String> keyValue, long timeOut, TimeUnit timeUnit) {
        if (Objects.isNull(keyValue)) {
            log.error("keyValue is null");
            return false;
        }
        try {
            if (null == valueOperations) {
                log.info("initializing valueOperations");
                valueOperations = getStringRedisTemplate().opsForValue();
            }
            boolean flag;
            Map<String, String> newMap = Collections.EMPTY_MAP;
            if (timeOut > 0 && null != timeUnit) {
                keyValue.forEach((key, value) -> newMap.put(key, value));
                flag = valueOperations.multiSetIfAbsent(newMap);
                newMap.keySet().stream().forEach(key -> this.getStringRedisTemplate().expire(key, timeOut, timeUnit));
            } else if (timeOut > 0 && null == timeUnit) {
                keyValue.forEach((key, value) -> newMap.put(key, value));
                flag = valueOperations.multiSetIfAbsent(newMap);
                newMap.keySet().stream().forEach(key -> this.getStringRedisTemplate().expire(key, timeOut, TimeUnit.SECONDS));
            } else {
                keyValue.forEach((key, value) -> newMap.put(key, value));
                flag = valueOperations.multiSetIfAbsent(newMap);
            }
            log.info("操作成功！key={}", newMap.toString());
            return flag;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", keyValue.toString(), e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public String getAndSet(String key, String value) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == valueOperations) {
                log.info("initializing valueOperations");
                valueOperations = getStringRedisTemplate().opsForValue();
            }
            String returnValue = valueOperations.getAndSet(key, value);
            log.info("操作成功！key={}", key);
            return returnValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public List<String> multiGet(List<String> keyList) {
        if (null!=keyList && keyList.size()>0) {
            log.error("key is null");
            return null;
        }
        try {
            if (null == valueOperations) {
                log.info("initializing valueOperations");
                valueOperations = getStringRedisTemplate().opsForValue();
            }
            List<String> resultList = valueOperations.multiGet(keyList);
            log.info("操作成功！key={}", Arrays.toString(keyList.toArray()));
            return resultList;
        } catch (Exception e) {
            log.error("操作失败！失败信息：{}", e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public String get(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return null;
        }

        try {
            if (null == valueOperations) {
                log.info("initializing valueOperations");
                valueOperations = getStringRedisTemplate().opsForValue();
            }

            log.info("操作成功！key={}", key);
            return valueOperations.get(key);
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public long increment(String key, long value) {
        return this.increment(key, value, -1, null);
    }

    @Override
    public long increment(String key, long value, long timeLive) {
        return this.increment(key, value, timeLive, null);
    }

    @Override
    public long increment(String key, long value, long timeLive, TimeUnit timeUnit) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }

        try {
            if (null == valueOperations) {
                log.info("initializing valueOperations");
                valueOperations = getStringRedisTemplate().opsForValue();
            }
            long newValue = 0l;
            //noinspection Duplicates
            if (timeLive > 0 && null != timeUnit) {
                newValue = valueOperations.increment(key, value);
                this.getStringRedisTemplate().expire(key, timeLive, timeUnit);
            } else if (timeLive > 0 && null == timeUnit) {
                newValue = valueOperations.increment(key, value);
                this.getStringRedisTemplate().expire(key, timeLive, TimeUnit.SECONDS);
            } else {
                newValue = valueOperations.increment(key, value);
            }
            log.info("操作成功！key={}", key);
            return newValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }

    @Override
    public double increment(String key, double value) {
        return this.increment(key, value, -1, null);
    }

    @Override
    public double increment(String key, double value, long timeLive) {
        return this.increment(key, value, timeLive, null);
    }

    @Override
    public double increment(String key, double value, long timeLive, TimeUnit timeUnit) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return 0;
        }

        try {
            if (null == valueOperations) {
                log.info("initializing valueOperations");
                valueOperations = getStringRedisTemplate().opsForValue();
            }
            double newValue = 0l;
            //noinspection Duplicates
            if (timeLive > 0 && null != timeUnit) {
                newValue = valueOperations.increment(key, value);
                this.getStringRedisTemplate().expire(key, timeLive, timeUnit);
            } else if (timeLive > 0 && null == timeUnit) {
                newValue = valueOperations.increment(key, value);
                this.getStringRedisTemplate().expire(key, timeLive, TimeUnit.SECONDS);
            } else {
                newValue = valueOperations.increment(key, value);
            }
            log.info("操作成功！key={}", key);
            return newValue;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
    @Override
    public long size(String key) {
        if (StringUtils.isBlank(key)) {
            log.error("key is null");
            return -1;
        }

        try {
            if (null == valueOperations) {
                log.info("initializing valueOperations");
                valueOperations = getStringRedisTemplate().opsForValue();
            }

            long count = valueOperations.size(key);
            log.info("操作成功！key={}", key);
            return count;
        } catch (Exception e) {
            log.error("操作失败！key={};失败信息：{}", key, e);
            throw new CacheException(CacheEnum.CACHE_HANDLE_DO_EXCEPTION);
        }
    }
}
