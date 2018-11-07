/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.command;

/**
 * Client
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-07
 */
public class Client {

    public static void main(String[] args) {

        // 一个命令就相当于一根电线，控制一个行为
        ConcreteCommand concreateCommand = new ConcreteCommand();
        concreateCommand.setReceiver(new Receiver());

        // 这里相当于一个共同的开关
        Invoker invoker = new Invoker(concreateCommand);

        invoker.call();
    }
}
