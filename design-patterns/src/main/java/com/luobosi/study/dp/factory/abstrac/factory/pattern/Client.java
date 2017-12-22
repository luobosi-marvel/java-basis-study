/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.factory.abstrac.factory.pattern;


/**
 * Client
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-22
 */
public class Client {

    public static void main(String[] args) {

        // 红色工厂
        AbstractFactory redFactory = new RedFactory();
        // 绿色工厂
        AbstractFactory greenFactory = new GreenFactory();

        Button redButton = redFactory.createButton();
        redButton.button();
        Button greenButton = greenFactory.createButton();
        greenButton.button();

        CheckedBox redCheckedBox = redFactory.createCheckedBox();
        redCheckedBox.checkedBox();
        CheckedBox greenCheckedBox = greenFactory.createCheckedBox();
        greenCheckedBox.checkedBox();

        TextField redTextField = redFactory.createTextField();
        redTextField.textField();
        TextField greenTextField = greenFactory.createTextField();
        greenTextField.textField();

    }

}