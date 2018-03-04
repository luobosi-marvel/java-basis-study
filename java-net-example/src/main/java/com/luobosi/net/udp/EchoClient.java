/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * EchoClient
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-04
 */
public class EchoClient {

    private static final String REMOTE_ADDR = "localhost";

    private static final String BYE = "bye";

    private static final int PORT = 8000;

    private DatagramSocket socket;

    public EchoClient() throws SocketException {
        socket = new DatagramSocket();
    }

    public static void main(String[] args) throws IOException {
        new EchoClient().talk();
    }

    /**
     * 给服务端发送数据
     * 1. 拿到服务端的地址，有个目标
     * 2. 准备好要发送的数据
     * 3. 将数据封装成 DatagramPackage，然后通过 DatagramSocket 发送出去
     *
     * @throws IOException
     */
    public void talk() throws IOException {
        try {
            InetAddress remoteIp = InetAddress.getByName(REMOTE_ADDR);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String msg = null;

            while (null != (msg = reader.readLine())) {
                byte[] outputData = msg.getBytes();

                DatagramPacket packet = new DatagramPacket(outputData, outputData.length, remoteIp, PORT);

                socket.send(packet);

                // 接收服务端返回的数据
                DatagramPacket inputPackage = new DatagramPacket(new byte[512], 512);
                socket.receive(inputPackage);
                System.out.println(new String(inputPackage.getData(), 0, inputPackage.getLength()));

                if (BYE.equals(msg)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}