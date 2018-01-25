/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicIntegerDemo
 *
 * @author luobosi@2dfire.com
 * @since 2018-01-08
 */
public class AtomicIntegerDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.addAndGet(10));

        Thread thread = new Thread(()-> System.out.println("牛逼"));
        thread.start();
        thread.start();
        thread.start();
    }

}