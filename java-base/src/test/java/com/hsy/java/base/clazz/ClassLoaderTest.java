package com.hsy.java.base.clazz;
import org.junit.Test;
import java.util.logging.Logger;

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
public class ClassLoaderTest {
    Logger log = Logger.getLogger(ClassLoaderTest.class.getName());
    @Test
    public void testClassLoader(){
        java.lang.ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        log.info("" + classLoader);
        java.lang.ClassLoader classLoaderParent = classLoader.getParent();
        log.info("" +  classLoaderParent);
        java.lang.ClassLoader classLoaderParent2 = classLoaderParent.getParent();
        log.info("" +  classLoaderParent2);
    }
}