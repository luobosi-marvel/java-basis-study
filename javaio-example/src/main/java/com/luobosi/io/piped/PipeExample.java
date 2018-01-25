/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.io.piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * PipeExample
 *
 * @author luobosi@2dfire.com
 * @since 2018-01-25
 */
public class PipeExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 1. 创建一个 管道输出流
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        // 2. 创建一个 管道输入流，并将输出流关联好
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
        // 线程1 用来将 hello marvel 输出去
        new Thread(() -> {
            try {
                pipedOutputStream.write("hello marvel".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 这样的代码好丑陋.......
                try {
                    // 将管道输出流关闭
                    pipedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 线程2 用来接收管道输出流输出的内容
        new Thread(() -> {
            try {
                int read = pipedInputStream.read();
                while (read != -1) {
                    System.out.print((char) read);
                    read = pipedInputStream.read();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    // 将管道输入流关闭
                    pipedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}