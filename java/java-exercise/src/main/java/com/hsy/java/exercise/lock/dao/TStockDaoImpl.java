package com.hsy.java.exercise.lock.dao;

import com.hsy.java.util.jdbc.dbutils.C3p0Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

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
public class TStockDaoImpl {
    private PreparedStatement ps = null ;

    public int reduce(){
        Connection connection = C3p0Utils.getInstance().getConnection();
        try {
            ps = connection.prepareStatement("update t_stock set count = count-1 where id = 1");
            return ps.executeUpdate();
        } catch (SQLException e) {
            return 0;
        }
    }

    public int getCount(long id){
        Connection connection = C3p0Utils.getInstance().getConnection();
        try {
            ps = connection.prepareStatement("select count from t_stock where id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            return 0;
        }
        return 0;
    }
    public Date getVersion(long id){
        Connection connection = C3p0Utils.getInstance().getConnection();
        try {
            ps = connection.prepareStatement("select update_time from t_stock where id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getDate(1);
            }
        } catch (SQLException e) {
            return Calendar.getInstance().getTime();
        }
        return Calendar.getInstance().getTime();
    }
}
