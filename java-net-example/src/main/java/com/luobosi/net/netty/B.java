/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.netty;

import java.util.*;

/**
 * B
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-10
 */
public class B extends A {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sout() {
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        // 默认情况，TreeMap按key升序排序
        Map<String, Integer> map = new TreeMap<>();
        map.put("acb1", 5);
        map.put("bac1", 3);
        map.put("bca1", 20);
        map.put("cab1", 80);
        map.put("cba1", 1);
        map.put("abc1", 5);
        map.put("abc2", 12);

        // 升序比较器
        Comparator<Map.Entry<String, Integer>> valueComparator = Comparator.comparingInt(Map.Entry::getValue);
        // map转换成list进行排序
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        // 排序
        Collections.sort(list,valueComparator.reversed());
        System.out.println("------------map按照value升序排序--------------------");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                '}';
    }
}