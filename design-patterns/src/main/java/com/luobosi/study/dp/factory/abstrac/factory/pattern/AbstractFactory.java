/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.factory.abstrac.factory.pattern;

/**
 * AbstractFactory
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-22
 */
public interface AbstractFactory {

    /**
     * 创建 Button 的方法
     *
     * @return Button
     */
    Button createButton();

    /**
     * 创建 CheckedBox 方法
     *
     * @return CheckedBox
     */
    CheckedBox createCheckedBox();

    /**
     * 创建 TextField 方法
     *
     * @return CheckedField
     */
    TextField createTextField();

}