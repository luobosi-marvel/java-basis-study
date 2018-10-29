/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.context;

import com.marvel.rs.wolverine.annotation.Component;
import com.marvel.rs.wolverine.annotation.Service;
import com.marvel.rs.wolverine.util.FilePathUtil;
import com.marvel.rs.wolverine.util.IocUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * IocContext
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-21
 */
public class IocContext {

    /**
     * 通过 key 获取所有初始化的 对象
     */
    public static final Map<Class<?> /* 使用了 @Component 和 @Service 注解的类类型*/, Object> applicationContext = new ConcurrentHashMap<>();


    static {
        // 这里可以通过 @ScanComponent 注解注入 后期优化
        String packageName = "com.marvel.rs";
        try {
            initBean(packageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化 bean
     *
     * @param packageName 包路径名称
     */
    private static void initBean(String packageName) {
        List<Class> classList = new ArrayList<>();
        // 获取所有的 class 类
        FilePathUtil.getPathClassToList(packageName, classList);
        // 把被注解标示的类放入 map 里面
        addClassByAnnotation(classList);
        //IOC实现， 自定注入
        IocUtil.injectComponent();
    }


    /**
     * 获取指定包路径下实现 Component 主键 Bean 的实例
     */
    private static void addClassByAnnotation(List<Class> classList) {
        classList.forEach(clazz -> {
            //判断该类是否实现了注解
            if (clazz.isAnnotationPresent(Component.class) || clazz.isAnnotationPresent(Service.class)) {
                try {
                    applicationContext.put(clazz, clazz.newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
