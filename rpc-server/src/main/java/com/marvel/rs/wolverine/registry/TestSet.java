/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.rs.wolverine.registry;

import java.util.HashSet;
import java.util.Set;

/**
 * TestSet
 *
 * @author luobosi@2dfire.com
 * @since 2018-11-21
 */
public class TestSet {

    public static void main(String[] args) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> solrOrderIds = new HashSet<Integer>() {
            private static final long serialVersionUID = -7005878590587401025L;

            {
                add(1);
                add(3);
                add(4);
                add(5);
                add(6);
            }
        };

        Set<Integer> redisOrderIds = new HashSet<Integer>() {
            private static final long serialVersionUID = -8927344377347398783L;

            {
                add(1);
                add(2);
                add(3);
            }
        };

        result.clear();
        result.addAll(solrOrderIds);
        result.retainAll(redisOrderIds);
        System.out.println("交集：" + result);

        result.clear();
        result.addAll(redisOrderIds);
        result.removeAll(solrOrderIds);
        System.out.println("差集：" + result);

        result.clear();
        result.addAll(solrOrderIds);
        result.addAll(redisOrderIds);
        System.out.println("并集：" + result);

    }
}
