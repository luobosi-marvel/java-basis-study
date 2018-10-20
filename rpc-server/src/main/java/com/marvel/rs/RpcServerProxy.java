/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * RpcServerProxy
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
public class RpcServerProxy {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void publisher(Object service, int port) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);

            while (true) {
                // 接收一个请求
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessorHandler(socket, service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
