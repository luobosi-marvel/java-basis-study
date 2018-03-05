/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Customer
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-05
 */
public class Customer implements Serializable {
    /**
     * 用于计算 Customer 对象的数目
     */
    private static int count;

    private static final int MAX_COUNT = 1000;
    /**
     * 名字
     */
    private String name;
    /**
     * 密码
     */
    private String password;

    static {
        System.out.println("调用 customer 类的静态代码块");
    }

    public Customer() {
        System.out.println("调用 customer 的不带参数的构造方法");
        count++;
    }

    public Customer(String name, String password) {
        System.out.println("调用 customer 的带参数的构造方法");
        this.name = name;
        this.password = password;
        count++;
    }

    /**
     * 加密数组，将 buffer 数组中的每个字节的每一位取反
     *
     * @param buffer 字节数组
     * @return
     */
    private byte[] change(byte[] buffer) {
        for (int i = 0; i < buffer.length; i++) {
            int b = 0;
            for (int j = 0; j < 8; j++) {
                int bit = ((buffer[i] >> j) & 1) == 0 ? 1 : 0;
                b += (1 << j) * bit;
            }
            buffer[i] = (byte) b;
        }
        return buffer;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        // 先按默认方式序列化
        stream.defaultWriteObject();
        stream.writeObject(change(password.getBytes()));
        stream.writeInt(count);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        // 先按默认方式反序列化
        stream.defaultReadObject();
        byte[] buffer = (byte[]) stream.readObject();
        password = new String(change(buffer));
        count = stream.readInt();
    }
}