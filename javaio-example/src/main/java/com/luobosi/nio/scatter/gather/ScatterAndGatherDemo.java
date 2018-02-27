/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.nio.scatter.gather;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ScatterAndGatherDemo
 * 分散：一对多，一个 channel 将数据分散到多个 buffer 里面
 * 聚集：多对一，多个 buffer 将数据写到一个 channel 里面
 *
 * @author luobosi@2dfire.com
 * @since 2018-02-27
 */
public class ScatterAndGatherDemo {

    /**
     * 该操作就是分散操作
     *
     * @throws IOException
     */
    public void scatter() throws IOException {
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);

        FileInputStream fileInputStream = new FileInputStream("D:\\fromFile.text");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer[] buffers = {header, body};
        channel.read(buffers);
    }

    /**
     * 该操作就是聚集操作，将 buffer 里面的数据写到 channel 里面
     * @throws IOException
     */
    public void gcather() throws IOException {
        ByteBuffer header = ByteBuffer.wrap("hello".getBytes());
        ByteBuffer body = ByteBuffer.wrap("l love you".getBytes());

        FileInputStream fileInputStream = new FileInputStream("D:\\fromFile.text");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer[] buffers = {header, body};
        channel.write(buffers);
    }
}