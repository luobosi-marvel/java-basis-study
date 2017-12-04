/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.common.constant;

/**
 * Constants
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-04
 */
public class Constants {

    public final static int ZERO = 0;

    /**
     * 一些数字常量
     */
    public interface ConstantNumber {
        int TEN = 10;
    }

    /**
     * 关于工厂模式的一些常量
     */
    public interface ConstantFactory {
        /** 产品A 的类名 */
        String CONCREATE_PRODUCT_A = "ConcreateProductA";
        /** 产品B 的类名 */
        String CONCREATE_PRODUCT_B = "ConcreateProductB";
    }
}