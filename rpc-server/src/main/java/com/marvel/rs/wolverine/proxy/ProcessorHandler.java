/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.proxy;

import com.luobosi.common.request.RpcRequest;
import com.marvel.rs.wolverine.context.IocContext;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * ProcessorHandler
 *
 * @author luobosi@2dfire.com
 * @since 2018-10-20
 */
public class ProcessorHandler implements Runnable {

    private Socket socket;

    public ProcessorHandler(Socket socket) {
        this.socket = socket;
    }

    public ProcessorHandler() {
    }

    @Override
    public void run() {
        System.out.println("开始处理客户端的请求");

        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest request = (RpcRequest) inputStream.readObject();
            Object object = invoke(request);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(object);
            outputStream.flush();

            outputStream.close();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Object invoke(RpcRequest request) {
        // 拿到请求的所有参数
        Object[] args = request.getParameters();
        // 拿到参数的请求类型
        Class<?>[] types = new Class[args.length];
        Object result = null;

        for (int i = 0; i < args.length; i++) {
            types[i] = args[i].getClass();
        }

        try {
            // 通过全限定名称拿到 class 类对象
            Class<?> clazz = Class.forName(request.getClassName());
            Method method = clazz.getMethod(request.getMethodName(), types);
            // 从 IocContext 的 applicationContext map 中拿到 class 的对象
            result = method.invoke(IocContext.applicationContext.get(clazz), args);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }



}
