/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.singleton;

import com.luobosi.common.constant.Constants;

/**
 * EnumSingleton
 * 单例模式之枚举类型
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-04
 */
public class EnumSingleton {

    private EnumSingleton() {

    }

    public static void main(String[] args) {
        int i = Constants.ZERO;
        while (i < Constants.ConstantNumber.TEN) {
            new Thread(()-> System.out.println(EnumSingletons.INSTANCE)).start();
            i++;
        }
    }
}

/**
 * 单例枚举
 */
enum EnumSingletons {
    INSTANCE;

    EnumSingletons() {
        System.out.println("我执行了");
    }
}

