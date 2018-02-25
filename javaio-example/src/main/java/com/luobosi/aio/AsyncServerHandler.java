/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * AsyncServerHandler
 *
 * @author luobosi@2dfire.com
 * @since 2018-02-25
 */
public class AsyncServerHandler implements Runnable{

    private CountDownLatch latch;

    private AsynchronousServerSocketChannel channel;

    public AsyncServerHandler(int port) {
        try {
            // 创建服务端通道
            channel = AsynchronousServerSocketChannel.open();
            // 绑定端口
            channel.bind(new InetSocketAddress(port));
            System.out.println("服务端已启动，端口号：" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // CountDownLatch 初始化
        // 它的作用：在完成一组正在执行的操作之前，允许当前的线程一直阻塞
        latch = new CountDownLatch(1);
        // 用于接收客户端的连接
        channel.accept(this, new AcceptHandler());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public AsynchronousServerSocketChannel getChannel() {
        return channel;
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}