/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.factory.simple.factory.pattern;

/**
 * ConcreateProductA
 * 具体产品A
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-04
 */
public class ConcreateProductA implements Product{

    @Override
    public void print() {
        System.out.println("ConcreateProductA");
    }
}