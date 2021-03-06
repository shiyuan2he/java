package org.hsy.java.base.regex;

import org.hsy.java.base.JUnit4Base;
import org.hsy.java.base.utils.RandomHelper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.base.regex
 * @date 30/09/2017 8:47 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ?5    微信：hewei1109
 */
public class RegexHelperTest extends JUnit4Base {
    private final static Logger _logger = LoggerFactory.getLogger(RegexHelperTest.class) ;
    @Test
    public void testNumberIntercept() throws Exception {
        String str = "fsdfsdf当时发生的发生地方34舒服的234 多福多寿日人399938" ;
        // RegexHelper.numberIntercept(str) ;
        Matcher matcher = Pattern.compile("[0-9]").matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()){
            sb.append(matcher.group());
        }
        _logger.info(sb.toString());
    }

    @Test
    public void testCheckCellPhone(){
        for(int i=0;i<1000;i++){
            new Runnable(){
                @Override
                public void run() {
                    String mobile = RandomHelper.generateStringByLength(11);
                    _logger.info("{}是否是手机号：{}", mobile, RegexHelper.checkCellphone(mobile));
                }
            };
        }
        try {
            Thread.sleep(10000);
            _logger.info("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
