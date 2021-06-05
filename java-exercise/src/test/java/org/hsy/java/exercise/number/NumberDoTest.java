package org.hsy.java.exercise.number;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.exercise.number
 * @date 2018/8/20 10:07
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class NumberDoTest {
    private static final Logger _logger = LoggerFactory.getLogger(NumberDoTest.class) ;
    @Test
    public void testIntegerEqual() {
        Integer a = 10;
        Integer b = 10;
        _logger.info("{}",a == b);
        _logger.info("{}",a.equals(b));
        Integer c = 127;
        Integer d = 127;
        _logger.info("{}",c == d);
        _logger.info("{}",c.equals(d));

        int e = 128;
        int f = 128;
        _logger.info("{}", e == f);

        Integer g = 128;
        Integer h  = 128;
        _logger.info("{}", g == h);
        for (int i = 0; i < 1000; i++) {
            Integer m = i;
            Integer n = i;
            if(m != n){
                _logger.info("{}", i);
                break;
            }
        }
    }
}