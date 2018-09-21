package com.hsy.java.cache.spring.string.impl;

import com.hsy.java.cache.spring.string.IValueOperationBase;

import java.util.concurrent.TimeUnit;

public abstract class ValueOperationBase extends StringRedisTemplateBase implements IValueOperationBase {

    @Override
    public String getAndSet(String key, String value, boolean isTimeOutKey) {
        return null;
    }

    @Override
    public String getAndSet(String key, String value) {
        return null;
    }

    @Override
    public long increment(String key, long value) {
        return 0;
    }

    @Override
    public long increment(String key, long value, long timeLive, TimeUnit timeUnit) {
        return 0;
    }

    @Override
    public double increment(String key, double value, long timeLive, TimeUnit timeUnit) {
        return 0;
    }

    @Override
    public boolean set(String key, String value) {
        return false;
    }

    @Override
    public boolean set(String key, String value, long timeOut) {
        return false;
    }

    @Override
    public boolean set(String key, String value, long timeOut, TimeUnit timeUnit) {
        return false;
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public String get(String key, boolean isTimeOutkey) {
        return null;
    }
}
