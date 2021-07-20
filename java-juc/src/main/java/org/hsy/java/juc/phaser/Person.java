package org.hsy.java.juc.phaser;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author heshiyuan
 * @date 2021/6/9 10:39
 */
public class Person implements Runnable{
    Random random = new Random();
    String name;
    public Person(String name) {
        this.name = name;
    }

    public void arrive() {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s 到达现场！\n", name);
        if("一号小三".equals(name)){
            MarryPhaser.phaser.arriveAndDeregister();
            System.out.printf("%s 看到现场后生气的离开了！\n", name);
        }
    }

    public void eat() {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if ("二号小三".equals(name)) {
            System.out.printf("%s 没吃饭生气的离开了！\n", name);
            MarryPhaser.phaser.arriveAndDeregister();
        }else{
            System.out.printf("%s 吃完!\n", name);
            if ("三号小三".equals(name)) {
                try {
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                }
                System.out.printf("%s 吃完饭，但是饭太难吃了，离开了！\n", name);
                MarryPhaser.phaser.arriveAndDeregister();
            }else{
                MarryPhaser.phaser.arriveAndAwaitAdvance();
            }
        }
    }
    public void leave () {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if("零号小三".equals(name)){
            System.out.printf("%s 大闹婚礼！\n", name);
            MarryPhaser.phaser.arriveAndAwaitAdvance();
        }else{
            System.out.printf("%s 离开！\n", name);
            MarryPhaser.phaser.arriveAndDeregister();
        }
    }
    private void hug () {
        if (name.equals("新郎") || name.equals("新娘")) {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s 洞房！\n", name);
            MarryPhaser.phaser.arriveAndAwaitAdvance();
        } else {
            System.out.printf("%s 被强制离开，因为新郎新娘要爱爱！\n", name);
            MarryPhaser.phaser.arriveAndDeregister();
        }
    }

    @Override
    public void run(){
        arrive();
        eat();
        leave();
        hug();
    }
}
