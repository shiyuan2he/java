package com.hsy.java.util.json;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.javase.json
 * @date 18/08/2017 1:22 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class JsonHelper {
    /**
     * @description <p>json转换成对象</p>
     * @param json 将要被转换成Javabean的json串
     * @param clazz 将要被转换成Javabean的类型
     * @return 转换成的javabean
     * @author heshiyuan
     * @date 21/08/2017 9:30 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static <T> T json2Obj(String json, Class<T> clazz) {
        return JSON.parseObject(json,clazz) ;
    }
    /**
     * @description <p>javabean转化成string</p>
     * @param  obj 待转化的javabean
     * @return 生成的json串
     * @author heshiyuan
     * @date 21/08/2017 9:33 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static String obj2Json(Object obj){
        return JSON.toJSONString(obj) ;
    }

    public static <T> T json2ObjStrong(String json, Class<T> clazz) {
      /*  net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(json);
        return (T) net.sf.json.JSONObject.toBean(jsonObject, clazz);*/
      return null;
    }

    public static <T> T json2ObjStrong(String json, Class<T> clazz, Map<String, Class<?>> classMap) {
        /*net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(json);
        return (T) net.sf.json.JSONObject.toBean(jsonObject, clazz, classMap);*/
        return null;
    }
    public static <T> T json2ObjStrong2(String json, Class<T> clazz) {
        return JSONObject.parseObject(json, clazz);
    }

    public static <T> List<T> json2Arr(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }

}
