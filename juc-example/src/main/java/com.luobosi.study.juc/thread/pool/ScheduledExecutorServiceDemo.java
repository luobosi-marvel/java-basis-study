/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.juc.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorServiceDemo
 *
 * @author luobosi@2dfire.com
 * @since 2019-02-16
 */
public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);

        ScheduledFuture<?> future = scheduledThreadPool.schedule(() -> System.out.println("Now it is 60 seconds later"), 60, TimeUnit.SECONDS);

        scheduledThreadPool.shutdown();
    }
}
