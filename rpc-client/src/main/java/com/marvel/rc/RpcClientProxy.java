/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rc;

import java.lang.reflect.Proxy;

/**
 * RpcClientProxy
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
public class RpcClientProxy {


    public <T> T clientProxy(Class<T> interfaceCla, String host, int port) {
        return (T) Proxy.newProxyInstance(interfaceCla.getClassLoader(),
                new Class<?>[]{interfaceCla},
                new RemoteInvocationHandler(host, port));
    }
}
