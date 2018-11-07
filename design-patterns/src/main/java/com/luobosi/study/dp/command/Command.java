/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.command;

/**
 * Command 抽象命令接口
 * 抽象命令类一般是一个抽象类或接口，在其中声明了用于执行请求的 execute() 等方法，
 * 通过这些方法可以调用请求接收者的相关操作。
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-07
 */
public interface Command {

    /**
     * 命令执行方法
     */
    void execute();
}
