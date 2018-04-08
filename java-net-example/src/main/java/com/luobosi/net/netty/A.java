/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.netty;

/**
 * a
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-10
 */
public abstract class A {

    protected String name;

    public A() {
        this.name = "marvel";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sout() {
        System.out.println(this.name);
    }
}