package com.hsy.java.util.spring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MultiValueMap;
/**
 * @author heshiyuan
 * @description <p>spring controller mock测试</p>
 * @path sso/com.hsy.sso.web.better
 * @date 2017/11/14 20:05
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public abstract class SpringWebJunitBase {
    private final Logger _logger = LoggerFactory.getLogger(this.getClass()) ;

    public abstract MockMvc getMockMvc() ;

    public void postRequest(String url,Object param) throws Exception{
        long start = System.currentTimeMillis();
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders
                        .post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                ;
        setParams(builder,param) ;

        getMockMvc().perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString()
        ;

        long end = System.currentTimeMillis();
        _logger.info("耗时：" + (end - start) + "ms.");
    }



    public void getRequest(String url,Object param) throws Exception{
        long start = System.currentTimeMillis();

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders
                        .get(url)
                        .contentType("application/json;charset=utf-8")
                ;
        setParams(builder,param) ;
        getMockMvc().perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString()
        ;

        long end = System.currentTimeMillis();
        _logger.info("耗时：" + (end - start) + "ms.");
    }
    public void deleteRequest(String url,Object param) throws Exception{
        long start = System.currentTimeMillis();

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders
                        .delete(url)
                        .contentType("application/json;charset=utf-8")
                ;
        setParams(builder,param) ;
        getMockMvc().perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString()
        ;

        long end = System.currentTimeMillis();
        _logger.info("耗时：" + (end - start) + "ms.");
    }
    public void putRequest(String url,Object param) throws Exception{
        long start = System.currentTimeMillis();

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders
                        .put(url)
                        .contentType("application/json;charset=utf-8")
                ;
        setParams(builder,param) ;
        getMockMvc().perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString()
        ;

        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms.");
    }
    public void patchRequest(String url,Object param) throws Exception{
        long start = System.currentTimeMillis();

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders
                        .patch(url)
                        .contentType("application/json;charset=utf-8")
                ;
        setParams(builder,param) ;
        getMockMvc().perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString()
        ;

        long end = System.currentTimeMillis();
        _logger.info("耗时：" + (end - start) + "ms.");
    }
    private void setParams(MockHttpServletRequestBuilder builder,Object param) {
        if(param instanceof String){ //json
            builder.content(param.toString()) ;
        }else if (param instanceof MultiValueMap){
            builder.params((MultiValueMap<String, String>) param) ;
        }else{
            _logger.error("不支持的传参类型");
            return ;
        }
    }
}
