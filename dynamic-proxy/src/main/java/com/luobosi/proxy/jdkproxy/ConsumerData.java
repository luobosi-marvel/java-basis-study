/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.proxy.jdkproxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * ConsumerData
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-06
 */
public class ConsumerData {

    /**
     * 使用代理类
     *
     * @param args 系统参数
     */
    public static void main(String[] args) {
        DataService dataService = (DataService) Proxy.newProxyInstance(ConsumerData.class.getClassLoader(),
                new Class<?>[]{DataService.class},
                new DataInvocationHandler(new DataServiceImpl()));
        dataService.save("marvel");
        dataService.update("i love you!");
    }

    /**
     * 将产生的 class 文件写到本地，我们可以通过反编译工具查看 $Proxy0.class 文件，即可看出代理的猫腻
     */
    public void createProxyClass() {
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", new Class<?>[]{DataService.class});
        try {
            FileOutputStream outputStream = new FileOutputStream("$Proxy0.class");
            outputStream.write(classFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}