package org.hsy.java.exercise.volatiles;

/**
 * @author heshiyuan
 * @description <p>同步计数器</p>
 * @path java/org.hsy.java.exercise.volatiles
 * @date 2018/1/23 14:32
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class Counter {
    private int count ;

    public int getCount() {
        return count;
    }
    public synchronized void increment(){
        ++ count;
    }
    public synchronized void decrement(){
        -- count;
    }
}
