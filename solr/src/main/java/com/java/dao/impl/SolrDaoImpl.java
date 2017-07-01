package com.java.dao.impl;

import com.java.bean.PageBean;
import com.java.dao.SolrDao;
import com.java.util.SolrUtil;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path java/com.java.dao.impl
 * @date 2017/7/1 11:05
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class SolrDaoImpl<O> implements SolrDao{
    SolrClient client = SolrUtil.getInstance().getClient() ;
    public Integer addByField(Map map) {
        return null;
    }

    public Integer addByBean(Object o) throws IOException, SolrServerException {
        UpdateResponse response = client.addBean(o);//4.提交文档到索引库
        client.optimize(); //对索引进行优化
        client.commit();//5.提交
        if(0 == response.getStatus()){
            return 1 ;
        }
        return 0;
    }

    public Integer addByBeans(List list) throws IOException, SolrServerException {
        UpdateResponse response = client.addBeans(list);//4.提交文档到索引库
        client.optimize(); //对索引进行优化
        client.commit();//5.提交
        /**
         *  应该根据response.getResponse()返回的数据判定更新几条成功，返回成功数
         */
        if(0 == response.getStatus()){
            return 1 ;
        }
        return 0;
    }

    public PageBean selectBeanList(Object o, Integer newPage, Integer pageSize) {
        return null;
    }

    public Object getById(Long id) throws IOException, SolrServerException {
        return client.getById(id.toString());
    }

    public Integer deleteById(Long id) {
        return null;
    }

    public Integer deleteAll() throws IOException, SolrServerException {
        client.deleteByQuery("*:*") ;
        client.commit();
        return null;
    }

    public Integer deleteByParam(Object o) {
        return null;
    }

    public Integer update(Object o) {
        return null;
    }
}
