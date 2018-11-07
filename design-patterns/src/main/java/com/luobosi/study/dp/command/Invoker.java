/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.command;

/**
 * Invoker
 * 调用者即请求发送者，它通过命令对象来执行请求。一个调用者并不需要在设计时确定其接收者，
 * 因此它只与抽象命令类之间存在关联关系。在程序运行时可以将一个具体命令对象注入其中，
 * 再调用具体命令对象的 execute() 方法，从而实现间接调用请求接收者的相关操作。
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-07
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 业务方法，用于调用命令类 execute() 方法
     */
    public void call() {
        command.execute();
    }

}
