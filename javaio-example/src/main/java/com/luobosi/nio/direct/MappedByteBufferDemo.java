/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.nio.direct;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

/**
 * MappedByteBufferDemo
 * 大文件直接映射（不超过 2G）
 *
 * @author luobosi@2dfire.com
 * @since 2018-02-26
 */
public class MappedByteBufferDemo {

    public static void main(String[] args) {
        File file = new File("D:\\fromFile.txt");
        long length = file.length();
        byte[] bytes = new byte[(int) length];

        try {
            MappedByteBuffer mappedByteBuffer = new RandomAccessFile(file, "r")
                    .getChannel()
                    .map(FileChannel.MapMode.READ_ONLY, 0, length);

            for (int offset = 0; offset < length; offset++) {
                byte b = mappedByteBuffer.get();
                bytes[offset] = b;
            }

            Scanner scan = new Scanner(new ByteArrayInputStream(bytes)).useDelimiter(" ");
            while (scan.hasNext()) {
                System.out.print(scan.next() + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}