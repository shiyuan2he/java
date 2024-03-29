package org.hsy.java.thread.runnable;


import java.util.logging.Logger;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.thread.pool
 * @date 2018/7/19 14:50
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public final class LiftOffRunnable implements Runnable{
    private Logger logger = Logger.getLogger(this.getClass().getName());
    protected int countDown = 10 ;
    private static int taskCount = 0;
    private final int id = taskCount ++ ;

    public LiftOffRunnable() {}

    public LiftOffRunnable(int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        while (countDown --> 0){
            logger.info(""+ getStatus());
            Thread.yield();
        }
    }

    private String getStatus() {
        return "# "+id+"(" + (countDown>0?countDown:0) + ")" ;
    }
}


