/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.juc.block.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueueDemo
 * 使用数组结构的阻塞队列
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-22
 */
public class ArrayBlockingQueueDemo {

    private static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(20);

    public static void main(String[] args) {
        for (int i= 0; i < 20; i++) {
            queue.add(i);
        }

        // 如果获取不到元素，直接返回 null
        // 返回 null 有三个点：
        // 1. println 遇到 null 元素会直接返回 null 字符串
        // 1. String 遇到 null 元素会直接返回 null 字符串
        // 1. Integer 遇到 null 元素会直接返回 null 字符串
        for (int i = 0; i < 22; i ++) {
            new Thread(() -> System.out.println(queue.poll())).start();
        }


    }
}