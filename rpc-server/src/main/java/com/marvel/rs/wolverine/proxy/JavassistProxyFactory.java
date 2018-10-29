package com.marvel.rs.wolverine.proxy;


import java.lang.reflect.InvocationHandler;

public class JavassistProxyFactory implements ProxyFactory {

    @Override
    public <T> T getProxy(Object target, InvocationHandler handler) throws Throwable {
        return (T) ProxyGenerator.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass(), handler);
    }
}
