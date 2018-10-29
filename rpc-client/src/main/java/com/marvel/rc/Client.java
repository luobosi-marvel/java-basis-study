/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rc;

import com.luobosi.common.facade.IHelloFacade;

/**
 * Client
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
public class Client {

    public static void main(String[] args) {

        RpcClientProxy clientProxy = new RpcClientProxy();
        IHelloFacade helloFacade = clientProxy.clientProxy(IHelloFacade.class, "localhost", 8080);
        System.out.println(helloFacade.sayHello("hello marvel"));

    }
}
