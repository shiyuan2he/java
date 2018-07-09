package com.hsy.java.base.bean;

import com.hsy.java.base.bean.BeanHelper;
import com.hsy.java.base.bean.User;
import org.junit.Test;
/**
 * @param
 * @author heshiyuan
 * @description <p></p>
 * @date 2017/7/6 13:15
 * @email shiyuan4work@sina.com
 * @github https://github.com/shiyuan2he.git
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
 */
public class BeanHelperTest {
    @Test
    public void testMapToBean(){
        User user = new User("admin","123") ;
        System.out.println(new BeanHelper().mapToBean(user).toString()) ;
    }
}
