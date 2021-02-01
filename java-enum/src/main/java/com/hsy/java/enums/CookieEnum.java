package com.hsy.java.enums;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.enums
 * @date 2017/10/27 14:38
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public enum CookieEnum {

    COOKIE_INFO("/","CMS域名,有效期2分钟",2*60),
    ;
    private String path ;
    private String description ;
    private Integer expire ;

    CookieEnum(String path, String description, Integer expire) {
        this.path = path;
        this.description = description;
        this.expire = expire ;
    }

    public Integer getExpire() {
        return expire;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
