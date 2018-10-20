/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs;

import com.luobosi.common.facade.IHelloFacade;

/**
 * Server（服务端启动）
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
public class Server {


    public static void main(String[] args) {
        IHelloFacade helloService = new HelloServiceImpl();
        RpcServerProxy serverProxy = new RpcServerProxy();
        serverProxy.publisher(helloService, 8080);
    }
}
