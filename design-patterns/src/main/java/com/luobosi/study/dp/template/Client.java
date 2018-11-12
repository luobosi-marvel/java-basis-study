/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.template;

/**
 * Client
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-12
 */
public class Client {

    public static void main(String[] args) {
        AbstractAccount abstractAccount = new CurrentAccount();
        abstractAccount.handle("张无忌", "123456");
    }
}
