/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.io.reader;

import java.io.IOException;
import java.io.StringReader;

/**
 * StringReaderExample
 *
 * @author luobosi@2dfire.com
 * @since 2018-01-27
 */
public class StringReaderExample {

    private static final String MARVEL = "this is my love! 这是我的爱";

    public static void main(String[] args) {
        testStringReader();
    }

    public static void testStringReader() {
        StringReader stringReader = new StringReader(MARVEL);

        try {
            int read = stringReader.read();

            while (read != -1) {
                System.out.println((char) read + ", ");
                read = stringReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stringReader.close();
        }

    }

}