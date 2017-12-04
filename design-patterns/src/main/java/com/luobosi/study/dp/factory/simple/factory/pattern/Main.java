/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.factory.simple.factory.pattern;

/**
 * Main
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-04
 */
public class Main {

    public static void main(String[] args) {
        Product product = Factory.createProduct("ConcreateProductA");
        product.print();
    }
}