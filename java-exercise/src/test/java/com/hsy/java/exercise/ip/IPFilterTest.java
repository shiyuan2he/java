package com.hsy.java.exercise.ip;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.exercise.ip
 * @date 2018/8/20 9:40
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class IPFilterTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void validate() {
        logger.info("{}", IPFilter.validate("1.1.1.1"));
        logger.info("{}", IPFilter.validate("1.2.3.4."));
        logger.info("{}", IPFilter.validate("256.2.3.4"));
        logger.info("{}", IPFilter.validate("1.2.3.4.5"));
        logger.info("{}", IPFilter.validate("1.2.3.4"));
        logger.info("{}", IPFilter.validate("a.2.3.4"));
    }

    @Test
    public void validate1() {
        logger.info("{}", IPFilter.validate("1.1.1.1", null, null));
        logger.info("{}", IPFilter.validate("1.2.3.4.", null, null));
        logger.info("{}", IPFilter.validate("256.2.3.4", null, null));
        logger.info("{}", IPFilter.validate("1.2.3.4.5", null, null));
        logger.info("{}", IPFilter.validate("1.2.3.4", null, null));
    }
    @Test
    public void validate2() {
        logger.info("{}", IPFilter.validateByPattern("1.1.1.1"));
        logger.info("{}", IPFilter.validateByPattern("1.2.3.4."));
        logger.info("{}", IPFilter.validateByPattern("256.2.3.4"));
        logger.info("{}", IPFilter.validateByPattern("1.2.3.4.5"));
        logger.info("{}", IPFilter.validateByPattern("1.2.3.4"));
        logger.info("{}", IPFilter.validateByPattern("a.2.3.4"));
    }
}