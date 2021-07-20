package org.hsy.java.juc.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author heshiyuan
 * @date 2021/6/7 17:12
 */
public class ReentrantLockFair {
    private ReentrantLock fair = new ReentrantLock(true);

    public int lockFair(){
        for (int i = 0; i < 100; i++) {
            fair.lock();
            try{
                System.out.println(Thread.currentThread().getName() + " " + i);
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){

            }finally {
                fair.unlock();
            }
        }
        return 1;
    }
}
