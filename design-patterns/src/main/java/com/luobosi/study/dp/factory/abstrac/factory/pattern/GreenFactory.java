/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.factory.abstrac.factory.pattern;

/**
 * GreenFactory
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-22
 */
public class GreenFactory implements AbstractFactory {

    @Override
    public Button createButton() {
        return new GreenButton();
    }

    @Override
    public CheckedBox createCheckedBox() {
        return new GreenCheckedBox();
    }

    @Override
    public TextField createTextField() {
        return new GreenTextField();
    }
}