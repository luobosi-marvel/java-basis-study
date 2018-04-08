/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.ds;

/**
 * A
 *
 * @author luobosi@2dfire.com
 * @since 2018-04-08
 */
public class A {

    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        System.gc();
    }

}