/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.juc.lock;

import com.luobosi.common.constant.Constants;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierDemo
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-27
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, ()-> System.out.println("到齐了，开会"));

        for (int i = 0; i < Constants.ConstantNumber.FIVE; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(1000L);
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "marvelous" + i).start();
        }
    }

}