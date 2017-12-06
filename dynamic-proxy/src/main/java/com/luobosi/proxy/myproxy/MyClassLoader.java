/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.proxy.myproxy;

/**
 * MyClassLoader
 * 自定义类加载器
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-06
 */
public class MyClassLoader extends ClassLoader{

    /** 用来存放目录 */
    private String dir;

    public MyClassLoader(String dir) {
        this.dir = dir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return null;
    }
}