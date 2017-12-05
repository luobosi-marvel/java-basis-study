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
     * 对于反射而言一般都要操作最多的是：构造函数，字段，方法
     * 1.创建class对象的三种方式：
     * (1)用类.class();
     * (2)用对象.getClass();
     * (3)用class.forName();的方式
     *
     * @throws ClassNotFoundException 如果没有找到指定的类则抛出该异常
     */
    @Test
    public void testGetClass() throws ClassNotFoundException {
        Class<String> stringClass = String.class;
        System.out.println("String.class : " + stringClass);
        // 对象 .getClass()
        Class<? extends String> aClass = new String().getClass();
        System.out.println("对象 .getClass() : " + aClass);
        // 使用 forName()
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println("Class.forName(\"java.lang.String\") : " + clazz);
    }

    /**
     * 通过反射得到构造函数
     *
     * @throws Exception 抛出异常
     */
    @Test
    public void testGetConstructor() throws Exception {
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

    /**
     * 通过反射获取私有属性
     *
     * @throws Exception 抛出异常
     */
    @Test
    public void testGetPrivateField() throws Exception {
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