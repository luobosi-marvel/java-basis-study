/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.jre;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * RxJavaDemo4
 *
 * @author luobosi@2dfire.com
 * @since 2018-09-05
 */
public class RxJavaDemo4 {

    public static void main(String[] args) {
        RxJavaDemo4 rxJavaDemo4 = new RxJavaDemo4();
        rxJavaDemo4.fun1();
    }

    private void fun1() {
        Observable.just("HELLO WORLD")
                .subscribeOn(Schedulers.single())
                .map(s -> {
                    s = s.toLowerCase();
                    System.out.println("map1 " + s);
                    return s;
                })
                .observeOn(Schedulers.io())
                .map(s -> {
                    s = s + "tony.";
                    System.out.println("map2 " + s);
                    return s;
                })
                .subscribeOn(Schedulers.computation())
                .map(s -> {
                    s = s + "it is a test.";
                    System.out.println("map3 " + s);
                    return s;
                })
                .observeOn(Schedulers.newThread())
                .subscribe(System.out::println);
    }
}