/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.connect;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * ConnectTester
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-01
 */
public class ConnectTester {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 25;
        new ConnectTester().connect(host, port);
    }

    private void connect(String host, int port) {
        InetSocketAddress remoteAddr = new InetSocketAddress(host, port);
        Socket socket;
        String result;

        try {
            long begin = System.currentTimeMillis();
            socket = new Socket();
            // 超时时间为 1 秒钟
            socket.connect(remoteAddr, 1000);
            long end = System.currentTimeMillis();
            // 计算连接所花的时间
            result = (end - begin) + "ms";
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }

}