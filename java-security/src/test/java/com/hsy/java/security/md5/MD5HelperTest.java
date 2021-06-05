package org.hsy.java.security.md5;

import org.hsy.java.security.md5.MD5Helper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.util.secure
 * @date 2018/1/15 18:38
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class MD5HelperTest {
    private static final Logger _logger = LoggerFactory.getLogger(MD5HelperTest.class);
    @Test
    public void stringToMD5ByIdentified() throws Exception {
        _logger.info(MD5Helper.stringToMD5ByIdentified("CRM","admin"));
    }

    @Test
    public void validateMD5() throws Exception {

    }

    @Test
    public void validateMD5ByIdentified() throws Exception {
        _logger.info(""+MD5Helper.validateMD5ByIdentified(
                "B8C0C77FF03423AFD402485AA1781B8B","admin","CRM"));
    }

    @Test
    public void stringToMD5() throws Exception {
        _logger.info(MD5Helper.stringToMD5("admin"));
    }

}