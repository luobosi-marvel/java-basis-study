/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.reflect;

import com.luobosi.reflect.model.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * GetPrivateField
 * 通过反射过去私有字段
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-05
 */
public class GetPrivateField {

    public static void main(String[] args) throws Exception {
        // 1. 获取 Class 对象
        Class<?> classPerson = Class.forName("com.luobosi.reflect.model.Person");
        // 2. 获取构造函数
        Constructor<?> constructor = classPerson.getConstructor(null);
        // 3. 创建一个实例
        Person person = (Person) constructor.newInstance(null);
        // 4. 根据字段名获取字段对象
        Field username = classPerson.getDeclaredField("username");
        // 设置私有属性可以访问
        username.setAccessible(true);
        username.set(person, "marvel");

        System.out.println("名字：" + person.getUsername());
    }
}