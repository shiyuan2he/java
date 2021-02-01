package com.hsy.java.util.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author heshiyuan
 * @description <p>zookeeper连接</p>
 * @path java/com.hsy.java.util.zookeeper
 * @date 2018/8/20 16:35
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ZookeeperConnection {

    // declare zookeeper instance to access ZooKeeper ensemble
    // 定义一个访问zookeeper服务器集群的实例
    private static ZooKeeper zoo;
    static final CountDownLatch connectedSignal = new CountDownLatch(1);

    static final String host = null;
    static final int port = 0;
    static{
        connect("172.16.191.102", 2181);
    }
    // 连接zookeeper服务器集群的方法
    public static ZooKeeper connect(String host, int port){
        try {
            zoo = new ZooKeeper(host,port,new Watcher() {
                public void process(WatchedEvent we) {
                    if (we.getState() == Event.KeeperState.SyncConnected) {
                        connectedSignal.countDown();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connectedSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return zoo;
    }

    //关闭zookeeper服务器集群连接
    public void close() throws InterruptedException {
        zoo.close();
    }
}
