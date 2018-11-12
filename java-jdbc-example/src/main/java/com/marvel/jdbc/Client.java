/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Client
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-12
 */
public class Client {
    static String sql = null;
    static AccountInformationDAO db1 = null;
    static ResultSet ret = null;

    public static void main(String[] args) {
        insert("luobosi", "1234567", "love");
        query();
    }


    private static void query() {
        sql = "select * from account_information";// SQL语句
        db1 = new AccountInformationDAO(sql);// 创建DBHelper对象
        System.out.println("编号--姓名--密码--信息");
        try {
            // 执行语句，得到结果集
            ret = db1.pst.executeQuery();
            while (ret.next()) {
                String id = ret.getString("id");
                String name = ret.getString("name");
                String password = ret.getString("password");
                String message = ret.getString(4);
                System.out.println(id + "\t" + name + "\t" + password + "\t" + message);
            }// 显示数据
            ret.close();
            db1.close();// 关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insert(String name, String password, String message) {
        try {
            String insert = "insert into account_information(name, password, message) values (?, ?, ?)";
            db1 = new AccountInformationDAO(insert);
            db1.pst.setString(1, name);
            db1.pst.setString(2, password);
            db1.pst.setString(3, message);

            db1.pst.executeLargeUpdate();
            db1.close();
        } catch (Exception e) {
            System.out.println("插入出錯！！");
            e.printStackTrace();
        }

    }

}