/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * AccountInformationDAO
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-12
 */
public class AccountInformationDAO {

    public static final String url = "jdbc:mysql://127.0.0.1/delay_queue_db"; //数据库连接
    public static final String name = "com.mysql.cj.jdbc.Driver";   //程序驱动
    public static final String user = "root";  //用户名
    public static final String password = "root"; //密码

    public Connection conn = null;
    public PreparedStatement pst = null;

    /**
     * 创建一个新的实例 DBHelper.
     *
     * @param sql: SQL查询语句
     */
    public AccountInformationDAO(String sql) {
        try {
            Class.forName(name);// 指定连接类型
            conn = DriverManager.getConnection(url, user, password);// 获取连接
            pst = conn.prepareStatement(sql);// 准备执行语句
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法名称: close ；
     * 方法描述:  关闭数据库连接 ；
     */
    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
