/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * BufferProgram
 *
 * @author luobosi@2dfire.com
 * @since 2018-02-01
 */
public class BufferProgram {

    public static void main(String[] args) {
        try {
            FileInputStream stream = new FileInputStream("d:\\fromFile.txt");

            FileChannel channel = stream.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(10);

            output("初始化", buffer);

            channel.read(buffer);

            output("调用 read()", buffer);

            buffer.flip();

            output("调用 flip()", buffer);

            buffer.clear();

            output("调用 clear()", buffer);

            channel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void output(String step, ByteBuffer buffer) {

        System.out.println(step + ":");

        System.out.println("capacity: " + buffer.capacity() + ",");

        System.out.println("position: " + buffer.position() + ",");

        System.out.println("limit: " + buffer.limit());

        System.out.println();
    }


}