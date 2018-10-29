/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rc;

import com.luobosi.common.request.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * RemoteInvocationHandler
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
public class RemoteInvocationHandler implements InvocationHandler {

    private String host;

    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        RpcRequest request = new RpcRequest();
        // 类的全限定名称
        request.setClassName("com.luobosi.common.facade.IUserFacade.java");
        request.setMethodName(method.getName());
        request.setParameters(args);

        RpcNetTransport transport = new RpcNetTransport(host, port);
        return transport.sendRequest(request);
    }
}
