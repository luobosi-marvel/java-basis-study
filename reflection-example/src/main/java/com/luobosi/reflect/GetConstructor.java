/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.reflect;

import com.luobosi.reflect.model.Person;

import java.lang.reflect.Constructor;

/**
 * GetConstructor
 * 通过反射得到构造函数
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-05
 */
public class GetConstructor {


    public static void main(String[] args) throws Exception {
        // 1. 获得 class 对象
        Class<?> classPerson = Class.forName("com.luobosi.reflect.model.Person");
        Class<?> classPerson1 = Class.forName("com.luobosi.reflect.model.Person");
        // 2. 得到对应的构造器
        // ① 获取 Person 对象的所对应的类的全部的 public 的构造器
        Constructor<?>[] constructors = classPerson.getConstructors();

        System.out.println(constructors);
        System.out.println();
        System.out.println("-------------------------->");

        for (Constructor constructor : constructors) {
            System.out.println("constructor:"+constructor);
        }
        System.out.println();
        System.out.println("-------------------------->");

        // ② 获取person对象所对应类的全部构造器
        Constructor[] persons = classPerson1.getDeclaredConstructors();

        System.out.println("person:"+persons);
        System.out.println();
        System.out.println("-------------------------->");

        // 3.① 获取带参数的构造函数
        Constructor conPerson1 =  classPerson1.getConstructor(String.class, Integer.class, String.class);
        //   ② 获取无参数的构造函数
        Constructor conPerson2 = classPerson1.getConstructor(null);
        // 4.① 创建一个带参数的实例
        Person person1 = (Person) conPerson1.newInstance("国色天香", 20, "女");
        //   ② (2)创建无参数的实例
        Person person2 = (Person) conPerson2.newInstance(null);
        // 通过实例对象调用 show()方法
        person1.show("国色天香");
        person2.show();
    }
}