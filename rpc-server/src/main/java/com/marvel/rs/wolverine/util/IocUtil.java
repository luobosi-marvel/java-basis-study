/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.util;

import com.marvel.rs.wolverine.annotation.Inject;
import com.marvel.rs.wolverine.annotation.Service;
import com.marvel.rs.wolverine.context.IocContext;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * IocUtil
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-21
 */
public class IocUtil {

    /**
     * 这里执行所有的 类注入操作
     * todo：处理循环依赖问题，后期优化
     */
    public static void injectComponent() {
        Map<Class<?>, Object> applicationContext = IocContext.applicationContext;
        try {
            for (Map.Entry<Class<?>, Object> entry : applicationContext.entrySet()) {
                // 直接通过 类类型来注入
                Class<?> clazz = entry.getKey();
                Object obj = entry.getValue();
                // 获取类里面的字段
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Inject.class)) {
                        Class<?> fieldClazz = field.getType();
                        // 私有属性，要打开权限开关，不然会报错
                        field.setAccessible(true);
                        Object fieldObj = applicationContext.get(fieldClazz);
                        if (fieldObj == null) {
                            throw new RuntimeException("找不大这个类" + fieldClazz);
                        }
                        // 通过反射给对象设置值
                        field.set(obj, fieldObj);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
