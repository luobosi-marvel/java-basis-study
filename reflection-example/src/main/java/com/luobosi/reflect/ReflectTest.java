/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.reflect;


import com.luobosi.reflect.model.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ReflectTest
 * 反射的练习
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-05
 */
public class ReflectTest {

    /**
     * 通过反射获取方法的调用
     *
     * @throws Exception 异常
     */
    @Test
    public void testGetMethod() throws Exception {
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

    /**
     * 通过反射获取main方法
     *
     * @throws Exception 异常
     */
    @Test
    public void testGetMain() throws Exception{
        Class classPerson = Class.forName("com.luobosi.reflect.model.Person");
        Constructor conPerson = classPerson.getConstructor(null);
        Person person = (Person) conPerson.newInstance(null);
        // 获取main方法
        Method method = classPerson.getDeclaredMethod("main", String[].class);
        /**
         * 特别要注意：
         * 在反射main方法时，编译器会将数组自动拆分，取第一个值
         * 对此一般有两种方案
         */
        // 第一种方案：
        // method.invoke(person, (Object)new String[]{"国色天香","21","女"});
        // 第二种方案：
        method.invoke(person,new Object[]{new String[]{"国色天香","21","女"}});
    }


}