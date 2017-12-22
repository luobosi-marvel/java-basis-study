/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.factory.factory.method.pattern;

/**
 * Main
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-04
 */
public class Main {
    public static void main(String[] args) {
        // 获取一个具体的工厂类
        Factory factory = new ConcreateProductAFactory();
        // 使用工厂类创建产品
        Product product = factory.createProduct();
        product.print();
    }
}