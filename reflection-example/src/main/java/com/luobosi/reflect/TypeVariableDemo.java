/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.reflect;

import sun.jvm.hotspot.utilities.Assert;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * TypeVariableDemo
 *
 * 类型变量, 范型信息在编译时会被转换为一个特定的类型, 而
 * TypeVariable
 * 就是用来反映在JVM编译该泛型前的信息.
 *
 * TypeVariable是指在 GenericDeclaration 中声明的 <T>、<C extends Collection> 这些东西中的那个变量 T、C
 * ; 它有如下方法:
 *
 * 1. Type[] getBounds(): 获取类型变量的上边界, 若未明确声明上边界则默认为Object
 * 2. D getGenericDeclaration(): 获取声明该类型变量实体
 * 3. String getName(): 获取在源码中定义时的名字
 * 注意:
 * * 类型变量在定义的时候只能使用extends进行(多)边界限定, 不能用super;
 * * 为什么边界是一个数组? 因为类型变量可以通过&进行多个上边界限定，因此上边界有多个
 *
 * @author luobosi@2dfire.com
 * @since 2019-02-21
 */
public class TypeVariableDemo <K extends  Comparable & Serializable, V> {

    K key;

    V value;

    public static void main(String[] args) throws NoSuchFieldException {
        // 获取字段类型
        Field fk = TypeVariableDemo.class.getDeclaredField("key");
        Field fv = TypeVariableDemo.class.getDeclaredField("value");

        Assert.that(fk.getGenericType() instanceof TypeVariable, "必须为 TypeVariable 类型");
        Assert.that(fv.getGenericType() instanceof TypeVariable, "必须为 TypeVariable 类型");

        TypeVariable ketType = (TypeVariable) fk.getGenericType();
        TypeVariable valueType = (TypeVariable) fv.getGenericType();

        // getName 方法
        System.out.println(ketType.getName());
        System.out.println(valueType.getName());

        // getGenericDeclaration 方法
        // class com.luobosi.reflect.TypeVariableDemo
        // class com.luobosi.reflect.TypeVariableDemo
        System.out.println(ketType.getGenericDeclaration());
        System.out.println(valueType.getGenericDeclaration());

        // getBounds 方法
        // interface java.lang.Comparable、interface java.io.Serializable
        System.out.println("K 的上界");
        for (Type type: ketType.getBounds()) {
            System.out.println(type);
        }

        System.out.println("V 的上界");
        for (Type type: valueType.getBounds()) {
            System.out.println(type);
        }

    }

}
