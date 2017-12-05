/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.reflect;

/**
 * GetClass
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-05
 */
public class GetClass {

    /**
     * 对于反射而言一般都要操作最多的是：构造函数，字段，方法
     * 1.创建class对象的三种方式：
     * (1)用类.class();
     * (2)用对象.getClass();
     * (3)用class.forName();的方式
     *
     * @throws Exception 如果没有找到指定的类则抛出该异常
     */
    public static void main(String[] args) throws Exception{
        Class<String> stringClass = String.class;
        System.out.println("String.class : " + stringClass);
        // 对象 .getClass()
        Class<? extends String> aClass = new String().getClass();
        System.out.println("对象 .getClass() : " + aClass);
        // 使用 forName()
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println("Class.forName(\"java.lang.String\") : " + clazz);
    }
}