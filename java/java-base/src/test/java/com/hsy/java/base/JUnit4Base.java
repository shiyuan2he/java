package com.hsy.java.base;

import com.hsy.java.thread.pool.FixedThreadPool;
import org.junit.Before;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.base
 * @date 30/09/2017 9:13 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class JUnit4Base {
    protected FixedThreadPool fixedThreadPool = null ;
    @Before
    public void before(){
        fixedThreadPool = new FixedThreadPool(10) ;
    }
}
