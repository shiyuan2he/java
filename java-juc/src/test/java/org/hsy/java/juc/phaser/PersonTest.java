package org.hsy.java.juc.phaser;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author heshiyuan
 * @date 2021/6/9 10:49
 */
public class PersonTest {

    
    @Test
    public void testMarry() throws InterruptedException {
        MarryPhaser.phaser.bulkRegister(16);
        for (int i = 0; i < 10; i++) {
            new Thread(new Person("路人" + i)).start();
        }
        new Thread(new Person("零号小三")).start();
        new Thread(new Person("一号小三")).start();
        new Thread(new Person("二号小三")).start();
        new Thread(new Person("三号小三")).start();
        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();
        TimeUnit.MINUTES.sleep(1);
    }
}