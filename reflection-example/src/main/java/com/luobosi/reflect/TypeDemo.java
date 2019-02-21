/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * TypeDemo
 *
 * ParameterizedType
 *
 * 1. Type getRawType(): 返回承载该泛型信息的对象, 如上面那个Map<String, String>承载范型信息的对象是Map
 * 2. Type[] getActualTypeArguments(): 返回实际泛型类型列表, 如上面那个Map<String, String>实际范型列表中有两个元素, 都是String
 * 3. Type getOwnerType(): 返回是谁的member.(上面那两个最常用)
 *
 * @author luobosi@2dfire.com
 * @since 2019-02-21
 */
public class TypeDemo {

    Map<String, String> map;

    public static void main(String[] args) throws NoSuchFieldException {
        Field field = TypeDemo.class.getDeclaredField("map");

        System.out.println(field.getGenericType());
        System.out.println(field.getGenericType() instanceof ParameterizedType);

        ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
        // 返回承载该泛型信息的对象, 如上面那个Map<String, String>承载范型信息的对象是Map
        System.out.println("getRawType:" + parameterizedType.getRawType());
        for (Type type:
             parameterizedType.getActualTypeArguments()) {
            System.out.println(type);
        }

        System.out.println(parameterizedType.getOwnerType());
    }
}
