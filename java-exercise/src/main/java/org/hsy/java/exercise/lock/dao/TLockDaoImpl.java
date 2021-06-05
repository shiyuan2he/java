package org.hsy.java.exercise.lock.dao;

import org.hsy.java.util.jdbc.dbutils.C3p0Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot/com.hsy.springboot.distributed.lock.dao
 * @date 2018/7/20 10:42
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class TLockDaoImpl {
    private PreparedStatement ps = null ;

    public int insert(String lock, String description){
        Connection connection = C3p0Utils.getInstance().getConnection();
        try {
            ps = connection.prepareStatement("insert into t_table_lock(lock_value, description) value(?,?)");
            ps.setString(1, lock);
            ps.setString(2, description);
            return ps.executeUpdate();
        } catch (SQLException e) {
            return 0;
        }
    }

    public int delete(String lock){
        Connection connection = C3p0Utils.getInstance().getConnection();
        try {
            ps = connection.prepareStatement("delete from t_table_lock where lock_value = ?");
            ps.setString(1,lock);
            return ps.executeUpdate();
        } catch (SQLException e) {
            return 0;
        }
    }
    public boolean lock() throws SQLException {
        Connection connection = C3p0Utils.getInstance().getConnection();
        connection.setAutoCommit(false);
        ps = connection.prepareStatement("select * from t_table_lock where lock_value = ? for update ");
        return false;
    }
}
