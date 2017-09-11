package com.hsy.javase.json;

import org.junit.Test;

import java.util.Map;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.javase.json
 * @date 21/08/2017 1:14 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class JsonHelperTest {

    @Test
    public void testJson2Obj(){
        String json = "{\"param\":{\"name\":\"何大大一\",\"password\":\"123456\",\"sex\":\"\\u0001\",\"tel\":15910868635}}" ;
        Map<String,Object> map = JsonHelper.json2Obj(json, Map.class) ;
        Map<String,Object> mapParam = (Map<String, Object>) map.get("param");
        System.out.println(mapParam.toString());
    }
}
