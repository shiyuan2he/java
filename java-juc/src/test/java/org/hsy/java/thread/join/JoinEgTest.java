package org.hsy.java.thread.join;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @date 2021/6/5 13:51
 */
public class JoinEgTest {
    JoinEg join = new JoinEg();
    @Test
    public void testJoin() throws InterruptedException {
        Assert.assertEquals(join.testJoin(), 1);
        TimeUnit.MINUTES.sleep(5);
    }
}