/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * DataInvocationHandler
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-06
 */
public class DataInvocationHandler implements InvocationHandler{

    private DataService dataService;

    public DataInvocationHandler(DataService dataService) {
        this.dataService = dataService;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(dataService, args);
        after();
        return null;
    }

    /**
     * 该方法是在目标方法调用前触发
     */
    private void before () {
        System.out.println("我是代理方法，在被代理方法之前调用----before");
    }

    /**
     * 该方法是在目标方法之后调用
     */
    private void after () {
        System.out.println("我是代理方法，在被代理方法之后调用----after");
    }
}