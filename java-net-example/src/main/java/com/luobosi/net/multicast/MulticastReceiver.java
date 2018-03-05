/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * MulticastReceiver
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-05
 */
public class MulticastReceiver {

    public static void main(String[] args) throws Exception {
        InetAddress group = InetAddress.getByName("224.0.0.1");

        int port = 4000;

        MulticastSocket multicastSocket = null;

        try {
            multicastSocket = new MulticastSocket(port);
            multicastSocket.joinGroup(group);
            byte[] buffer = new byte[8192];

            while (true) {
                // 组播的接收者 DatagramPacket 是不需要绑定地址和端口就可以接收数据
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                // 接收组播数据报
                multicastSocket.receive(packet);

                String s = new String(packet.getData(), 0, packet.getLength());

                System.out.println("接收数据报：" + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != multicastSocket) {
                multicastSocket.leaveGroup(group);
                multicastSocket.close();
            }
        }
    }

}