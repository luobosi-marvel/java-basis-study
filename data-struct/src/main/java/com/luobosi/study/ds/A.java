/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.ds;

import java.util.Scanner;

/**
 * A
 *
 * @author luobosi@2dfire.com
 * @since 2018-04-08
 */
public class A {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("输入一个串字符串：");
        String str = scanner.nextLine();


        int result = 0;
        boolean negative = false;

        int i = 0;
        int len = str.length();
        if (i < len) {
            char flag = str.charAt(0);
            // 说明是负数
            if (flag == '-') {
                negative = true;
                i = 1;
                len = str.length() - 1;
            }

            while (len > 0) {
                len--;
                int pow = (int) Math.pow(10, len);
                char ch = str.charAt(i++);
                int f;
                if (ch == 49) {
                    f = 1;
                } else if (ch == 50) {
                    f = 2;
                } else if (ch == 51) {
                    f = 3;
                } else if (ch == 52) {
                    f = 4;
                } else if (ch == 53) {
                    f = 5;
                } else if (ch == 54) {
                    f = 6;
                } else if (ch == 55) {
                    f = 7;
                } else if (ch == 56) {
                    f = 8;
                } else if (ch == 57) {
                    f = 9;
                } else {
                    f = 0;
                }
                result += f * pow;

            }
        }

        result = negative ? -result : result;
        System.out.println(result);

    }

}