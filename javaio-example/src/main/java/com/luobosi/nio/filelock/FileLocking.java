/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.nio.filelock;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * FileLocking
 * 1.4 引入了文件加锁机制，它允许我们同步访问某个作为共享资源的文件。不过，
 * 竞争同一文件的两个线程可能在不同的 Java 虚拟机上；或者一个是 Java 线程，
 * 另一个是操作系统中其他的某个本地线程。文件锁对其他的操作系统进程是可见的，
 * 因为 Java 的文件加锁直接映射到了本地操作系统的加锁工具。
 *
 * 注意：SocketChannel、DatagramChannel 和 ServerSocketChannel 不需要加锁，
 * 因为它们是从单进程实体继承而来；我们通常不在两个进程之间共享网络 socket。
 *
 * 也可以使用如下方法对文件的一部分上锁：
 * tryLock(long position, long size, boolean shared)
 * lock(long position, long size, boolean shared)
 *
 * @author luobosi@2dfire.com
 * @since 2018-02-25
 */
public class FileLocking {

    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("file.txt");
        FileLock fileLock = outputStream.getChannel().tryLock();
        if (null != fileLock) {
            System.out.println("Locked File");
            try {
                TimeUnit.MICROSECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                fileLock.release();
                System.out.println("Released Lock");
            }
        }
        outputStream.close();
    }
}