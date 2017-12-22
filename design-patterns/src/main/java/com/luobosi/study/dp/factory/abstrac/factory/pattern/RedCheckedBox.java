/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.factory.abstrac.factory.pattern;

/**
 * RedCheckedBox
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-22
 */
public class RedCheckedBox implements CheckedBox {

    @Override
    public void checkedBox() {
        System.out.println("我是红色的复选框！");
    }
}