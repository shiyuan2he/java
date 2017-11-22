package com.hsy.java.java.base.regex;

import com.hsy.java.java.base.JUnit4Base;
import org.junit.Test;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.base.regex
 * @date 30/09/2017 8:47 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class RegexHelperTest extends JUnit4Base {

    @Test
    public void testNumberIntercept(){
        for(int i=0;i<100;i++){
            fixedThreadPool.getFixedThreadPool().execute(new Runnable() {
                @Override
                public void run() {
                    String str = "fsdfsdf当时发生的发生地方34舒服的234 多福多寿日人399938" ;
                    try {
                        RegexHelper.numberIntercept(str) ;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            /*fixedThreadPool.getFixedThreadPool().execute(()->{
                String str = "fsdfsdf当时发生的发生地方34舒服的234 多福多寿日人399938" ;
                try {
                    RegexHelper.numberIntercept(str) ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });*/
        }
    }
}
