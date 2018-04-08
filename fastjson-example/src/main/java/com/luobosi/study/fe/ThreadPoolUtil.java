/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.fe;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolUtil
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-16
 */
public class ThreadPoolUtil {
    public static void makeThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workqueue) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workqueue);
        ThreadTast threadTast = new ThreadTast();
        for (int i = 0; i < corePoolSize; i++) {
            executor.execute(threadTast);
        }

        executor.shutdown();
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(5);
        ThreadPoolUtil.makeThreadPool(2, 2, 100, TimeUnit.SECONDS, queue);
    }
}

class ThreadTast implements Runnable {
    private int count = 0;
    private volatile Integer i = new Integer(count);

    @Override
    public void run() {
        getNum();
    }

    public  void getNum() {
        while (true) {
            synchronized (i) {
                if (count < 100)
//                    System.out.println(Thread.currentThread().getName() + "---------->count=" + count);
                    System.out.println(Thread.currentThread().getName() + "---------->i=" + i);
                else
                    break;
                count++;
            }
        }
    }
}