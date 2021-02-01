package com.hsy.java.exercise.stringArray;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.exercise.stringArray
 * @date 11/02/2019 20:57
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2019 shiyuan4work@126.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Slf4j
public class StringArrayTest {
    @Test
    public void testStringCompareArray(){
        String text = "newMapK1=newMapV1;newMapK2=newMapV2\nnewMap2K1=newMap2V1;newMap2K2=newMap2V2";

        List<Map<String, String>> innerList = new ArrayList<>();
        Map<String, String> newMap1 = new HashMap<>();
        newMap1.put("newMapK1", "newMapV1");
        newMap1.put("newMapK2", "newMapV2");
        innerList.add(newMap1);
        Map<String, String> newMap2 = new HashMap<>();
        newMap2.put("newMap2K1", "newMap2V1");
        newMap2.put("newMap2K2", "newMap2V2");
        innerList.add(newMap2);
        Assert.assertEquals(load(text), innerList);
        // 由于hashmap无序性，输出的字符串顺序不一致，导致不相等
//        Assert.assertEquals(text, store(innerList));
    }

    public String store(List<Map<String, String>> list){
        if(null==list || list.size()==0) {
            log.warn("list can not be null");
            return null;
        }
        StringBuilder returnStr = new StringBuilder();
        list.stream().forEach(ele -> {
            if(ele!=null){
                StringBuilder innerStr = new StringBuilder();
                ele.forEach((k, v) -> innerStr.append(k).append("=").append(v).append(";"));
                returnStr.append(innerStr.substring(0, innerStr.length()-1)).append("\\n");
            }
        });
        return returnStr.substring(0, returnStr.length()-2);
    }

    public List<Map<String, String>> load(String valueStr){
        List<Map<String, String>> returnList = new ArrayList<>();
        if(StringUtils.isBlank(valueStr)){
            log.warn("字符串不能为空");
            return null;
        }
        String[] valueArray = valueStr.split("\\n");
        if(null==valueArray || valueArray.length==0){
            log.warn("数组元素为空");
            return null;
        }
        for(int i=0; i<valueArray.length; i++){
            String[] dicArray = valueArray[i].split(";");
            if(null==dicArray || dicArray.length==0){
                log.warn("字典元素为空");
                return null;
            }
            Map<String, String> map = new HashMap<>();
            for(int j=0; j<dicArray.length; j++){
                String[] strArray = dicArray[j].split("=");
                if(null==strArray || strArray.length==0){
                    log.warn("字符串元素为空");
                    return null;
                }
                map.put(strArray[0], strArray[1]);
            }
            returnList.add(map);
        }
        return returnList;
    }

}
