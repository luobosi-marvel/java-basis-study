/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.reflect;

import com.luobosi.reflect.model.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * GetMainMethod
 * 通过反射获取main方法
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-05
 */
public class GetMainMethod {

    public static void main(String[] args) throws Exception{
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