/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.singleton;

import com.luobosi.common.constant.Constants;

/**
 * OrdinarySingleton
 * 普通单例模式
 * 1. 私有变量
 * 2. 构造方法单例
 * 3. 静态的 get 方法
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-04
 */
public class OrdinarySingleton {
    /**
     * 1. 私有变量
     */
    private static OrdinarySingleton ordinarySingleton;

    /**
     * 2. 私有的构造方法
     */
    private OrdinarySingleton() {}

    /**
     * 获取单例对象
     *
     * @return 返回单例对象
     */
    public static OrdinarySingleton getInstance() {
        if (ordinarySingleton == null) {
            ordinarySingleton = new OrdinarySingleton();
        }
        return ordinarySingleton;
    }

    public static void main(String[] args) {
        int i = 0;
        while (i < Constants.ConstantNumber.TEN) {
            System.out.println(OrdinarySingleton.getInstance());
            i++;
        }
    }
}