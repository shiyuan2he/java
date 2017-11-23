package com.hsy.java.bean.vo;

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
public class NodeTree implements Serializable{
    private Long id ;
    private String nodeCode ;
    private String nodeName ;
    private List<NodeTree> children ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public List<NodeTree> getChildren() {
        return children;
    }

    public void setChildren(List<NodeTree> children) {
        this.children = children;
    }
}
