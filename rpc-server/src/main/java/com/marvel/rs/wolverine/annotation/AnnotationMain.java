/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.annotation;

/**
 * AnnotationMain
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-21
 */
public class AnnotationMain {
    public static void main(String[] args) {

        try {
            Class<?> clazz = Class.forName("com.marvel.rs.wolverine.impl.UserServiceImpl");
            // 这里注意，一个类上面肯定不止一个注解，后期可以考虑优化
            boolean exist = clazz.isAnnotationPresent(Service.class);
            // 如果存在
            if (exist) {
                Service annotation = clazz.getAnnotation(Service.class);
                System.out.println(annotation.value());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
