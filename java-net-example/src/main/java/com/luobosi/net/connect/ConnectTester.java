/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.connect;

import java.io.IOException;
import java.net.*;

/**
 * ConnectTester
 * 该类介绍了抛出各种异常的原因。ConnectTester 连接到指定地址，如果连接成功，就会计算建立连接所花的时间：
 * 如果连接失败，就会捕获各种异常。
 *
 * 1. 抛出 UnknownHostException 的情况
 *      如果无法识别主机的名字或 IP 地址，就会抛出这种异常。
 * 2. 抛出 ConnectException 的情况
 *      在以下两种情况下会抛出 ConnectException
 *      ① 没有服务器进程监听指定的端口。
 *      ② 服务器进程拒绝连接
 *          下面介绍服务器进程拒绝客户的连接请求的情形。请看 SimpleServer 和 SimpleClient 两个类
 * 3. 抛出 SocketTimeoutException 的情形
 *      如果客户端等待连接超时，就会抛出这种异常 socket.connect(remoteAddr, 1000); 单位是毫秒
 * 4. 抛出 BindException 的情形
 *      如果无法把 Socket 对象与指定的本地 IP 地址或端口绑定，就会抛出这种异常。
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
        Socket socket = null;
        String result;

        try {
            long begin = System.currentTimeMillis();
            socket = new Socket();
            // 超时时间为 1 秒钟
            socket.connect(remoteAddr, 1000);
            long end = System.currentTimeMillis();
            // 计算连接所花的时间
            result = (end - begin) + "ms";
        } catch (BindException e) {
            result = "Local address and port can't be binded";
        } catch (UnknownHostException e) {
            result = "Unknown Host";
        } catch (SocketTimeoutException e) {
            result = "TimeOut";
        } catch (IOException e) {
            result = "failure";
        } finally {
            try {
                if (null != socket) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(remoteAddr + ":" + result);
    }

}