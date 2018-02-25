/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.aio;

/**
 * Server
 *
 * @author luobosi@2dfire.com
 * @since 2018-02-25
 */
public class Server {
    /**
     * 默认端口号
     */
    private static final int DEFAULT_PORT = 12345;
    /**
     * 异步服务端处理器
     */
    private static AsyncServerHandler serverHandler;
    /**
     * 客户端连接数
     */
    public volatile static long clientCount = 0;

    private static void start() {
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port) {
        if (null != serverHandler) {
            return;
        }
        serverHandler = new AsyncServerHandler(port);
        new Thread(serverHandler, "Server").start();
    }

    public static void main(String[] args) {
        Server.start();
    }

}