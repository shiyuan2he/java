package com.hsy.java.base.number;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heshiyuan
 * @description <p>Number类练习</p>
 * @path java/com.hsy.java.java.base.number
 * @date 2018/1/8 11:25
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class NumberDo {
    private static final Logger _logger = LoggerFactory.getLogger(NumberDo.class) ;
    /**
     * @description <p>
     *      测试java对-127~127的数据进行缓存
     *      Java 会对 -127~127 的整数进行缓存，并且注意 == 和 equals 的区别。
     * </p>
     * @author heshiyuan
     * @date 2018/1/8 11:28
     */
    public void testIntegerEqual(){
        Integer a = 10;
        Integer b = 10;
        _logger.info("{}",a == b);        // true
        _logger.info("{}",a.equals(b));   // true
        Integer c = 1000;
        Integer d = 1000;
        _logger.info("{}",c == d);        // false
        _logger.info("{}",c.equals(d));   // true
    }
}
