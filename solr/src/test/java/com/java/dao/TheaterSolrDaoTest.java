package com.java.dao;

import com.java.bean.PageBean;
import com.java.bean.TheaterSolrBean;
import com.java.dao.impl.TheaterSolrDaoImpl;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path java/com.java.dao
 * @date 2017/7/1 12:12
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class TheaterSolrDaoTest {
    @Test
    public void testelectBeanListS(){
        TheaterSolrDaoImpl theaterSolrDaoImpl = new TheaterSolrDaoImpl() ;

        TheaterSolrBean theaterSolrBean = new TheaterSolrBean();
        //theaterSolrBean.setKeyWords("话剧");
        //3.向文档对象中添加域 （先定义后使用）
        theaterSolrBean.setId((long)10005);
        //theaterSolrBean.setTheaterId(20001+"");
//        theaterSolrBean.setTheaterName("中国戏剧黄金一代剧场典范 话剧《冬之旅》第"+i+"场");
//        theaterSolrBean.setTheaterImg("images/theatre-place"+i+".jpg");
//        theaterSolrBean.setTheaterDescription("在线选座/打折");
//        Calendar calendar = Calendar.getInstance() ;
//        calendar.add(Calendar.DAY_OF_MONTH,1); //加一天
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
//        Date startTime = null,endTime=null ;
//        try {
//            startTime = sdf.parse(sdf.format(calendar.getTime()));
//            Calendar calendar2 = Calendar.getInstance() ;
//              calendar2.add(Calendar.DAY_OF_MONTH,1); //加一天
//            calendar2.add(Calendar.HOUR_OF_DAY,3); //加三小时
//            endTime = startTime = sdf.parse(sdf.format(calendar2.getTime()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        theaterSolrBean.setTheaterStartTime(startTime);
//        theaterSolrBean.setTheaterEndTime(endTime);
//        theaterSolrBean.setTheaterTicketPrice(500+Math.ceil(Math.random()*500)); // 500~1000
//        theaterSolrBean.setTheaterType("话剧/歌剧");
        theaterSolrBean.setTheaterTypeId((long) 9999999);
        PageBean pageBean = null;
        try {
            pageBean = theaterSolrDaoImpl.selectBeanList(theaterSolrBean,1,10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(TheaterSolrBean bean : pageBean.getTheaterSolrBeanList()){
            System.out.println(bean.toString()) ;
        }
    }
}
