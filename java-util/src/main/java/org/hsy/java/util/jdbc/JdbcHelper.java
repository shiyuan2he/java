package org.hsy.java.util.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path paac/com.hsy.paac.util
 * @date 30/08/2017 1:27 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class JdbcHelper {
    private static Logger _logger = LoggerFactory.getLogger(JdbcHelper.class.getName()) ;
    // 定义数据库的链接
    private static Connection conn;
    // 定义sql语句的执行对象
    private static PreparedStatement pstmt;
    // 定义查询返回的结果集合
    private static ResultSet rs;

    // 初始化
    public JdbcHelper(String driver, String url, String username, String password) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            _logger.info("数据库连接成功");
        } catch (Exception e) {
            _logger.info("数据库连接出现异常");
            e.printStackTrace();
        }
    }
    /**
     * @description <p>通过将JDBC的连接保存在ThreadLocal中，每个线程都会拥有属于自己的连接</p>
     * @author heshiyuan
     * @date 10/10/2017 5:07 PM
     */
    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>(){
        public Connection initialValue(){
        try {
            return DriverManager.getConnection("") ;
        } catch (SQLException e) {
            _logger.error("获取数据库连接异常，异常信息：{}",e.getMessage());
            e.printStackTrace();
        }
        return null ;
        }
    } ;
    /**
     * @description <p>获取数据库连接</p>
     * @param
     * @return 数据库连接对象
     * @author heshiyuan
     * @date 10/10/2017 5:07 PM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    public static Connection getConnection(){
        return connectionHolder.get() ;
    }

    // 更新数据
    public static boolean updateByParams(String sql, List params) throws SQLException {
        // 影响行数
        int result = -1;
        pstmt = conn.prepareStatement(sql);
        int index = 1;
        // 填充sql语句中的占位符
        if (null != params && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i ++) {
                pstmt.setObject(index ++, params.get(i));
            }
        }
        result = pstmt.executeUpdate();
        return result > 0 ? true : false;
    }

    // 查询多条记录
    public static List<Map<String,Object>> selectByParams(String sql, List<Map<String,Object>> params) throws SQLException {
        List<Map<String,Object>> list = new ArrayList<>();
        int index = 1;
        pstmt = conn.prepareStatement(sql);
        if (null != params && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i ++) {
                pstmt.setObject(index++, params.get(i));
            }
        }
        rs = pstmt.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int cols_len = metaData.getColumnCount();
        while (rs.next()) {
            Map map = new HashMap();
            for (int i = 0; i < cols_len; i ++) {
                String cols_name = metaData.getColumnName(i + 1);
                Object cols_value = rs.getObject(cols_name);
                if (null == cols_value) {
                    cols_value = "";
                }
                map.put(cols_name, cols_value);
            }
            list.add(map);
        }
        return list;
    }

    // 释放连接
    public void release() {
        try {
            if (null != rs) rs.close();
            if (null != pstmt) pstmt.close();
            if (null != conn) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        _logger.info("释放数据库连接");
    }
}
