package org.hsy.java.base.stream;

import org.hsy.java.base.bean.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.base.stream
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

    @Test
    public void testListStream3(){
        List<User> list = generateList(10);
        list.stream().forEach(entity -> entity.setPassword("444"));

        long t0 = System.currentTimeMillis();
        list = list.stream().filter(entity -> "555".equals(entity.getPassword())).collect(Collectors.toList());
        long t1 = System.currentTimeMillis();
        System.out.println("stream " + (t1-t0));
        long count = list.stream().count();
        System.out.println(count);
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

    @Test
    public void testListStream2(){
        List<User> list = generateList(10);
        List<User> list2 = generateList(10);

        long t2 = System.currentTimeMillis();
        for(User user : list){
            user.setPassword("444");
        }
        long t3 = System.currentTimeMillis();
        System.out.println("for " + (t3-t2));

        long t0 = System.currentTimeMillis();
        list2.stream().forEach(entity -> entity.setPassword("444"));
        long t1 = System.currentTimeMillis();
        System.out.println("stream " + (t1-t0));

    }

    private List<User> generateList(int count) {
        List<User> list = new ArrayList<>();
        for(int i=0;i<count;i++){
            list.add(new User(String.valueOf(i), String.valueOf(i)));
        }
        return list;
    }
}