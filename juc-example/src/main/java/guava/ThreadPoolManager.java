package guava;/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;

import java.util.concurrent.Callable;

/**
 * ThreadPoolManager
 *
 * @author luobosi@2dfire.com
 * @since 2018-05-02
 */
public enum ThreadPoolManager {
    /**
     * 实例
     */
    INSTANCE;

    /**
     * 线程池维护线程的最少数量
     */
    private int SIZE_CORE_POOL = 60;

    /**
     * 线程池维护线程的最大数量
     */
    private int SIZE_MAX_POOL = 200;

    /**
     * 线程池维护线程所允许的空闲时间
     */
    private int TIME_KEEP_ALIVE = 180;

    /**
     * 线程池所使用的缓冲队列大小
     */
    private int SIZE_WORK_QUEUE = 400;

    ListeningExecutorService executorService;

    ListeningExecutorService activityExecutorService;

    ListeningExecutorService coreExecutorService;

    ThreadPoolManager() {

    }

    /**
     * 向线程池中添加任务方法
     */
    public <T> ListenableFuture<T> addCoreExecuteTask(Callable<T> task) {
        return coreExecutorService.submit(task);
    }

    /**
     * 向线程池中添加任务方法
     */
    public <T> ListenableFuture<T> addExecuteTask(Callable<T> task) {
        return executorService.submit(task);
    }

    /**
     * 向线程池中添加任务方法
     */
    public <T> ListenableFuture<T> addActivityExecuteTask(Callable<T> task) {
        return activityExecutorService.submit(task);
    }
}
