package com.java.dao.impl;

import com.java.bean.PageBean;
import com.java.bean.TheaterSolrBean;
import com.java.dao.TheaterSolrDao;
import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path java/com.java.dao.impl
 * @date 2017/7/1 11:34
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class TheaterSolrDaoImpl extends SolrDaoImpl<TheaterSolrBean> implements TheaterSolrDao {
    /**
     *  @description 重写父类查询方法
     * @param theaterSolrBean
     * @return
     */
    public PageBean selectBeanList(TheaterSolrBean theaterSolrBean,Integer newPage,Integer pageSize) throws Exception{
        SolrQuery query = new SolrQuery();
        if(newPage <=0 ) newPage = 1 ;
        query.setStart((newPage-1)* pageSize);//起始条数
        query.setRows(pageSize);//每页显示数量
        groupQueryParams(query,theaterSolrBean);
        QueryResponse rsp = null;
        try {
            rsp = client.query( query );
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //List<TheaterSolrBean> ssss = rsp.getBeans(TheaterSolrBean.class);
        SolrDocumentList solrList = rsp.getResults();
        PageBean pageBean = new PageBean() ;
        List<TheaterSolrBean> theaterSolrBeanList = new ArrayList<TheaterSolrBean>();
        pageBean.setTotalCount(solrList.getNumFound());
        for(SolrDocument doc:solrList){
            theaterSolrBeanList.add(changeToBean(doc));
        }
        pageBean.setTheaterSolrBeanList(theaterSolrBeanList);
        return pageBean;
    }

    private TheaterSolrBean changeToBean(SolrDocument doc) {
        TheaterSolrBean bean = new TheaterSolrBean();
        List<Double> priceList = (List<Double>) doc.getFieldValue("theaterTicketPrice") ;
        List<String> theaterNameList = (List<String>) doc.getFieldValue("theaterName") ;
        List<String> theaterImgList = (List<String>) doc.getFieldValue("theaterImg") ;
        List<Long> theaterTypeIdList = (List<Long>) doc.getFieldValue("theaterTypeId") ;
        List<String> theaterTypeList = (List<String>) doc.getFieldValue("theaterType") ;
        List<String> theaterDescriptionList = (List<String>) doc.getFieldValue("theaterDescription") ;
        List<Date> theaterStartTimeList = (List<Date>) doc.getFieldValue("theaterStartTime") ;
        List<Date> theaterEndTimeList = (List<Date>) doc.getFieldValue("theaterEndTime") ;
        bean.setId(Long.parseLong(doc.getFieldValue("id").toString()));
        bean.setTheaterTypeId(theaterTypeIdList.get(0));
        bean.setTheaterType(theaterTypeList.get(0));
        bean.setTheaterStartTime(theaterStartTimeList.get(0));
        bean.setTheaterEndTime(theaterEndTimeList.get(0));
        bean.setTheaterDescription(theaterDescriptionList.get(0));
        bean.setTheaterImg(theaterImgList.get(0));
        bean.setTheaterName(theaterNameList.get(0));
        bean.setTheaterTicketPrice(priceList.get(0));
        return bean;
    }

    /**
     *  组合查询参数
     * @param query
     * @param theaterSolrBean
     */
    private void groupQueryParams(SolrQuery query, TheaterSolrBean theaterSolrBean) {
        StringBuffer querySql = new StringBuffer() ;
        if(null != theaterSolrBean){
            if(StringUtils.isNotBlank(theaterSolrBean.getKeyWords())){
                querySql.append("theaterName:").append(theaterSolrBean.getKeyWords()).append("~")
                        .append(" OR theaterType:").append(theaterSolrBean.getKeyWords()).append("~")
                        .append(" OR theaterDescription:").append(theaterSolrBean.getKeyWords()).append("~")
                        ;
            }else{
                if (null != theaterSolrBean.getId()){
                    querySql.append("id:").append(theaterSolrBean.getId());
                }if(null != theaterSolrBean.getTheaterId()){
                    querySql.append(" AND theaterId:").append(theaterSolrBean.getTheaterId());
                }if(null != theaterSolrBean.getTheaterName()){
                    querySql.append(" AND theaterName:").append(theaterSolrBean.getTheaterName());
                }if(null != theaterSolrBean.getTheaterImg()){
                    querySql.append(" AND theaterImg:").append(theaterSolrBean.getTheaterImg());
                }if(null != theaterSolrBean.getTheaterTypeId()){
                    querySql.append(" AND theaterTypeId:").append(theaterSolrBean.getTheaterTypeId());
                }if(null != theaterSolrBean.getTheaterType()){
                    querySql.append(" AND theaterType:").append(theaterSolrBean.getTheaterType());
                }if(null != theaterSolrBean.getTheaterStartTime()&&null != theaterSolrBean.getTheaterEndTime()){
                    querySql.append(" AND theaterStartTime:[").append(theaterSolrBean.getTheaterStartTime()).append(" TO ").append(theaterSolrBean.getTheaterEndTime()).append("]");
                }if(null != theaterSolrBean.getTheaterStartTime()&&null != theaterSolrBean.getTheaterEndTime()){
                    querySql.append(" AND theaterEndTime:[").append(theaterSolrBean.getTheaterStartTime()).append(" TO ").append(theaterSolrBean.getTheaterEndTime()).append("]");
                }if(null != theaterSolrBean.getTheaterDescription()){
                    querySql.append(" AND theaterDescription:").append(theaterSolrBean.getTheaterDescription());
                }if(null != theaterSolrBean.getStartPrice()&&null!=theaterSolrBean.getEndPrice()){
                    querySql.append(" AND theaterTicketPrice:[").append(theaterSolrBean.getStartPrice()).append(" TO ").append(theaterSolrBean.getEndPrice()).append("]");
                }
            }
        }else{
            querySql.append("*:*");
        }
        query.setQuery(querySql.toString());
    }
}
