package com.hsy.java.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.hsy.bean.dto.RequestBodyBean;
import com.hsy.bean.dto.ResponseBodyBean;
import com.hsy.java.enums.BusinessEnum;
import com.hsy.java.enums.WebEnum;
import com.hsy.java.exception.service.BusinessException;
import com.hsy.java.exception.web.ParamTransformException;
import com.hsy.java.util.business.XssInjectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heshiyuan
 * @description <p>json参数转换工具类</p>
 * @path java/com.hsy.java.util.json
 * @date 2017/11/2 08:35
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class JsonToBeanUtil {
    private static final Logger _logger = LoggerFactory.getLogger(RequestContextHolder.class) ;

    /**
     * @description <p></p>
     * @param json 转换json
     * @Param clazz 转换bean类型
     * @return 转换出来的bean
     * @author heshiyuan
     * @date 2017/11/2 08:44
     */
    public static  <T> T responseJsonToBeanEnhance(String json,Class<T> clazz) throws ParamTransformException {
        if(null == json || "".equals(json)){
            return  null;
        }
        //防注入
        json = XssInjectionUtils.filterXssStr(json);
        Map<String, Class<?>> classMap = new HashMap<String, Class<?>>(1);
        classMap.put("data",clazz);
        // 如果json三层，在classMap多放一个参数
        try{
            ResponseBodyBean<T> responseBodyBean = JsonHelper.json2ObjStrong(json, ResponseBodyBean.class, classMap);
            if(!responseBodyBean.isSuccess()) throw new BusinessException(BusinessEnum.RESPONSE_DATA_IS_NULLEXCEPTION) ;
            T params = responseBodyBean.getData() ;
            return params;
        }catch(Exception e){
            _logger.error("请求参数解析错误,json数据是:{}",json);
            throw  new ParamTransformException(WebEnum.PARAM_TRANSFORM_EXCEPTION.getCode(),"响应json解析错误,json数据是:"+json);
        }
    }
    /**
     * @description <p></p>
     * @param json 转换json
     * @Param clazz 转换bean类型
     * @return 转换出来的bean
     * @author heshiyuan
     * @date 2017/11/2 08:44
     */
    public static <T> T responseJsonToBean(String json,Class<T> clazz){
        if(null == json || "".equals(json)) return  null;
        try{
            ResponseBodyBean<T> responseBody =  JSON.parseObject(json,new TypeReference<ResponseBodyBean>(){}) ;
            if(null == responseBody.getData()){
                return clazz.newInstance() ;
            }
            return JSON.parseObject(requestBeanToJson(responseBody.getData()),clazz) ;
        }catch(Exception e){
            _logger.error(e.getMessage(),e);
            _logger.error("请求参数解析错误,json数据是:{}",json);
            throw new ParamTransformException(WebEnum.PARAM_TRANSFORM_EXCEPTION.getCode(),"响应json解析错误,json数据是:"+json);
        }
    }
    /**
     * @description <p></p>
     * @param json 转换json
     * @Param clazz 转换bean类型
     * @return 转换出来的bean
     * @author heshiyuan
     * @date 2017/11/2 08:56
     */
    public static  <T> T requestJsonToBeanEnhance(String json,Class<T> clazz) throws ParamTransformException {
        if(null == json || "".equals(json)){
            return  null;
        }
        //防注入
        json = XssInjectionUtils.filterXssStr(json);
        Map<String, Class<?>> classMap = new HashMap<String, Class<?>>(1);
        classMap.put("param",clazz);
        // 如果json三层，在classMap多放一个参数
        try{
            RequestBodyBean<T> responseBodyBean = JsonHelper.json2ObjStrong(json, RequestBodyBean.class, classMap);
            T params = responseBodyBean.getParam();
            return params;
        }catch(Exception e){
            _logger.error("请求参数解析错误,json数据是:{}",json);
            throw  new ParamTransformException(WebEnum.PARAM_TRANSFORM_EXCEPTION.getCode(),"请求参数解析错误,json数据是:"+json);
        }

    }
    /**
     * @description <p></p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 1:09 PM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static <T> T requestJsonToBean(String json,Class<T> clazz){
        if(null == json || "".equals(json)) return  null;
        try{
            RequestBodyBean<T> requestBody =  JSON.parseObject(json,new TypeReference<RequestBodyBean>(){}) ;
            return JSON.parseObject(requestBeanToJson(requestBody.getParam()),clazz) ;
        }catch(Exception e){
            _logger.error("请求参数解析错误,json数据是:{}",json);
            throw  new ParamTransformException(WebEnum.PARAM_TRANSFORM_EXCEPTION.getCode(),"请求参数解析错误,json数据是:"+json);
        }
    }
    /**
     * @description <p></p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 1:09 PM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static String requestBeanToJson(Object obj){
        return JsonHelper.obj2Json(obj) ;
    }
}
