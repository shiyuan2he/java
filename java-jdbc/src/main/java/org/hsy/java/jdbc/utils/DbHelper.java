package org.hsy.java.jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author heshiyuan
 */
public class DbHelper {
    private static final String USERNAME_KEY = "username";
    private static String USERNAME = "";
    private static final String PASSWORD_KEY = "password";
    private static String PASSWORD = "";
    private static final String URL_KEY = "url.mariadb";
    private static String URL = "";
    private static final String DRIVER_KEY = "driver.mariadb";
    private static String DRIVER = "";

    static {
        Properties prop = new Properties();
        InputStream inputStream = DbHelper.class.getResourceAsStream("/jdbc.properties");
        if (null == inputStream) {
            throw new RuntimeException("未找到数据库配置文件，jdbc.properties");
        }
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(prop.containsKey(USERNAME_KEY)){
            USERNAME = prop.get(USERNAME_KEY).toString();
        }
        if(prop.containsKey(PASSWORD_KEY)){
            PASSWORD = prop.get(PASSWORD_KEY).toString();
        }
        if(prop.containsKey(URL_KEY)){
            URL = prop.get(URL_KEY).toString();
        }
        if(prop.containsKey(DRIVER_KEY)){
            DRIVER = prop.get(DRIVER_KEY).toString();
        }
        System.out.println(USERNAME);
        System.out.println(PASSWORD);
        System.out.println(URL);
        System.out.println(DRIVER);
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
