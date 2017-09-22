package com.hsy.spider.base.utils;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
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
    private static Logger _logger = LoggerFactory.getLogger(HttpUtils.class);

    private static volatile RabbitmqHelper instance ;
    private RabbitmqHelper(){
        if(null != instance){
            // 防止反射
            throw new IllegalStateException("Already initialized! please don't use reflect.") ;
        }
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
    public static RabbitmqHelper getInstance(){
        RabbitmqHelper result = instance ;
        if(result == null){
            synchronized (RabbitmqHelper.class){
                result = instance;
                if(null == result){
                    result = instance = new RabbitmqHelper();
                }
            }
        }
        return result ;
    }

    public static String QUEUE_NAME = null ;
    public static String QUEUE_HOST = null ;
    public static Integer QUEUE_PORT = 0 ;
    public static String QUEUE_USER_NAME = null ;
    public static String QUEUE_PASSWORD = null ;

    static{
        Properties prop = new Properties();
        FileInputStream in = null;
        String path = "properties/rabbitmq.properties" ;
        try {
            in = new FileInputStream(path);
            prop.load(in);
            QUEUE_NAME = prop.getProperty("rabbitmq.queue.name") ;
            QUEUE_HOST = prop.getProperty("rabbitmq.queue.host") ;
            QUEUE_PORT = Integer.parseInt(prop.getProperty("rabbitmq.queue.port")) ;
            QUEUE_USER_NAME = prop.getProperty("rabbitmq.queue.username") ;
            QUEUE_PASSWORD = prop.getProperty("rabbitmq.queue.password") ;
            in.close();
        } catch (FileNotFoundException e) {
            _logger.error("去读{}配置文件发生异常，异常信息：{}",path,e.getMessage());
        } catch (IOException e1) {
            _logger.error("去读{}配置文件发生异常，异常信息：{}",path,e1.getMessage());
        }
    }
    private Connection connection = null;
    /**
     * @param isNew 是否new一个连接
     */
    private Connection getConnection(boolean isNew){
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ相关信息
        factory.setHost(QUEUE_HOST);
        factory.setPort(QUEUE_PORT);
        factory.setUsername(QUEUE_USER_NAME);
        factory.setPassword(QUEUE_PASSWORD);
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
    /**
     * @description <p>
    *  注1：queueDeclare第一个参数表示队列名称、第二个参数为是否持久化（true表示是，队列将在服务器重启时生存）、
     *     第三个参数为是否是独占队列（创建者可以使用的私有队列，断开后自动删除）、
     *     第四个参数为当所有消费者客户端连接断开时是否自动删除队列、第五个参数为队列的其他参数
     * 注2：basicPublish第一个参数为交换机名称、第二个参数为队列映射的路由key、第三个参数为消息的其他属性、第四个参数为发送信息的主体
     * </p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 22/09/2017 3:08 PM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static void getProducer(Object obj){
        //创建一个通道
        Channel channel = null;
        try {
            channel = RabbitmqHelper.getInstance().getConnection(false).createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  声明一个队列 channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //发送消息到队列中
        try {
            channel.basicPublish("", QUEUE_NAME, null, obj.toString().getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //关闭通道和连接
        try {
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void getConsumer(){
        //创建一个通道
        Channel channel = null;
        try {
            channel = RabbitmqHelper.getInstance().getConnection(false).createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //声明要关注的队列
        try {
            channel.queueDeclare(QUEUE_NAME, false, false, true, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //DefaultConsumer类实现了Consumer接口，通过传入一个频道，
        // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Customer Received '" + message + "'");
            }
        };
        //自动回复队列应答 -- RabbitMQ中的消息确认机制
        try {
            channel.basicConsume(QUEUE_NAME, true, consumer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
