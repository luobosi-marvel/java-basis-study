/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.juc.synchronizer;

/**
 * TestSync
 *
 * @author luobosi@2dfire.com
 * @since 2018-02-01
 */
public class TestSync implements Runnable{

    int b = 100;

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void m1() throws InterruptedException {
        b = 1000;
        Thread.sleep(500);
        System.out.println("b = " + b);
    }

    synchronized void m2() throws InterruptedException {
        b = 2000;
        Thread.sleep(250);
    }

    public static void main(String[] args) throws InterruptedException {
        TestSync testSync = new TestSync();
        Thread thread = new Thread(testSync);
        thread.start();

        testSync.m2();
        System.out.println("main thread b = " + testSync.b);
    }

}