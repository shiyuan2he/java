package com.java.bean;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p></p>
 * @path java/com.java.bean
 * @date 2017/7/1 10:31
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class TheaterSolrBean {

    @Field
    private Long id;    //索引id
    @Field
    private String theaterId ;//话剧id，关联话剧表
    @Field
    private String theaterName; //话剧名称
    @Field
    private String theaterImg;//话剧图片
    @Field
    private Long theaterTypeId; //话剧类别Id,关联话剧类别表
    @Field
    private String theaterType; //话剧类别
    @Field
    private Date theaterStartTime;//话剧演出开始时间
    @Field
    private Date theaterEndTime; //话剧演出结束时间
    @Field
    private String theaterDescription; //话剧描述
    @Field
    private Double theaterTicketPrice; //话剧票价

    // 查询参数
    private String keyWords ;//关键字查询
    private Double startPrice ;
    private Double endPrice ;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTheaterId() {
        return theaterId;
    }
    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }
    public String getTheaterName() {
        return theaterName;
    }
    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterImg() {
        return theaterImg;
    }

    public void setTheaterImg(String theaterImg) {
        this.theaterImg = theaterImg;
    }

    public Long getTheaterTypeId() {
        return theaterTypeId;
    }

    public void setTheaterTypeId(Long theaterTypeId) {
        this.theaterTypeId = theaterTypeId;
    }

    public String getTheaterType() {
        return theaterType;
    }

    public void setTheaterType(String theaterType) {
        this.theaterType = theaterType;
    }

    public Date getTheaterStartTime() {
        return theaterStartTime;
    }

    public void setTheaterStartTime(Date theaterStartTime) {
        this.theaterStartTime = theaterStartTime;
    }

    public Date getTheaterEndTime() {
        return theaterEndTime;
    }

    public void setTheaterEndTime(Date theaterEndTime) {
        this.theaterEndTime = theaterEndTime;
    }

    public String getTheaterDescription() {
        return theaterDescription;
    }

    public void setTheaterDescription(String theaterDescription) {
        this.theaterDescription = theaterDescription;
    }

    public Double getTheaterTicketPrice() {
        return theaterTicketPrice;
    }

    public void setTheaterTicketPrice(Double theaterTicketPrice) {
        this.theaterTicketPrice = theaterTicketPrice;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    public Double getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Double endPrice) {
        this.endPrice = endPrice;
    }

    @Override
    public String toString() {
        return "TheaterSolrBean{" +
                "id=" + id +
                ", theaterId='" + theaterId + '\'' +
                ", theaterName='" + theaterName + '\'' +
                ", theaterImg='" + theaterImg + '\'' +
                ", theaterTypeId='" + theaterTypeId + '\'' +
                ", theaterType='" + theaterType + '\'' +
                ", theaterStartTime=" + theaterStartTime +
                ", theaterEndTime=" + theaterEndTime +
                ", theaterDescription='" + theaterDescription + '\'' +
                ", theaterTicketPrice=" + theaterTicketPrice +
                '}';
    }
}
