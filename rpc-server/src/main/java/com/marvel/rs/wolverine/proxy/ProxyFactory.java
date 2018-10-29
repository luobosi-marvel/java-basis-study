package com.marvel.rs.wolverine.proxy;

import java.lang.reflect.InvocationHandler;

public interface ProxyFactory {

    <T> T getProxy(Object target, InvocationHandler handler) throws Throwable;
}