package org.hsy.java.exercise.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.exercise.string
 * @date 13/02/2019 21:26
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2019 shiyuan4work@126.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Slf4j
public class StringTest {

    @Test
    public void testInteger(){
        Integer a = new Integer(3);
        Integer b = new Integer(3);
        Integer c = 3;
        int d = 3;
        log.info("{}", a.equals(b));
        log.info("{}", b.equals(c));
        log.info("{}", c == d);
    }

    @Test
    public void testString(){
        String a = new String("3");
        String b = new String("3");
        String c = "3";
        final String d = "3";
        log.info("{}", a == b);
        log.info("{}", a.equals(b));
        log.info("{}", b == c);
        log.info("{}", b.equals(c));
        log.info("{}", c == d);
    }
}
