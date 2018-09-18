package com.hsy.java.base.stream;

import com.hsy.java.base.bean.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.base.stream
 * @date 2018/9/18 20:09
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ListSteamTest {

    @Test
    public void testListStream(){
        pageList(1, 20);
    }

    private void pageList(int pageCurrent, int pageSize) {
        List list = generateList(10000);
        int lastCount = list.size() % pageSize;
        int count = list.size() / pageSize;
        for(int i=1;i<=count;i++){
            List<User> subList = null;
            subList = list.subList((i-1)*pageSize, i*pageSize);
            System.out.print(Arrays.toString(subList.toArray()));
            System.out.println();
        }
        System.out.print(Arrays.toString(list.subList(list.size()-lastCount, list.size()).toArray()));
    }

    private List<User> generateList(int count) {
        List<User> list = new ArrayList<>();
        for(int i=0;i<count;i++){
            list.add(new User(String.valueOf(i), String.valueOf(i)));
        }
        return list;
    }
}