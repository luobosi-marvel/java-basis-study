/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.command;

/**
 * ConcreteCommand
 * 具体命令类是抽象命令类的子类，实现了在抽象命令类中声明的方法，它对应具体的接收者对象，
 * 将接收者对象的动作绑定其中。在实现 execute() 方法时，将调用接收者对象的相关操作。
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-07
 */
public class ConcreteCommand implements Command {

    private Receiver receiver;

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.action();
    }
}
