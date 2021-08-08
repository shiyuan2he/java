package org.hsy.java.base.object;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author heshiyuan
 * @date 2021/8/7 10:25
 */
public class ObjectDemoTest {

    @Test
    public void testBasic(){
        int a = 111;
        int b = 222;
    }
    @Test
    public void testInteger(){
        Integer a = 111;
        Integer b = 222;

        Assert.assertTrue(a.equals(b));
    }
}