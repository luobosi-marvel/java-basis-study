/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.study.ds;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * ArrayListTest
 *
 * @author luobosi@2dfire.com
 * @since 2018-01-22
 */
public class ArrayListTest {

    /** 初始化一个集合 */
    private static List<Integer> integers = Lists.newArrayList(1, 2, 2, 3, 4, 25);

    /**
     * 使用 main 方法调用
     * @param args
     */
    public static void main(String[] args) {
//        remove();
//        foreachRemove();
//        foreachRemove2();
//        iteratorRemove();
//        iteratorRemove2();
//        removeEven();
        correctRemove();
        // 遍历集合
        integers.stream().forEach(System.out::println);
    }

    /**
     * remove(int index)、remove(Object o) 猜猜下面删除的到底是哪个元素
     */
    static void remove() {
        // 在这里，25 不会自动装箱，表示的还是索引值
        integers.remove(25);
    }

    /**
     * 使用 foreach 循环，删除指定元素，两个元素都出现在元素中的前几个
     */
    static void foreachRemove() {
        for (Integer integer : integers) {
            if (Integer.valueOf(1).equals(integer)) {
                integers.remove(integer);
            }
            if (Integer.valueOf(2).equals(integer)) {
                integers.remove(integer);
            }
        }
    }

    /**
     * 使用 foreach 循环，删除指定元素，两个元素是集合中最后两个
     */
    static void foreachRemove2() {
        for (Integer integer : integers) {
            if (Integer.valueOf(3).equals(integer)) {
                integers.remove(integer);
            }
            if (Integer.valueOf(4).equals(integer)) {
                integers.remove(integer);
            }
        }
    }

    /**
     * 使用迭代器删除指定元素，两个元素都出现在元素中的前几个
     */
    static void iteratorRemove() {
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (Integer.valueOf(1).equals(next)) {
                integers.remove(next);
            }
            if (Integer.valueOf(2).equals(next)) {
                integers.remove(next);
            }
        }
    }

    /**
     * 使用迭代器删除指定元素，删除指定元素，两个元素是集合中最后两个
     */
    static void iteratorRemove2() {
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (Integer.valueOf(4).equals(next)) {
                integers.remove(next);
            }
            if (Integer.valueOf(25).equals(next)) {
                integers.remove(next);
            }
        }
    }


    /**
     * 删除集合中的偶数
     */
    static void removeEven() {
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) % 2 == 0) {
                integers.remove(i);
            }
        }
    }


    static void size() {
        // size 只会计算一次
        for (int i = 0; i < integers.size(); i++) {
            integers.add(i);
        }
    }


    static void correctRemove() {
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (Integer.valueOf(1).equals(next)) {
                iterator.remove();
            }
            if (Integer.valueOf(2).equals(next)) {
                iterator.remove();
            }
        }
    }

    static void revoew(int i) {
        System.out.println("我是普通变量");
    }
    static void revoew(Integer i) {
        System.out.println("我是对象");
    }
}

