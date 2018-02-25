/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.nio.epoll.bug;

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
 * PlainNioEchoServer
 * 压碎著名的 epoll bug
 * todo：Netty 是如何优雅解决这个问题的?
 *
 * @author luobosi@2dfire.com
 * @since 2018-02-25
 */
public class PlainNioEchoServer {

    public static void main(String[] args) throws IOException {
        server(8118);
    }

    private static void server(int port) throws IOException {
        System.out.println("Listening for connection on port " + port);
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        ServerSocket socket = serverChannel.socket();
        socket.bind(new InetSocketAddress(port));
        // 设置 channel 是否为阻塞模式
        serverChannel.configureBlocking(Boolean.FALSE);
        Selector selector = Selector.open();
        while (Boolean.TRUE) {
            try {
                // 这里发生的是，不管有没有已选择的 SelectionKey， Selector.select() 方法总是不会阻塞并且立刻返回。
                // 着违反了 Javadoc 中对 Selector.select() must not unblock if nothing is selected.
                // (Selector.select()方法若未选中任何事件将会阻塞。)
                System.out.println(".............");
                // 该方法会被阻塞，知道有准备好的 channel 到来
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            // 该值将永远是假的，代码将持续消耗你的 CPU 资源。
            // 这会有一些副作用，因为 CPU 消耗完了就无法再去做其他任何的工作
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                try {
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        System.out.println("Accepted connection from " + client);
                        client.configureBlocking(Boolean.FALSE);
                        // 用给定的选择器注册此通道，返回 selection key。
                        // 事件：SelectionKey.OP_WRITE ——》写就绪事件，表示已经可以向通道写数据了（通道目前可以用于写操作）
                        // SelectionKey.OP_READ ——》读就绪事件，表示通道中已经有了可读的数据，可以执行读操作了（通道目前有数据，可以进行读操作了）
                        client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, ByteBuffer.allocate(100));
                    }
                    if (key.isReadable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        client.read(output);
                    }
                    if (key.isWritable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        output.flip();
                        client.write(output);
                        // 清空 ByteBuffer，注意该方法和 clear() 方法的区别
                        output.compact();
                    }
                } catch (IOException e) {
                    key.cancel();
                    key.channel().close();
                }
            }
        }
    }
}