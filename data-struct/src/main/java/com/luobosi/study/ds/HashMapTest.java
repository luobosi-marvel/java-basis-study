/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.ds;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * HashMapTest
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-27
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<Integer, Integer> platformValue = Maps.newHashMap();
        List<Marvel> marvels = Lists.newArrayList();

        List<Integer> value1 = Arrays.asList(1, 2, 1, 2, 3);
        List<Integer> value2 = Arrays.asList(4, 3, 2, 5, 3);
        List<Integer> value3 = Arrays.asList(3, 4, 8, 2, 7);
        List<Integer> value4 = Arrays.asList(2, 1, 1, 6, 3);

        Marvel marvel1 = new Marvel();
        Marvel marvel2 = new Marvel();
        Marvel marvel3 = new Marvel();
        Marvel marvel4 = new Marvel();

        marvel1.setPlatform(value1);
        marvel2.setPlatform(value2);
        marvel3.setPlatform(value3);
        marvel4.setPlatform(value4);

        marvels.add(marvel1);
        marvels.add(marvel2);
        marvels.add(marvel3);
        marvels.add(marvel4);


        marvels.forEach(marvel -> {
            marvel.getPlatform().forEach(platform -> {
                if (platformValue.containsKey(platform)) {
                    platformValue.put(platform, platformValue.get(platform) + 1);
                } else {
                    platformValue.put(platform, 1);
                }
            });
        });

        Set<Map.Entry<Integer, Integer>> entries = platformValue.entrySet();
        for (Map.Entry entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}