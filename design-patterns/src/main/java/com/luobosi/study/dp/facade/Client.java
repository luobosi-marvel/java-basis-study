/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.dp.facade;

/**
 * Client
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-16
 */
public class Client {
    public static void main(String[] args) {

        Facade facade = new Facade();

        SubSystemA systemA = new SubSystemA();
        SubSystemB systemB = new SubSystemB();
        SubSystemC systemC = new SubSystemC();

        facade.setSubSystemA(systemA);
        facade.setSubSystemB(systemB);
        facade.setSubSystemC(systemC);

        facade.printSubSystemA();
        facade.printSubSystemB();
        facade.printSubSystemC();
    }
}