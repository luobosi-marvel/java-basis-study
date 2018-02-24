/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.nio.select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * SelectorServer
 *
 * @author luobosi@2dfire.com
 * @since 2018-02-24
 */
public class SelectorServer {
    /**
     * 端口号
     */
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        // 确定端口号
        int port = PORT;

        if (args != null && args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        // 打开一个 ServerSocketChannel
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        // 获取 ServerSocketChannel 绑定的 Socket
        ServerSocket socket = socketChannel.socket();
        // 设置 ServerSocket 监听的端口
        socket.bind(new InetSocketAddress(port));
        // 设置 ServerSocketChannel 为非阻塞模式
        socketChannel.configureBlocking(Boolean.FALSE);
        // 打开一个选择器
        Selector selector = Selector.open();
        // 将 ServerSocketChannel 注册到选择器上去并监听 accept 事件
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            // 这里会发生阻塞，等待就绪的通道
            int n = selector.select();
            if (n == 0) {
                // 没有就绪通道就什么都不做
                continue;
            }
            // 获取 SelectionKeys 上已经就绪的通道的集合
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            // 遍历每一个 Key
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 通道上是否有可接受的连接
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel accept = channel.accept();
                    accept.configureBlocking(Boolean.FALSE);
                    channel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    readDataFromSocket(selectionKey);
                }
                iterator.remove();
            }
        }
    }

    private static ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    /**
     * 从通道中获取数据
     *
     * @param selectionKey
     */
    private static void readDataFromSocket(SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();

        byteBuffer.clear();

        while (channel.read(byteBuffer) > 0) {
            // 切换成读模式
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            System.out.println();
            byteBuffer.clear();
        }
    }

}