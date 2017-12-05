/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.reflect;

import com.google.common.io.Resources;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * ReflectByProperties
 * 从配置文件中获取类名，然后通过反射创建
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-05
 */
public class ReflectByProperties {

    public static void main(String[] args) throws Exception {
        // 读取文件中的内容
        Properties properties  = new Properties();
        // 借助 Guava 库的 Resource 类读取 person.properties 文件中的内容
        BufferedInputStream bufferedInputStream = (BufferedInputStream) Resources.getResource("person.properties").getContent();
        properties.load(bufferedInputStream);

        // 注意：这个必须要trim()一下，目的是要将文件读取时的空格给干掉
        String className = properties.getProperty("className").trim();
        String methodName = properties.getProperty("methodName").trim();

        // 利用反射，操作文件中的类
        Class clazz = Class.forName(className);

        Constructor constructor = clazz.getConstructor(null);

        Method method = clazz.getDeclaredMethod(methodName, null);
        method.setAccessible(true);
        method.invoke(constructor.newInstance(null),null);

    }
}