/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.singleton;

import com.luobosi.common.constant.Constants;

/**
 * LazySingleton
 * 懒汉式单例
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-04
 */
public class LazySingleton {
    /** volatile 可以保持可见性 */
    private static volatile LazySingleton lazySingleton = null;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        // 第一重判断
        if (lazySingleton == null) {
            // 锁定代码块
            synchronized (LazySingleton.class) {
                // 第二重判断
                if (lazySingleton == null) {
                    // 创建单例实例
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    public static void main(String[] args) {
        int i = Constants.ZERO;
        while (i < Constants.ConstantNumber.TEN) {
            new Thread(()-> System.out.println(LazySingleton.getInstance())).start();
            i++;
        }
    }
}