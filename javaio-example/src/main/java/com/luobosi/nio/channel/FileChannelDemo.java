/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.nio.channel;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * FileChannelDemo
 * Java NIO 通道之间的数据传输,FileChannel 是阻塞的，不能设置成非阻塞模型
 *
 * 1. 将数据写入 FileChannel
 *      write()
 * 2. 关闭 FileChannel      完成使用后，FileChannel 必须关闭它
 *      close()
 * 3. FileChannel 位置   对 FileChannel 进行读取或写入时，你会在特定的位置上这样做。通过调用 position() 方法获取对象当前位置
 *      position()
 * 4. FileChannel 大小
 *      size()
 * 5. FileChannel 截断 截断文件时，可以在给定的长度上将其截断
 *      truncate(1024)
 * 6. FileChannel Force 将所有未写入的数据从通道刷新到磁盘中
 *      force()
 *
 * @author luobosi@2dfire.com
 * @since 2018-02-24
 */
public class FileChannelDemo {

    public static void main(String[] args) throws Exception {
        transferFrom();
        transferTo();
    }

    /**
     * 从给定的可读字节将字节传输到此通道的文件中频道。
     *
     * 尝试从头文件读取 count 字节源通道，并将它们写入此通道的文件中
     * 给予<tt>位置</ tt>。此方法的调用可能会也可能不会传输所有请求的字节;不管它是否依赖
     * 关于渠道的性质和状态。比要求的少如果源通道数少于，将传输字节数剩余的字节数，或源通道是否阻塞
     * 并且其中的立即可用的字节少于count字节输入缓冲区。
     *
     * 此方法不会修改此频道的位置。如果给定的位置大于文件的当前大小，则不存在字节转入。
     * 如果源通道有位置，则读取字节从该位置开始，然后该位置增加读取的字节数。
     *
     * 这个方法比简单的循环更有效率从源通道读取并写入此通道。许多操作系统可以直接从源通道传输字节
     * 进入文件系统高速缓存而不实际复制它们。
     *
     * 如果 fromFile 文件中的内容为：aa
     *      toFile 文件中的内容为：marvel
     *      则使用该方法最后的结果为 aarvel
     * @throws Exception
     */
    private static void transferFrom() throws Exception {
        RandomAccessFile fromFile = new RandomAccessFile("D:\\fromFile.txt", "rw");
        FileChannel fromFileChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("D:\\toFile.txt", "rw");
        FileChannel toFileChannel = toFile.getChannel();

        long position = 0L;
        long count = fromFileChannel.size();

        System.out.println(count);
        toFileChannel.transferFrom(fromFileChannel, position, count);
    }

    /**
     * 将此通道文件的字节传输到给定的可写字节频道。
     *
     * 试图从头开始读取<tt> count </ tt>个字节这个频道文件中给定的<tt>位置</ tt>，并将它们写入
     * 目标频道。此方法的调用可能会或可能不会传输所有请求的字节;不管它是否取决于
     * 渠道的性质和状态。少于要求的数量如果此频道的文件包含的字节数少于*，则传输字节
     * 从给定的<tt>位置开始计数</ tt>字节</ tt>，或者目标频道是非阻塞的，并且它少于<tt>计数</ tt>
     * 输出缓冲区中的空闲字节。
     *
     * 此方法不会修改此频道的位置。如果给定的位置大于文件的当前大小，则不存在字节转入。
     * 如果目标通道有位置，则字节为从该位置开始写入，然后位置递增由写入的字节数决定。
     *
     * 这个方法比简单的循环更有效率从该通道读取并写入目标通道。许多操作系统可以直接从文件系统缓存中传输字节
     * 到目标频道而不实际复制它们
     * @throws Exception
     */
    private static void transferTo() throws Exception {
        RandomAccessFile fromFile = new RandomAccessFile("D:\\fromFile.txt", "rw");
        FileChannel fromFileChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("D:\\toFile.txt", "rw");
        FileChannel toFileChannel = toFile.getChannel();

        long position = 0L;
        long count = fromFileChannel.size();

        fromFileChannel.transferTo(position, count, toFileChannel);
    }

}