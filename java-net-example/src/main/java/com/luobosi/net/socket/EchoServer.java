/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * EchoServer
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-01
 */
public class EchoServer {

    private int port = 8000;
    private ServerSocket serverSocket;

    /**
     * 构造方法，启动服务器
     *
     * @throws IOException
     */
    public EchoServer() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("服务器启动");
    }

    public String echo(String msg) {
        return "echo: " + msg;
    }

    /**
     * 从 socket 里面获取 OutputStream 流，并将 OutputStream 封装成 PrintWriter 流
     * OutputStream 里面包含了 client 端发送的数据
     *
     * @param socket    网络 socket
     * @return          打印流
     * @throws IOException
     */
    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        return new PrintWriter(outputStream);
    }

    /**
     * 从 socket 里面获取 InputStream 流，并将 InputStream 封装成 BufferedReader 流
     * 从 socket 获取的 InputStream 流可以把 server 端的数据发送到 client 端
     *
     * @param socket        网络 socket
     * @return              缓冲流
     * @throws IOException
     */
    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private void service() {
        while (true) {
            Socket socket = null;
            try {
                // 等待客户连接
                socket = serverSocket.accept();
                System.out.println("New connection accepted " + socket.getInetAddress() + ":" + socket.getPort());

                BufferedReader bufferedReader = getReader(socket);
                PrintWriter printWriter = getWriter(socket);

                String msg = null;
                while ((msg = bufferedReader.readLine()) != null) {
                    System.out.println(msg);
                    printWriter.println(echo(msg));
                    if ("bye".equals(msg)) {
                        break;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        // 关闭 socket
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoServer().service();
    }
}