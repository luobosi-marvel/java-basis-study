/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * EchoServer
 * UDP  协议是无连接的协议，客户端的 DatagramSocket 与服务器端的 DatagramSocket 不存在一一对应关系，两者无需建立
 * 连接，就能交换数据报。DatagramSocket 提供了接收和发送数据报的方法
 * 接收数据报：public void receive(DatagramPacket dst) throws IOException
 * 发送数据报：public void send(DatagramPacket src) throws IOException
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-04
 */
public class EchoServer {

    private static final int PORT = 8000;
    private DatagramSocket socket;

    public EchoServer() throws SocketException {
        socket = new DatagramSocket(PORT);
        System.out.println("服务器启动");
    }

    public String echo(String msg) {
        return "echo: " + msg;
    }

    public void service() {
        for (;;) {
            try {
                DatagramPacket packet = new DatagramPacket(new byte[512], 512);
                // 接收来自任意一个 EchoClient 的数据报
                socket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println(packet.getAddress() + ":" + packet.getPort() + ">" + msg);
                packet.setData(echo(msg).getBytes());
                // 给 EchoClient 回复一个数据报
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                socket.close();
            }
        }
    }

    public static void main(String[] args) throws SocketException {
        new EchoServer().service();
    }
}