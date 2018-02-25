/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.nio.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * NioPipe
 * Java NIO 管道是两个线程之间的单向数据连接。Pipe 有一个 source 通道和一个 sink 通道。数据会被写到 sink 通道，从
 * source 通道读取。
 *                      |—————————— Pipe ———————————|
 * |——————|       |                                                |        |——————|
 * |  Thread A  | ——> |  |————————|       |————————|   | ——>  |  Thread B  |
 * |——————|       |  |  Sink Channel  | ——> | Source Channel |   |        |——————|
 *                      |  |————————|       |————————|   |
 *                      |————————————————————————|
 *
 * 注意：Pipe 里面的数据都是一次性读取的，所以 ByteBuffer 的大小分配一定好合适，不能比实际数据小，否则会报
 * java.nio.BufferOverflowException 这个错误
 *
 * @author luobosi@2dfire.com
 * @since 2018-02-25
 */
public class NioPipeDemo {

    public static void main(String[] args) throws IOException {

        Pipe pipe = Pipe.open();
        // 一个线程往 sink 里面写入数据
        new Thread(()->{
            // 获取一个 sink
            Pipe.SinkChannel sink = pipe.sink();
            // 数据信息
            String newData = "New String to write to file ..." + System.currentTimeMillis();
            // 获取一个 ByteBuffer
            ByteBuffer buffer = ByteBuffer.allocate(48);
            buffer.clear();
            buffer.put(newData.getBytes());
            buffer.flip();

            while (buffer.hasRemaining()) {
                try {
                    sink.write(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 一个线程从 source 里面读出数据
        new Thread(()->{
            // 获取一个 source
            Pipe.SourceChannel source = pipe.source();
            // 获取一个 ByteBuffer
            ByteBuffer buffer = ByteBuffer.allocate(48);
            try {
                source.read(buffer);
                String strings = new String(buffer.array());
                System.out.println(strings);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}