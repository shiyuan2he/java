package com.hsy.java.java.util.json;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hsy.java.bean.dto.ResponseBodyBean;
import com.hsy.java.bean.vo.SessionBean;
import com.hsy.java.util.json.JsonToBeanUtil;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.util.json
 * @date 2017/11/2 16:41
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class JsonToBeanUtilTest {
    private static final Logger _logger = LoggerFactory.getLogger(JsonToBeanUtilTest.class) ;
    static String json = "" ;
    static{
        SessionBean sessionBean = new SessionBean() ;
        sessionBean.setMobile(11111111111l);
        sessionBean.setTicket("432423412342sdfsa");
        ResponseBodyBean bean = new ResponseBodyBean(true,"0000",sessionBean) ;
        json = JsonToBeanUtil.requestBeanToJson(bean) ;
        _logger.info("requestBeanToJson={}",json) ;
    }
    @Test
    public void responseJsonToBeanEnhance() throws Exception {
        _logger.info("requestJsonToBean={}",JsonToBeanUtil.responseJsonToBeanEnhance(json, SessionBean.class).toString()) ;
    }

    @Test
    public void responseJsonToBean() throws Exception {
        _logger.info("requestBeanToJson={}",json) ;
        _logger.info("requestJsonToBean={}",JsonToBeanUtil.responseJsonToBean(json, SessionBean.class).toString()) ;
    }

    @Test
    public void requestJsonToBeanEnhance() throws Exception {

    }

    @Test
    public void requestJsonToBean() throws Exception {

    }

    @Test
    public void requestBeanToJson() throws Exception {
    }

}