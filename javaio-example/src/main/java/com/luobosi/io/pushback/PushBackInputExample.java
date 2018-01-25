/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.io.pushback;

import java.io.FileInputStream;
import java.io.PushbackInputStream;

/**
 * PushBackInputExample
 *
 * @author luobosi@2dfire.com
 * @since 2018-01-25
 */
public class PushBackInputExample {

    public static void main(String[] args) {
        try {
            PushbackInputStream pushbackInputStream = new PushbackInputStream(new FileInputStream("D:\\marvel\\input.txt"));

            int read = pushbackInputStream.read();
            System.out.println((char) read);

            pushbackInputStream.unread(read);

            System.out.println("===================================");

            while (read != -1) {
                System.out.println((char) read);
                read = pushbackInputStream.read();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}