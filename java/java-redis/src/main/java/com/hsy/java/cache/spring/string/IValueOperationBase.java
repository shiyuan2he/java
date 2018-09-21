package com.hsy.java.cache.spring.string;
import com.hsy.java.cache.spring.ISpringRedisInterface;
import java.util.concurrent.TimeUnit;
public interface IValueOperationBase extends ISpringRedisInterface {
    String getAndSet(String key, String value, boolean isTimeOutKey);
    String getAndSet(String key, String value);
    long increment(String key, long value);
    long increment(String key, long value, long timeLive, TimeUnit timeUnit);
    double increment(String key, double value, long timeLive, TimeUnit timeUnit);
}
