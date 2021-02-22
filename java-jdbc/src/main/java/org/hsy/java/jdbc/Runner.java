package org.hsy.java.jdbc;

import org.hsy.java.jdbc.utils.DbHelper;

import java.sql.Connection;

/**
 * @author heshiyuan
 * @date 2021/2/22 10:27
 */
public class Runner {
    public static void main(String[] args) {
        Connection connection = DbHelper.getConnection();
    }
}
