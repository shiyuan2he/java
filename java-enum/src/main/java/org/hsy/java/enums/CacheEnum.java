package org.hsy.java.enums;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.enums
 * @date 2017/10/27 14:38
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public enum CacheEnum {

    CACHE__EXCEPTION("4000","用户信息缓存过期，请重新登陆"),
    CACHE_LOGIN_EXPIRE_EXCEPTION("4001","用户信息缓存过期，请重新登陆"),

    CACHE_KEY_TICKET("sso:ticket:","sso通票redis key,过期时间60秒",60l),
    CACHE_KEY_IMAGE_CODE("base:service:image:","base-service图形验证码key,过期时间2分钟",5 * 60l),

    CACHE_HANDLE_DO_EXCEPTION("cache9999","缓存操作异常"),
    ;
    private String code ;
    private String message ;
    private Long expire ;

    CacheEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
    CacheEnum(String code, String message,Long expire) {
        this.code = code;
        this.message = message;
        this.expire = expire ;
    }

    public Long getExpire() {
        return expire;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
