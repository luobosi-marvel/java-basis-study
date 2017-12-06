/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.proxy.myproxy;

/**
 * BookServiceImpl
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-06
 */
public class BookServiceImpl implements BookService {

    @Override
    public void insert(String bookName) {
        System.out.println("我是被代理的类，我被调用了 insert 方法, 我书名是：" + bookName);
    }

    @Override
    public void update(String bookName) {
        System.out.println("我是被代理的类，我被调用了 update 方法, 我书名是：" + bookName);
    }

    @Override
    public String findBook(String bookName) {
        return "marvel";
    }
}