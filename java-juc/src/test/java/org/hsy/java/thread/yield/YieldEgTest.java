package org.hsy.java.thread.yield;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @date 2021/6/5 14:06
 */
public class YieldEgTest {
    YieldEg yieldEg = new YieldEg();
    @Test
    public void testYield() throws InterruptedException {
        Assert.assertEquals(1, yieldEg.testYield());
        TimeUnit.MINUTES.sleep(2);
    }
}