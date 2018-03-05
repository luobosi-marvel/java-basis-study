/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * MulticastSender
 * MulticastSender 不断发送组播数据报，如果在本地子网上没有配置 mrouter ，那么运行的 MulticastReceiver 会在调用
 * MulticastSocket 的 joinGroup() 方法时抛出以下异常。
 *
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-05
 */
public class MulticastSender {

    public static void main(String[] args) throws Exception {
        // 1. 声明一个组
        InetAddress group = InetAddress.getByName("224.0.0.1");

        int port = 4000;

        MulticastSocket multicastSocket = null;

        try {
            // 2. 实例化 MulticastSocket，并绑定指定端口，这是基础对象
            multicastSocket = new MulticastSocket(port);
            // 不断发送组播数据报
            for (; ; ) {
                // 3. 准备要发送的数据
                String message = "Hello" + new java.util.Date();
                byte[] buffer = message.getBytes();
                // 4. 将数据封装到 DatagramPacket 里面
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
                // 5. 发送到组播组
                multicastSocket.send(packet);

                System.out.println("发送数据报给：" + group + ":" + port);

                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (null != multicastSocket) {
                // 6. 离开组
                multicastSocket.leaveGroup(group);
                // 7. 关闭 multicastSocket
                multicastSocket.close();
            }
        }
    }

}