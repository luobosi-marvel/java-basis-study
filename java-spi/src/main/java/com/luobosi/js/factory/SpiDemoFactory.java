/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.js.factory;

import com.luobosi.js.service.ISpiDemo;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * SpiDemoFactory
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-12
 */
public class SpiDemoFactory {

    public static Iterator<ISpiDemo> getSpiDemo(){
        ServiceLoader<ISpiDemo> spiDemos = ServiceLoader.load(ISpiDemo.class);
        return spiDemos.iterator();
    }
}