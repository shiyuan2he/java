package com.hsy.java.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.exercise
 * @date 2017/11/10 17:08
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ListForEachTest {
    /**
     * @description <p>给list的forEach外部变量赋值</p>
     * @author heshiyuan
     * @date 2017/11/10 17:16
     */
    @Test
    public void testForEachOfJdk8(){
        List<Map<String,String>> listMap = new ArrayList<>() ;

        getListMap().forEach(new MyConsumer(listMap));
        System.out.println(listMap.toString()) ;
    }

    @Test
    public void testForEachOfJdk8Of2(){
        List<Map<String,String>> listMap = new ArrayList<>() ;
        getListMap().forEach(maps -> listMap.add(maps));
        System.out.println(listMap.toString()) ;
    }

    // 组装list，用以forEach
    private List<Map<String,String>> getListMap() {
        List<Map<String,String>> listMap = new ArrayList<>() ;
        for(int i=1;i<=3;i++){
            Map<String,String> map = new HashMap<>() ;
            map.put(String.valueOf(i),String.valueOf(i)) ;
            listMap.add(map) ;
        }
        return listMap ;
    }

    class MyConsumer implements Consumer<Map<String,String>>{
        List<Map<String,String>> listMap = new ArrayList<>() ;
        public MyConsumer(List<Map<String,String>> listMap) {
            this.listMap = listMap ;
        }
        @Override
        public void accept(Map<String, String> stringStringMap) {
            listMap.add(stringStringMap) ;
        }
    }
}
