/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.singleton;

import com.luobosi.common.constant.Constants;

/**
 * InitializationOnDemandHolderSingleton
 * IoDH 模式的单例（静态内部类）
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-04
 */
public class InitializationOnDemandHolderSingleton {

    private InitializationOnDemandHolderSingleton() {

    }

    /**
     * 静态内部类，用来初始化 instance 对象，由于静态内部类只会加载一次，而且是在类加载的时候加载，
     * instance 只会被加载一次
     */
    public static class HolderClass {
        public final static InitializationOnDemandHolderSingleton instants = new InitializationOnDemandHolderSingleton();
    }

    public static void main(String[] args) {
        int i = Constants.ZERO;
        while (i < Constants.ConstantNumber.TEN) {
            new Thread(()-> System.out.println(HolderClass.instants)).start();
            i++;
        }
    }


}