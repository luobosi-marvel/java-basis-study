/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.ds;

/**
 * SupperClass
 *
 * @author luobosi@2dfire.com
 * @since 2018-04-07
 */
public class SupperClass {

    static {
        if (true) {
            System.out.println("SuperClass init!");
            while (true) {
            }
        }
    }
    public static final int value = 0;


}