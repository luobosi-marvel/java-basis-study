/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.singleton;

import com.luobosi.common.constant.Constants;

/**
 * EagerSingletion
 * 饿汉式单例
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-04
 */
public class EagerSingletion {

    /**
     * 1. 私有变量
     * 在类加载的时候就已经创建，可以确保单例对象的唯一性。无须考虑多线程环境
     * 不足：无论系统运行时是否需要该对象，该对象都会被创建，提前占用内存
     *
     */
    private static EagerSingletion eagerSingletion = new EagerSingletion();

    /**
     * 2. 私有的构造方法
     */
    private EagerSingletion() {}

    /**
     * 获取单例对象
     *
     * @return 返回单例对象
     */
    public static EagerSingletion getEagerSingletion() {
        return eagerSingletion;
    }

    public static void main(String[] args) {
        int i = 0;
        while (i < Constants.ConstantNumber.TEN) {
            System.out.println(EagerSingletion.getEagerSingletion());
            i++;
        }
    }
}