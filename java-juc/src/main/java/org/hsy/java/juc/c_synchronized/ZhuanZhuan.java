package org.hsy.java.juc.c_synchronized;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author heshiyuan
 * @date 2021/7/23 11:05
 */
public class ZhuanZhuan {
    private Logger logger = Logger.getLogger(ZhuanZhuan.class.getName());
    private int number;

    public synchronized void addNumber() throws InterruptedException {
//        Thread.sleep(1000);
//        logger.info("addNumber number = " + number);
//        number ++;
//        logger.info("addNumber number = " + number);
//        Thread.sleep(1000);
    }

    public synchronized static  void addNumber1() throws InterruptedException {
    }

    private Object obj = new Object();
    public int getNumber() throws InterruptedException {
        synchronized(obj){
            TimeUnit.SECONDS.sleep(2);
            logger.info("getNumber number = " + number);
            setNumber(1);
            return number;
        }
    }

    public void setNumber(int number) {
        synchronized(obj){
            this.number = number;
        }
    }

    public static void main(String[] args) {
        String str2 = new String("aaa");
        String str3 = new String("aaa");

        System.out.println("==" + (str2 == str3));
        System.out.println("equals=" + (str2.equals(str3)));
    }
}
