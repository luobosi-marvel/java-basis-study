/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.io.reader;

import java.io.CharArrayReader;
import java.io.IOException;

/**
 * CharArrayReaderExample
 *
 * @author luobosi@2dfire.com
 * @since 2018-01-27
 */
public class CharArrayReaderExample {

    private static final int LEN = 5;

    private static final char[] ARRAY_LETTERS = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static void main(String[] args) {
        testCharArrayReader();
    }

    private static void testCharArrayReader() {
        CharArrayReader charArrayReader = new CharArrayReader(ARRAY_LETTERS);
        try {
            int read = charArrayReader.read();
            while (read != -1) {
                System.out.print((char) read + ", ");

                read = charArrayReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            charArrayReader.close();
        }
    }
}