/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rc;

import com.luobosi.common.request.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * RpcNetTransport
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
public class RpcNetTransport {

    private String host;

    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Socket newSocket() {
        System.out.println("创建一个新的 socket 连接");

        Socket socket = null;

        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            System.out.println("创建连接失败");
            e.printStackTrace();
        }

        return socket;
    }

    public Object sendRequest(RpcRequest request) {
        Socket socket = null;
        Object result;
        try {
            socket = newSocket();
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(request);
            outputStream.flush();

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            result = inputStream.readObject();

            inputStream.close();
            outputStream.close();

        } catch (Exception e) {
            throw new RuntimeException("发送数据异常" + e);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
