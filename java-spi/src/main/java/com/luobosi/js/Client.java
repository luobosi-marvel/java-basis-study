/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.js;

import com.luobosi.js.factory.SpiDemoFactory;
import com.luobosi.js.service.ISpiDemo;

import java.util.Iterator;

/**
 * Client
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-12
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("start");
        Iterator<ISpiDemo> spiDemos = SpiDemoFactory.getSpiDemo();
        while(spiDemos.hasNext()){
            ISpiDemo spiDemo = spiDemos.next();
            spiDemo.test();
        }
        System.out.println("end");

    }
}