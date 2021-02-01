package com.hsy.java.base.map;

import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.base.map
 * @date 19/10/2018 19:55
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class MapHelper {

    /**
     * @description <p>去除map中的null值和""值</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 19/10/2018 19:56
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved
     */
    public Map<String, Object> filterNull(Map<String, Object> map){
        Set<Map.Entry<String, Object>> set = map.entrySet();
        Iterator<Map.Entry<String, Object>> it = set.iterator();
        while(it.hasNext()){
            Map.Entry<String, Object> en = it.next();
            if(en.getValue() == null){ // 移除nul
                it.remove();
            }else if(en.getValue() instanceof String &&
                    StringUtils.isBlank(String.valueOf(en.getValue()))){// 移除""
                it.remove();
            }
        }
        return map;
    }
}
