/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.proxy.javassist;

import com.google.common.collect.Lists;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.Modifier;
import javassist.NotFoundException;
import org.junit.Test;

import java.net.URL;
import java.util.List;

/**
 * JavassistDemo
 * 使用 Javassist 的小栗子
 * @author luobosi@2dfire.com
 * @since 2017-12-05
 */
public class JavassistDemo {

    private static ClassLoader getLocaleClassLoader() throws Exception {
        List<URL> classPathURLs = Lists.newArrayList();

        // classPathURLs.add()
        // lib
        return null;
    }

    /**
     * 这里通过 Javassist 获取类型信息
     *
     * @throws NotFoundException  可能指定的类型找不到，则直接抛出异常
     */
    @Test
    public void test() throws NotFoundException {
        // 获取默认类型池对象
        ClassPool classPool = ClassPool.getDefault();
        // 获取指定类型
        CtClass ctClass = classPool.get("java.lang.String");
        // 获取包名
        System.out.println(ctClass.getName());
        // 获取包名
        System.out.println(ctClass.getPackageName());
        // 获取限定符和简要类名
        System.out.println(Modifier.toString(ctClass.getModifiers()) + " class " + ctClass.getSimpleName());
        // 获取超类
        System.out.println("extends " + ctClass.getSuperclass().getName());
        // 获取接口
        if (ctClass.getInterfaces() != null) {
            System.out.println(" implements ");
            boolean first = true;
            for (CtClass c : ctClass.getInterfaces()) {
                if (first) {
                    first = false;
                } else {
                    System.out.print(", ");
                }
                System.out.print(c.getName());
            }
        }
        System.out.println();
    }

}