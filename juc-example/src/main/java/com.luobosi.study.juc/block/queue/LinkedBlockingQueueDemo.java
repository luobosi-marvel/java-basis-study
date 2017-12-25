/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.juc.block.queue;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LinkedBlockingQueueDemo
 * 测试 LinkedBlockingQueue 的弱一致的迭代器
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-25
 */
public class LinkedBlockingQueueDemo {

    public static void main(String[] args) {
        LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>();
        strings.offer("a");
        strings.offer("b");
        strings.offer("c");

        new Thread(() -> {
            Iterator<String> iterator = strings.iterator();
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }).start();

        for (int i = 0; i < 3; i ++) {
            new Thread(() -> {
                System.out.println(strings.poll());
            }).start();
        }

    }

}