package com.hsy.java.base.clazz;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.base.clazz
 * @date 24/11/2018 13:53
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Slf4j
public class ClassLoaderTest {
    @Test
    public void testClassLoader(){
        java.lang.ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        log.debug("{}", classLoader);
        java.lang.ClassLoader classLoaderParent = classLoader.getParent();
        log.debug("{}", classLoaderParent);
        java.lang.ClassLoader classLoaderParent2 = classLoaderParent.getParent();
        log.debug("{}", classLoaderParent2);
    }
}