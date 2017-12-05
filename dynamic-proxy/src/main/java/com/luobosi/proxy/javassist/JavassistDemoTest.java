/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.proxy.javassist;

import javassist.*;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static javassist.Modifier.PUBLIC;

/**
 * JavassistDemo
 * 使用 Javassist 的小栗子
 * @author luobosi@2dfire.com
 * @since 2017-12-05
 */
public class JavassistDemoTest {

    private static ClassLoader getLocaleClassLoader() throws Exception {
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

    /**
     * 修改类方法
     *
     * @throws Exception 抛出异常
     */
    @Test
    public void testModifyMethod() throws Exception {
        // 获取本地类加载器
        ClassLoader classLoader = getLocaleClassLoader();
        // 获取要修改的类
        Class<?> clazz = classLoader.loadClass("com.luobosi.proxy.javassist.Subject");
        // 实例化类型池对象
        ClassPool classPool = ClassPool.getDefault();
        // 设置类搜索路径
        classPool.appendClassPath(new ClassClassPath(clazz));
        // 从类型池中读取指定类型
        CtClass ctClass = classPool.get(clazz.getName());
        // 获取 String 类型参数集合
        CtClass[] paramTypes = {classPool.get(String.class.getName())};
        // 获取指定方法名称
        CtMethod method = ctClass.getDeclaredMethod("show", paramTypes);
        // 复制方法到新方法中
        CtMethod newMethod = CtNewMethod.copy(method, ctClass, null);
        // 修改源方法名称
        String oldName = method.getName() + "$Impl";
        method.setName(oldName);
        // 修改原方法
        newMethod.setBody("{System.out.println(\"执行前\");" + oldName + "($$);System.out.println(\"执行后\");}");
        // 将新方法添加到类中
        ctClass.addMethod(newMethod);
        // 加载重新编译的类     注意：这一行会将类冻结，无法在对字节码进行编辑
        clazz = ctClass.toClass();
        // 执行方法
        clazz.getMethod("show", String.class).invoke(clazz.newInstance(), "hello");
        // 解冻一个类，对应 freeze 方法
        ctClass.defrost();
    }

    /**
     * 动态创建类
     *
     * @throws Exception 异常
     */
    @Test
    public void testDynamicCreateClass() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        // 创建一个类
        CtClass ctClass = classPool.makeClass("com.luobosi.proxy.javassist.DynamicClass");
        // 为类设置字段
        CtField field = new CtField(classPool.get(String.class.getName()), "value", ctClass);
        // 将字段类型设置为私有
        field.setModifiers(Modifier.PRIVATE);
        // 添加 getter 和 setter 方法
        ctClass.addMethod(CtNewMethod.setter("setValue", field));
        ctClass.addMethod(CtNewMethod.getter("getValue", field));
        ctClass.addField(field);

        // 添加自定义方法
        CtMethod runMethod = new CtMethod(CtClass.voidType, "run", new CtClass[]{}, ctClass);
        runMethod.setModifiers(PUBLIC);
        String methodBody = "{System.out.println(this.value);}";
        runMethod.setBody(methodBody);
        ctClass.addMethod(runMethod);

        // 为类设置构造器
        // 设置无参数的构造方法
        CtConstructor constructor = new CtConstructor(null, ctClass);
        constructor.setModifiers(PUBLIC);
        constructor.setBody("{}");
        ctClass.addConstructor(constructor);
        // 参数构造器
        constructor = new CtConstructor(new CtClass[]{classPool.get(String.class.getName())}, ctClass);
        constructor.setModifiers(PUBLIC);
        constructor.setBody("{this.value = $1;}");
        ctClass.addConstructor(constructor);

        // 加载和执行生成的类
        Class<?> clazz = ctClass.toClass();
        Object instance = clazz.newInstance();
        // 调用生成的方法
        clazz.getMethod("setValue", String.class).invoke(instance, "hello");
        clazz.getMethod("run").invoke(instance);

        instance = clazz.getConstructor(String.class).newInstance("OK");
        clazz.getMethod("run").invoke(instance);
    }

    /**
     * 创建代理类
     *
     * @throws Exception 异常
     */
    @Test
    public void testCreateProxyClass() throws Exception {
        // 实例化代理类工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        // 设置父类，ProxyFactory 将会动态生成一个类，继承该父类
        proxyFactory.setSuperclass(Subject.class);
        // 设置过滤器，判断哪些方法调用需要被拦截
        proxyFactory.setFilter( (method) -> method.getName().startsWith("get") );

        Class<?> clazz = proxyFactory.createClass();
        Subject subject = (Subject) clazz.newInstance();

        // 这里就是代理的方法具体实现，也就是拦截处理器
        ((ProxyObject)subject).setHandler((self, thisMethod, proceed, args) -> {
            // 拦截后前置处理， 改写 username 属性的内容
            // 根据实际情况可自行修改
            System.out.println(thisMethod.getName() + "被调用");
            try {
                // 获取方法调用后的返回值
                Object ret = proceed.invoke(self, args);
                System.out.println("返回值：" + ret);
                return ret;
            } finally {
                // 拦截后置处理
                System.out.println(thisMethod.getName() + "调用完毕");
            }
        });

        subject.setUsername("marvel");
        subject.setPassword("123456");
        subject.getUsername();
        subject.getPassword();
    }


    /**
     * 将生成的 class 文件保存到文件中
     *
     * @param ctClass class 对象
     * @param path    将要生成文件的路径
     */
    public void writeClassToFile(CtClass ctClass, String path) throws IOException, CannotCompileException {
        byte[] bytes = ctClass.toBytecode();
        FileOutputStream outputStream = new FileOutputStream(new File(path));
        outputStream.write(bytes);
        outputStream.close();
    }
}