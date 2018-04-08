/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.juc.ticket;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * xunhuan
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-19
 */
public class XunHuan {
    private static final int HUNDRED = 100;

    public static void main(String[] args) {

        List<Integer> list = Lists.newArrayList();
        add(list);

        int n = list.size() / 100;
        for (int i = 0; i <= n; i++ ) {
            List<Integer> messageList = null;
            if (i == n) {
                messageList = list.subList(i * HUNDRED, list.size());
            } else {
                messageList = list.subList(i * HUNDRED, (i + 1) * 100);
            }
            System.out.println(messageList);
        }
    }

    private static void add(List<Integer> list) {
        for (int i = 0; i < 1342; i ++) {
            list.add(i);
        }
    }

}