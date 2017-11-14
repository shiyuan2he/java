package com.hsy.bean.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.bean.vo
 * @date 2017/11/14 13:23
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class PermissionBean implements Serializable{
    private Long id ;
    private String authAddress ;
    private String authDescription ;
    private Long parentid ;
    private List<PermissionBean> children ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthAddress() {
        return authAddress;
    }

    public void setAuthAddress(String authAddress) {
        this.authAddress = authAddress;
    }

    public String getAuthDescription() {
        return authDescription;
    }

    public void setAuthDescription(String authDescription) {
        this.authDescription = authDescription;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public List<PermissionBean> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionBean> children) {
        this.children = children;
    }
}
