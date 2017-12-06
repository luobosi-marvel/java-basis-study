/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.proxy.jdkproxy;

/**
 * DataServiceImpl
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-06
 */
public class DataServiceImpl implements DataService {

    @Override
    public void save(String username) {
        System.out.println("我是被代理方法 ---- save :" + username);
    }

    @Override
    public void update(String username) {
        System.out.println("我是被代理方法 ---- update : " + username);
    }
}