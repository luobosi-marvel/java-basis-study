/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package guava;

import java.util.concurrent.Callable;

/**
 * AsynTask
 *
 * @author luobosi@2dfire.com
 * @since 2018-05-02
 */
public class AsynTask implements Callable<ReturnEntity> {
    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 要执行的任务
     */
    private Execute execute;

    private AsynTask(String taskName) {
        this.taskName = taskName;
    }

    public static AsynTask newTask(String taskName) {
        return new AsynTask(taskName);
    }

    public AsynTask registExecute(Execute execute) {
        this.execute = execute;
        return this;
    }

    @Override
    public ReturnEntity call() throws Exception {
        return null;
    }

    public interface Execute {
        /**
         * 执行的方法
         *
         * @return 对象
         * @throws Exception 业务异常
         */
        Object execute() throws Exception;
    }

}