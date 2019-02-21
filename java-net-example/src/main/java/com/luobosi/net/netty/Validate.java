/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.netty;

/**
 * Validate
 *
 * @author luobosi@2dfire.com
 * @since 2019-02-20
 */
public class Validate {

    public static void isTrue(boolean expression) {

    }

    public static void isTrue(boolean expression, String message) {

    }

    public static void isTrue(boolean expression, String message, long value) {

    }

    public static void isTrue(boolean expression, Class clazz) {

        if (!expression) {
            throw new MiniProgramException("错误", "不正确");
        }

    }

    public static void main(String[] args) {
        boolean flag = false;

        isTrue(flag, MiniProgramException.class);
    }


}
