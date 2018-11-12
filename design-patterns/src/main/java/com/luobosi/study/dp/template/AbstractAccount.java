/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.template;

/**
 * AbstractAccount
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-12
 */
public abstract class AbstractAccount {

    // 基本方法，抽象方法
    public abstract void calculateInterest();

    private boolean validate(String account, String password) {
        System.out.println("账号：" + account);
        System.out.println("密码：" + password);
        return "张无忌".equals(account) && "123456".equals(password);
    }


    // 基本方法
    private void display() {
        System.out.println("显示利息");
    }

    /**
     * 模版方法
     *
     * @param account  账号
     * @param password 密码
     */
    public void handle(String account, String password) {
        if (!validate(account, password)) {
            System.out.println("账号密码错误");
            return;
        }
        calculateInterest();
        display();
    }
}
