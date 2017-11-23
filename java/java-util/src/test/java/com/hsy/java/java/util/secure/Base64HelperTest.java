package com.hsy.java.java.util.secure;

import com.hsy.java.util.secure.Base64Helper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.util.secure
 * @date 24/10/2017 3:04 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class Base64HelperTest {
    private final Logger _logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void testStringToBase64OfJdk(){
        _logger.info(Base64Helper.base64ToStringOfJdk(Base64Helper.stringToBase64OfJdk("hello world")));
    }
    @Test
    public void testStringToBase64OfCc(){
        _logger.info(Base64Helper.base64ToStringOfCc(Base64Helper.stringToBase64OfCc("hello world")));
    }
    @Test
    public void testStringToBase64OfBc(){
        _logger.info(Base64Helper.base64ToStringOfBc(Base64Helper.stringToBase64OfBc("hello world")));
    }
}
