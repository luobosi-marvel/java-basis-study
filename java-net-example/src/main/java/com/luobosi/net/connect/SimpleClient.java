/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.connect;

import java.io.IOException;
import java.net.Socket;

/**
 * SimpleClient
 * 第三次执行 Socket 构造方法时，由于服务端已经有了两个客户连接请求，队列已满，因此 SimpleClient 第三次请求连接
 * 时遭到拒绝，就会报 Exception in thread "main" java.net.ConnectException: Connection resused: connect 错误
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-02
 */
public class SimpleClient {

    private static final String ADDRESS = "localhost";

    public static void main(String[] args) throws IOException {
        Socket socket1 = new Socket(ADDRESS, 8000);
        System.out.println("第一次连接成功：" + socket1);
        Socket socket2 = new Socket(ADDRESS, 8000);
        System.out.println("第二次连接成功：" + socket2);
        Socket socket3 = new Socket(ADDRESS, 8000);
        System.out.println("第三次连接成功：" + socket3);
    }
}