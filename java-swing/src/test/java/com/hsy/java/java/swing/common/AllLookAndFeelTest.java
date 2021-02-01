package com.hsy.java.java.swing.common;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.swing.common
 * @date 12/10/2017 1:36 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class AllLookAndFeelTest {
    private static final Logger _logger = LoggerFactory.getLogger(AllLookAndFeelTest.class) ;

    @Test
    public void testLookAndFeel(){
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            _logger.info(info.getName());
        }
    }
}
