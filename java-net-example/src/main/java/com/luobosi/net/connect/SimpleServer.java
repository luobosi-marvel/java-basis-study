/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.connect;

import java.net.ServerSocket;

/**
 * SimpleServer
 * SimpleServer 类是一个简单的服务器程序，它监听 8000 端口。ServerSocket(int port, int backlog) 构造方法的第二个参数
 * backlog，设定服务器的连接请求队列的长度，如果队列中的连接请求已满，服务器就会拒绝其余的连接请求。
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-02
 */
public class SimpleServer {

    private static final int PORT = 8000;

    public static void main(String[] args) throws Exception {
        new ServerSocket(PORT, 2);
        Thread.sleep(360000L);
    }
}