/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.factory.abstrac.factory.pattern;

/**
 * GreenTextField
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-22
 */
public class GreenTextField implements TextField {

    @Override
    public void textField() {
        System.out.println("我是绿色的文本域！");
    }
}