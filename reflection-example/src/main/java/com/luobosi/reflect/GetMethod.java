/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.reflect;

import com.luobosi.reflect.model.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * GetMethod
 * 通过反射获取方法的调用
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-05
 */
public class GetMethod {

    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("com.luobosi.reflect.model.Person");
        Constructor<?> constructor = clazz.getConstructor(null);
        // 创建一个对象
        Person person = (Person) constructor.newInstance(null);
        // 获取 eat 方法
        Method eatMethod = clazz.getDeclaredMethod("eat", null);
        // 设置私有属性可以访问
        eatMethod.setAccessible(true);
        // 调用 eat 方法
        eatMethod.invoke(person, null);
        // 获取 showInfo 方法
        Method showInfoMethod = clazz.getDeclaredMethod("showInfo", String.class, Integer.class);
        // 调用 showInfo 方法
        showInfoMethod.invoke(person, "marvel", 21);
    }

}