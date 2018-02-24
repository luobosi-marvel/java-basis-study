/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.nio.select;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * SelectorClient
 *
 * @author luobosi@2dfire.com
 * @since 2018-02-24
 */
public class SelectorClient {

    private static final String STR = "Hello World!";
    private static final String REMOTE_IP = "127.0.0.1";
    private static final int THREAD_COUNT = 5;

    private static class NonBlockingSocketThread extends Thread {

        @Override
        public void run() {
            try {
                int port = 1024;
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(Boolean.FALSE);
                socketChannel.connect(new InetSocketAddress(REMOTE_IP, port));
                while (!socketChannel.finishConnect()) {
                    System.out.println("同" + REMOTE_IP + "的连接正在建立，请稍等！ ");
                    Thread.sleep(10);
                }
                System.out.println("连接已经建立，带写入内容至指定IP + 端口！时间为 " + System.currentTimeMillis());
                String writeStr = STR + this.getName();
                ByteBuffer byteBuffer = ByteBuffer.allocate(writeStr.length());
                byteBuffer.put(writeStr.getBytes());
                // 切换模式
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
                byteBuffer.clear();
                socketChannel.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NonBlockingSocketThread[] blockingSocketThreads = new NonBlockingSocketThread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            blockingSocketThreads[i] = new NonBlockingSocketThread();
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            blockingSocketThreads[i].start();
        }
        // 一定要 join 保证线程代码先于 socketChannel.close() 运行，否则会有 AsynchronousCloseException
        for (int i = 0; i < THREAD_COUNT; i++) {
            blockingSocketThreads[i].join();
        }
    }

}