package com.hsy.java.util.jdbc.dbutils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.util.jdbc.dbutils
 * @date 2018/8/2 14:02
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class C3p0Utils {
    private static final Logger logger = LoggerFactory.getLogger(C3p0Utils.class);
    private ComboPooledDataSource comboPooledDataSource;

    private static C3p0Utils c3p0Utils;

    static{
        logger.info("正在实例化");
        c3p0Utils = new C3p0Utils();
    }

    public C3p0Utils() {
        try {
            logger.info("正在初始化c3p0池子");
            comboPooledDataSource = new ComboPooledDataSource();

            //加载配置文件
            Properties props = new Properties();
            props.load(C3p0Utils.class.getClassLoader().getResourceAsStream("db.properties"));
            String dbSource = props.getProperty("db.source");
            switch (dbSource){
                case "mariadb":
                    comboPooledDataSource.setDriverClass(props.getProperty("db.mariadb.driverClass"));
                    logger.info("db.mariadb.driverClass -> {}", props.getProperty("db.mariadb.driverClass"));
                    comboPooledDataSource.setJdbcUrl(props.getProperty("db.mariadb.url"));
                    logger.info("db.mariadb.url -> {}", props.getProperty("db.mariadb.url"));
                    comboPooledDataSource.setUser(props.getProperty("db.mariadb.user"));
                    logger.info("db.mariadb.user -> {}", props.getProperty("db.mariadb.user"));
                    comboPooledDataSource.setPassword(props.getProperty("db.mariadb.password"));
                    logger.info("db.mariadb.password -> {}", props.getProperty("db.mariadb.password"));
                    break;
                case "mysql" :
                    comboPooledDataSource.setDriverClass(props.getProperty("db.mysql.driverClass"));
                    logger.info("db.mysql.driverClass -> {}", props.getProperty("db.mysql.driverClass"));
                    comboPooledDataSource.setJdbcUrl(props.getProperty("db.mysql.url"));
                    logger.info("db.mysql.driverClass -> {}", props.getProperty("db.mysql.driverClass"));
                    comboPooledDataSource.setUser(props.getProperty("db.mysql.user"));
                    logger.info("db.mysql.driverClass -> {}", props.getProperty("db.mysql.driverClass"));
                    comboPooledDataSource.setPassword(props.getProperty("db.mysql.password"));
                    logger.info("db.mysql.driverClass -> {}", props.getProperty("db.mysql.password"));
                    break;
                default:
                    break;
            }

            comboPooledDataSource.setMaxPoolSize(Integer.parseInt(props.getProperty("db.pool.maxPoolSize")));
            logger.info("db.pool.maxPoolSize -> {}", props.getProperty("db.pool.maxPoolSize"));
            comboPooledDataSource.setMinPoolSize(Integer.parseInt(props.getProperty("db.pool.minPoolSize")));
            logger.info("db.pool.minPoolSize -> {}", props.getProperty("db.pool.minPoolSize"));
            comboPooledDataSource.setInitialPoolSize(Integer.parseInt(props.getProperty("db.pool.initialPoolSize")));
            logger.info("db.pool.initialPoolSize -> {}", props.getProperty("db.pool.initialPoolSize"));
            comboPooledDataSource.setMaxStatements(Integer.parseInt(props.getProperty("db.pool.maxStatements")));
            logger.info("db.pool.maxStatements-> {}", props.getProperty("db.pool.maxStatements"));
            comboPooledDataSource.setMaxIdleTime(Integer.parseInt(props.getProperty("db.pool.maxIdleTime")));
            logger.info("db.pool.maxIdleTime -> {}", props.getProperty("db.pool.maxIdleTime"));

        } catch (Exception e) {
            logger.info("初始化数据库连接池发生异常，异常信息:{}", e);
        }
    }

    public static C3p0Utils getInstance(){
        return c3p0Utils;
    }
    /**
     * @description <p>获取数据库连接，默认自动提交事务打开</p>
     * @return Connection 数据库连接
     * @author heshiyuan
     * @date 2018/8/2 15:19
     */
    public Connection getConnection(){
        Connection conn = null;
        try {
            conn = comboPooledDataSource.getConnection();
        } catch (Exception e) {
            logger.info("初始化数据库连接池发生异常，异常信息:{}", e);
        }
        return conn;
    }
    /**
     * @description <p>获取数据库连接，默认自动提交事务打开</p>
     * @param autoCommit 事务是否自动提交
     * @return Connection 数据库连接
     * @author heshiyuan
     * @date 2018/8/2 15:19
     */
    public Connection getConnection(boolean autoCommit){
        Connection conn = null;
        try {
            conn = comboPooledDataSource.getConnection();
        } catch (Exception e) {
            logger.info("初始化数据库连接池发生异常，异常信息:{}", e);
        }
        try {
            if(autoCommit){
                conn.setAutoCommit(true);
            }else{
                conn.setAutoCommit(false);
            }
        } catch (SQLException e) {
            logger.info("关闭事务自动提交发生异常，异常信息:{}", e);
        }
        return conn;
    }

}

