package org.hsy.java.thread.sleep;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @date 2021/6/5 14:11
 */
public class SleepEgTest {
    SleepEg sleepEg = new SleepEg();
    @Test
    public void testSleep() throws InterruptedException {
        Assert.assertEquals(1, sleepEg.testSleep());
        TimeUnit.MINUTES.sleep(2);
    }
}