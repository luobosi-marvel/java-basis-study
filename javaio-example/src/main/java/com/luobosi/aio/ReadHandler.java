/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * ReadHandler
 *
 * @author luobosi@2dfire.com
 * @since 2018-02-25
 */
public class ReadHandler implements CompletionHandler<Integer, ByteBuffer>{

    /**
     * 用于读取半包消息和发送应答
     */
    private AsynchronousSocketChannel channel;

    public ReadHandler(AsynchronousSocketChannel channel) {
        this.channel = channel;
    }

    /**
     * 读取到消息后的处理
     *
     * @param result
     * @param byteBuffer
     */
    @Override
    public void completed(Integer result, ByteBuffer byteBuffer) {
        // 模式切换
        byteBuffer.flip();
        // 根据
        byte[] message = new byte[byteBuffer.remaining()];
        byteBuffer.get(message);

    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.channel.close();
        } catch (IOException e) {


        }
    }
}