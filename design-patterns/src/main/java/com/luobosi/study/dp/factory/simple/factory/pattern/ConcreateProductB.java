/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.factory.simple.factory.pattern;

/**
 * ConcreateProductB
 * 具体产品B
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-04
 */
public class ConcreateProductB implements Product{
    @Override
    public void print() {
        System.out.println("ConcreateProductB");
    }
}