package com.hsy.java.base.id;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.base.id
 * @date 2018/7/9 21:20
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class UUIDTest {
    private Logger logger = LoggerFactory.getLogger(UUIDTest.class);
    @Test
    public void testUuid(){
        UUID uuid = new UUID(2334l,3434l);
        logger.info("{}", UUID.randomUUID().toString().replaceAll("-", ""));
        logger.info("{}", UUID.fromString("882ee7dc-f95e-48d2-b1c3-68aca824dc8b"));
        logger.info("{}", uuid.version());
        logger.info("{}", uuid.variant());
    }
}
