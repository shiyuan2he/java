package com.hsy.javase.util;

import com.hsy.javase.utils.DateHelper;
import com.hsy.javase.utils.MathHelper;
import org.junit.Test;

import java.util.Date;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.javase.util
 * @date 14/08/2017 4:27 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class MathHelperTest {

    @Test
    public void testGenerateRandomByLength(){
        for(int i=0;i<10;i++){
            System.out.println("3028"+ DateHelper.getStrFromDateOfFormate(new Date(),"yyyyMMddmmhhssSSS")+MathHelper.generateRandomByLength(7));
        }

    }
}
