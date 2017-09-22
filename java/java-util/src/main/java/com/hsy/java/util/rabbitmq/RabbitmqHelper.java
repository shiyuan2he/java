package com.hsy.java.util.rabbitmq;
import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path spider/com.hsy.spider.base.utils
 * @date 22/09/2017 1:50 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class RabbitmqHelper {

    private static final Logger _logger = LoggerFactory.getLogger(RabbitmqHelper.class);

    private static volatile RabbitmqHelper instance ;
    private RabbitmqHelper(){
        if(null != instance){
            // 防止反射
            throw new IllegalStateException("Already initialized! please don't use reflect.") ;
        }
    }
    public String QUEUE_NAME = null ;
    public String QUEUE_HOST = null ;
    public Integer QUEUE_PORT = 0 ;
    public String QUEUE_USER_NAME = null ;
    public String QUEUE_PASSWORD = null ;
    //创建连接工厂
    private static ConnectionFactory factory = null ;
    private static Connection connection = null;

    private RabbitmqHelper(String queue,String host,Integer port,String user,String password){
        if(null != instance){
            // 防止反射
            throw new IllegalStateException("Already initialized! please don't use reflect.") ;
        }
        this.QUEUE_NAME = queue ;
        this.QUEUE_HOST = host ;
        this.QUEUE_PORT = port ;
        this.QUEUE_USER_NAME = user ;
        this.QUEUE_PASSWORD = password ;
        //创建连接工厂
        factory = new ConnectionFactory();
        //设置RabbitMQ相关信息
        factory.setHost(QUEUE_HOST);
        factory.setPort(QUEUE_PORT);
        factory.setUsername(QUEUE_USER_NAME);
        factory.setPassword(QUEUE_PASSWORD);
    }
    /**
     * @descripion <p>单例模式-保证单例</p>
     * @return RabbitmqHelper 全局单例对象
     * @author heshiyuan
     * @date 22/09/2017 2:01 PM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static RabbitmqHelper getInstance(String queue,String host,Integer port,String user,String password){
        RabbitmqHelper result = instance ;
        if(result == null){
            synchronized (RabbitmqHelper.class){
                result = instance;
                if(null == result){
                    result = instance = new RabbitmqHelper(queue,host,port,user,password);
                }
            }
        }
        return result ;
    }
    /**
     * @param isNew 是否new一个连接
     */
    public static Connection getConnection(boolean isNew){
        try {
            if(isNew) return factory.newConnection();
            if(null == connection){
                connection = factory.newConnection();
            }
        } catch (IOException e) {
            _logger.error("建立rabbit连接出现异常，异常信息：{}",e.getMessage());
            e.printStackTrace();
        } catch (TimeoutException e) {
            _logger.error("连接rabbitmq超时，异常信息：{}",e.getMessage());
            e.printStackTrace();
        }
        return connection ;
    }
}
