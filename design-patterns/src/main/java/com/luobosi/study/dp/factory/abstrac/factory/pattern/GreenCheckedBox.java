/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.factory.abstrac.factory.pattern;

/**
 * GreenCheckedBox
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-22
 */
public class GreenCheckedBox implements CheckedBox{

    @Override
    public void checkedBox() {
        System.out.println("我是绿色的复选框！");
    }
}