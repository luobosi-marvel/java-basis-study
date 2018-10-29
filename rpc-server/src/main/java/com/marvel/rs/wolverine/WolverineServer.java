/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine;


import com.marvel.rs.wolverine.proxy.RpcServerProxy;

/**
 * WolverineServer
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
public class WolverineServer {

    public static void main(String[] args) {
        RpcServerProxy serverProxy = new RpcServerProxy();
        serverProxy.publisher(8080);
    }
}
