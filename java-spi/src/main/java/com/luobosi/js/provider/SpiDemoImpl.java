/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.js.provider;

import com.luobosi.js.service.ISpiDemo;

/**
 * SpiDemoImpl
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-12
 */
public class SpiDemoImpl implements ISpiDemo {
    @Override
    public void test() {
        System.out.println("1 spi demo impl");
    }
}