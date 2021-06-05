package org.hsy.java.base.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.base.utils
 * @date 17/10/2018 7:06 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class NullPointerTest extends ConcurrentMock {
    volatile private static NullPointerTest nullPointerTest = null;

    static Map<String, String> idCard;

    static{
        idCard = new HashMap<>();
        idCard.put("aa", "bb");
    }

    public static NullPointerTest of() throws InterruptedException {
        if(nullPointerTest == null){
            synchronized (NullPointerTest.class){
                if(nullPointerTest == null){
                    nullPointerTest = new NullPointerTest();
                }
            }
        }
        return nullPointerTest;
    }
    public String getIdCard(){
        return idCard.get("aa");
    }
    @Test
    public void test() throws InterruptedException {
        execute();
    }
    @Override
    public int getConcurrentNo() {
        return 300;
    }

    @Override
    public void doMethod() throws InterruptedException {
        String idcard = NullPointerTest.of().getIdCard();
        System.out.println(idcard);
    }

    @Override
    public int getSleepTime() {
        return 10000;
    }
}
