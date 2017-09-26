package com.hsy.java.base.exception;

/**
 * @author heshiyuan
 * @description <p>缓存抛出时异常</p>
 * @path java/com.hsy.java.base.exception
 * @date 25/09/2017 3:15 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class CacheException extends RuntimeException{
    public CacheException(String msg) {
        super(msg);
    }

    public CacheException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
