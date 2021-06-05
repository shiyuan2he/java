package org.hsy.java.base.clazz;

import java.util.logging.Logger;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.base.clazz
 * @date 24/11/2018 13:53
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ClassLoader {
    static Logger log = Logger.getLogger(ClassLoader.class.getName());
    public static void main(String[] args) {
        java.lang.ClassLoader classLoader = ClassLoader.class.getClassLoader();
        log.info("" + classLoader);
        java.lang.ClassLoader classLoaderParent = classLoader.getParent();
        log.info("" +  classLoaderParent);
        java.lang.ClassLoader classLoaderParent2 = classLoaderParent.getParent();
        log.info("" +  classLoaderParent2);
    }
}
