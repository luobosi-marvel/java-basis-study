/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * EchoServer
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-03
 */
public class EchoServer {

    private static final int PORT = 8000;

    private ServerSocket serverSocket;

    public EchoServer() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("服务器启动了");
    }

    public void service() {
        while (true) {
            Socket socket = null;

            try {
                // 接收客户连接
                socket = serverSocket.accept();
                // 创建一个工作线程
                Thread workThread = new Thread(new Handler(socket));
                // 启动工作线程
                workThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoServer().service();
    }
}

class Handler implements Runnable {

    private Socket socket;
    private static final String BYE = "bye";

    public Handler(Socket socket) {
        this.socket = socket;
    }

    private PrintWriter getWriter(Socket socket) {
        return null;
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        return null;
    }

    public String echo(String msg) {
        return null;
    }

    @Override
    public void run() {
        try {
            System.out.println("New connection accepted " + socket.getInetAddress() + ":" + socket.getPort());

            BufferedReader reader = getReader(socket);
            PrintWriter writer = getWriter(socket);

            String msg = null;
            // 接收和发送数据，知道通信结束
            while ((msg = reader.readLine()) != null) {
                System.out.println(msg);
                writer.println(echo(msg));
                if (BYE.equals(msg)) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}