/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.juc.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLockMain
 *
 * @author luobosi@2dfire.com
 * @since 2019-01-12
 */
public class ReentrantReadWriteLockMain {

    static final int SHARED_SHIFT   = 16;
    static final int SHARED_UNIT    = (1 << SHARED_SHIFT);
    static final int MAX_COUNT      = (1 << SHARED_SHIFT) - 1;
    static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;


    public static void main(String[] args) {
        System.out.println("SHARED_UNIT --> " + SHARED_UNIT + "==" + Integer.toBinaryString(SHARED_UNIT));
        System.out.println("MAX_COUNT --> " + MAX_COUNT + "==" + Integer.toBinaryString(MAX_COUNT));

        System.out.println("sharedCount --> " + (1 >>> SHARED_SHIFT));

        System.out.println("exclusiveCount --> " + (1 & EXCLUSIVE_MASK));

        System.out.println("1 +  SHARED_UNIT --> " + (1 + SHARED_UNIT));

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(false);
        reentrantReadWriteLock.readLock().lock();

    }
}
