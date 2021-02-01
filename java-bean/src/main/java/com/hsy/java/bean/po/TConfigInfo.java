package com.hsy.java.bean.po;

import java.io.Serializable;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.bean.po
 * @date 2017/11/21 18:41
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class TConfigInfo implements Serializable {
    private String field ;
    private String value ;
    private String name ;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TConfigInfo{" +
                "field='" + field + '\'' +
                ", value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
