/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-26
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("a");
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                reentrantLock.unlock();
            }
        }).start();

        for (int i = 0; i< 5; i++) {
            new Thread(() -> {
                reentrantLock.lock();
                try {
                    System.out.println("a");
                }finally {
                    reentrantLock.unlock();
                }
            }).start();
        }
    }

}