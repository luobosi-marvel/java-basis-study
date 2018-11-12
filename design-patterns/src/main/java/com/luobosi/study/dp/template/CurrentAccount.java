/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.template;

/**
 * CurrentAccount
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-12
 */
public class CurrentAccount extends AbstractAccount {

    @Override
    public void calculateInterest() {
        System.out.println("按活期利率计算利息");
    }
}
