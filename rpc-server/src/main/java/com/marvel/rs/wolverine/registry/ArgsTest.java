/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.registry;

import java.util.HashSet;
import java.util.Set;

/**
 * ArgsTest
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-22
 */
public class ArgsTest {

    public static void main(String[] args) {



        Set<String> redisOrderIds = new HashSet<String>() {
            private static final long serialVersionUID = -8927344377347398783L;

            {
                add("order1");
                add("order2");
                add("order3");
            }
        };
        String[] values = new String[redisOrderIds.size()];

        redisOrderIds.toArray(values);

        test(values);
    }

    private static void test(String... value) {
        for (int i = 0; i < value.length; i++) {
            System.out.println(value[i]);
        }
    }
}
