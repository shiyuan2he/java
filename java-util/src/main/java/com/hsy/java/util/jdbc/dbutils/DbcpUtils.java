package com.hsy.java.util.jdbc.dbutils;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.util.jdbc.dbutils
 * @date 2018/8/2 15:05
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class DbcpUtils {
    private static Properties properties = new Properties();
    private static DataSource dataSource;

    //加载DBCP配置文件
    static {
        try {
            FileInputStream is = new FileInputStream("db.properties");
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //从连接池中获取一个连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
