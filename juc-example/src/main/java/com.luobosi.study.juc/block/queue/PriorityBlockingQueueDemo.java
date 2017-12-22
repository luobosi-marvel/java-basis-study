/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.juc.block.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * PriorityBlockingQueueDemo
 * 优先级的阻塞队列
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-22
 */
public class PriorityBlockingQueueDemo {

    public static void main(String[] args) {
        PriorityBlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>(12);

        priorityBlockingQueue.add("abcd");
        priorityBlockingQueue.add("abce");
        priorityBlockingQueue.add("abck");
        priorityBlockingQueue.add("abcf");
        priorityBlockingQueue.add("abcg");
        priorityBlockingQueue.add("abcg");
        priorityBlockingQueue.add("abci");
        priorityBlockingQueue.add("abcg");

        // 下面这个遍历方式是错误的，这个是我自己写代码不注意，因为 poll 操作是删除第一个元素并返回，所以 size 是不断变小的
        // 所以明明有八个元素，却偏偏只输出了四个元素。
        // for (int i=0; i < priorityBlockingQueue.size(); i++) {
        //    System.out.println("item: " + priorityBlockingQueue.poll());
        //}

        // 正确遍历方式
        for (String s : priorityBlockingQueue) {
            System.out.println(s);
        }

    }

}